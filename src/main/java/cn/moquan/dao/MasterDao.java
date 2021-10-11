package cn.moquan.dao;

import cn.moquan.bean.master.Master;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterDao {

    Master getMasterById(int id);

    Master getMasterByTel(String tel);

    List<Master> getAllMaster();

    boolean insertMaster(Master master);

    boolean deleteMasterById(int id);

    boolean updateMaster(Master master);

//    Master addMoney(@Param("id") int id, @Param("money") int money, @Param("vip") int vip);
    boolean addMoney(@Param("id") int id, @Param("money") int money);

    boolean pay(Master master);
}
