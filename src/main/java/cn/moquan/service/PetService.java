package cn.moquan.service;

import cn.moquan.bean.pet.Pet;
import cn.moquan.dao.PetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    PetDao petDao;

    public boolean insertPet(Pet pet) {
        return petDao.insertPet(pet);
    }

    public boolean deletePetById(int id) {
        return petDao.deletePetById(id);
    }

    public boolean updatePet(Pet pet) {
        return petDao.updatePet(pet);
    }

    public Pet getPetById(int id) {
        return petDao.getPetById(id);
    }

    public List<Pet> getPets() {
        return petDao.getPets();
    }

    public List<Pet> getAllPetByMasterId(int masterId) {
        return petDao.getAllPetByMasterId(masterId);
    }
}
