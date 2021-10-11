package cn.moquan.dao;

import cn.moquan.bean.item.Item;
import cn.moquan.bean.link.ItemNurse;
import cn.moquan.bean.nurse.Nurse;

import java.util.List;

public interface ItemNurseDao {
    boolean add(ItemNurse itemNurse);

    boolean del(ItemNurse itemNurse);

    List<Nurse> getNurseByItemId(int itemId);

    List<Item> getItemByNurseId(int nurseId);

    List<Nurse> whoWillNotThisItem(int itemId);

    List<Item> nurseWillNotItem(int nurseId);
}
