package cn.moquan.service;

import cn.moquan.bean.master.Master;
import cn.moquan.dao.MasterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MasterService {

    @Autowired
    MasterDao masterDao;

    public Master getMasterByTel(String tel) {

        return masterDao.getMasterByTel(tel);

    }

    public Master getMasterById(int id) {

        return masterDao.getMasterById(id);

    }

    public List<Master> getAllMaster() {

        return masterDao.getAllMaster();
    }

    public boolean insertMaster(Master master) {
        return masterDao.insertMaster(master);
    }

    public boolean deleteMasterById(int id) {
        return masterDao.deleteMasterById(id);
    }

    public boolean updateMaster(Master master) {
        return masterDao.updateMaster(master);
    }

    public boolean addMoney(int id, int money) {

//        Master master = masterDao.getMasterById(id);

//        master.setVip(master.getVip() + money / 10);

//        return masterDao.addMoney(id, money, master.getVip());
        return masterDao.addMoney(id, money);
    }

    public boolean pay(Master master) {
        return masterDao.pay(master);
    }
}
