package cn.moquan.dao;

import cn.moquan.bean.nurse.Nurse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NurseDao {

    boolean insertNurse(Nurse nurse);

    boolean deleteNurseById(int id);

    boolean updateNurse(Nurse nurse);

    Nurse getNurseById(int id);

    List<Nurse> getNurses();

    List<Nurse> getNurseByGender(int genderId);

    List<Nurse> getNurseByName(String name);

}
