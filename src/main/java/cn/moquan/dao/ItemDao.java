package cn.moquan.dao;

import cn.moquan.bean.item.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao {

    boolean insertItem(Item Item);

    boolean deleteItemById(int id);

    boolean updateItem(Item Item);

    Item getItemById(int id);

    List<Item> getItems();

    List<Item> getItemByName(String name);
}
