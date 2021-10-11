package cn.moquan.service;

import cn.moquan.bean.item.Item;
import cn.moquan.bean.link.ItemNurse;
import cn.moquan.bean.nurse.Nurse;
import cn.moquan.dao.ItemNurseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemNurseService {

    @Autowired
    ItemNurseDao itemNurseDao;

    public boolean add(ItemNurse itemNurse) {
        return itemNurseDao.add(itemNurse);
    }

    public boolean del(ItemNurse itemNurse) {
        return itemNurseDao.del(itemNurse);
    }

    public List<Nurse> getNurseByItemId(int itemId) {
        return itemNurseDao.getNurseByItemId(itemId);
    }

    public List<Item> getItemByNurseId(int nurseId) {
        return itemNurseDao.getItemByNurseId(nurseId);
    }

    public List<Nurse> whoWillNotThisItem(int itemId) {
        return itemNurseDao.whoWillNotThisItem(itemId);
    }

    public List<Item> nurseWillNotItem(int nurseId) {
        return itemNurseDao.nurseWillNotItem(nurseId);
    }
}
