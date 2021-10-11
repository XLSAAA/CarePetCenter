package cn.moquan.dao;

import cn.moquan.bean.pet.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetDao {

    boolean insertPet(Pet pet);

    boolean deletePetById(int id);

    boolean updatePet(Pet pet);

    Pet getPetById(int id);

    List<Pet> getPets();

    List<Pet> getAllPetByMasterId(int masterId);
}
