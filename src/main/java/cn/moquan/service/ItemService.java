package cn.moquan.service;

import cn.moquan.bean.item.Item;
import cn.moquan.dao.ItemDao;
import cn.moquan.util.FuzzyMatchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDao ItemDao;

    public boolean insertItem(Item item) {

//        System.out.println(item);

        return ItemDao.insertItem(item);
    }

    public boolean deleteItemById(int id) {
        return ItemDao.deleteItemById(id);
    }

    public boolean updateItem(Item Item) {
        return ItemDao.updateItem(Item);
    }

    public Item getItemById(int id) {
        return ItemDao.getItemById(id);
    }

    public List<Item> getItems() {
        return ItemDao.getItems();
    }

    public List<Item> getItemByName(String name) {

        return ItemDao.getItemByName(FuzzyMatchUtil.fuzzyString(name));
    }
}
