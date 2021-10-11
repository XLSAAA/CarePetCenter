package cn.moquan.service;

import cn.moquan.bean.nurse.Nurse;
import cn.moquan.dao.NurseDao;
import cn.moquan.util.FuzzyMatchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {

    @Autowired
    NurseDao nurseDao;

    public boolean insertNurse(Nurse nurse) {
        return nurseDao.insertNurse(nurse);
    }

    public boolean deleteNurseById(int id) {
        return nurseDao.deleteNurseById(id);
    }

    public boolean updateNurse(Nurse nurse) {
        return nurseDao.updateNurse(nurse);
    }

    public Nurse getNurseById(int id) {
        return nurseDao.getNurseById(id);
    }

    public List<Nurse> getNurses() {
        return nurseDao.getNurses();
    }

    public List<Nurse> getNursesByGender(int genderId) {
        return nurseDao.getNurseByGender(genderId);
    }

    public List<Nurse> getNursesByName(String name) {
        return nurseDao.getNurseByName(FuzzyMatchUtil.fuzzyString(name));
    }
}
