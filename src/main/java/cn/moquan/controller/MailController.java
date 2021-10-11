package cn.moquan.controller;

import cn.moquan.bean.mail.Mail;
import cn.moquan.service.MailService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @ResponseBody
    @RequestMapping("/send")
    public String sendEMail() {

        if (mailService.sendMail()) {
            return "ALL_SEND_OK";
        } else {
            return "SOME_MAIL_SEND_FILED";
        }

    }

    @ResponseBody
    @RequestMapping(value = "/clear")
    public String clearEMail() {

        if (mailService.clear())
            return SuccessMessage.DELETE_OK;
        else
            return SuccessMessage.DELETE_FILED;
    }
    
    @ResponseBody
    @RequestMapping("/error")
    public List<Mail> getErrorMail(){
        return mailService.getErrorMail();
    }

}
