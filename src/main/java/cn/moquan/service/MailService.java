package cn.moquan.service;

import cn.moquan.bean.item.Item;
import cn.moquan.bean.mail.Mail;
import cn.moquan.bean.mail.MailStatus;
import cn.moquan.bean.master.Master;
import cn.moquan.bean.order.Order;
import cn.moquan.bean.pet.Pet;
import cn.moquan.dao.MailDao;
import cn.moquan.util.EmailUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MailService {

    @Autowired
    ItemService itemService;
    @Autowired
    MasterService masterService;
    @Autowired
    PetService petService;

    @Autowired
    MailDao mailDao;

    @Autowired
    EmailUtil emailUtil;

    public void createMail(Order order) {

        Item itemById = itemService.getItemById(order.getItemId());
        Master masterById = masterService.getMasterById(order.getMasterId());
        Pet petById = petService.getPetById(order.getPetId());

        mailDao.createMail(new Mail(masterById.getMail(), petById.getName(), itemById.getName(),
                order.getId(), itemById.getCheckoutTime() + "", MailStatus.SEND_NEED));
    }

    public boolean sendMail() {

        boolean flag = true;

        List<Mail> mails = mailDao.sendMail();

        List<Integer> normal = new ArrayList<>();
        List<Integer> error = new ArrayList<>();

        for (Mail mail : mails) {

            if (emailUtil.sendEmail(mail)) {
                normal.add(mail.getId());
            } else {
                flag = false;
                error.add(mail.getId());
            }
        }

        if (normal.size() > 0) {
            updateStatus(normal, MailStatus.SEND_OK);
        }

        if (error.size() > 0) {
            updateStatus(error, MailStatus.SEND_ERROR);
        }

        return flag;
    }

    public boolean clear() {
        return mailDao.clear();
    }

    public void updateStatus(List<Integer> mailIdList, int status) {
        mailDao.updateStatus(mailIdList, status);
    }

    public List<Mail> getErrorMail() {
        return mailDao.getErrorMail();
    }
}
