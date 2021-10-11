package cn.moquan.controller;

import cn.moquan.bean.pet.Pet;
import cn.moquan.service.PetService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;


    @ResponseBody
    @RequestMapping(value = "/pet", method = RequestMethod.POST)
    public String insertPet(@RequestBody Pet pet) {

        if (petService.insertPet(pet))
            return SuccessMessage.INSERT_OK;
        else
            return SuccessMessage.INSERT_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/pet/{id}", method = RequestMethod.DELETE)
    public String deletePetById(@PathVariable int id){

        if (petService.deletePetById(id))
            return SuccessMessage.DELETE_OK;
        else
            return SuccessMessage.DELETE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/pet", method = RequestMethod.PUT)
    public String updatePet(@RequestBody Pet pet){
        if (petService.updatePet(pet))
            return SuccessMessage.UPDATE_OK;
        else
            return SuccessMessage.UPDATE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable int id){
        return petService.getPetById(id);
    }

    @ResponseBody
    @RequestMapping("/pets")
    public List<Pet> getAllPet(){
        return petService.getPets();
    }

    @ResponseBody
    @RequestMapping(value = "/master/{id}", method = RequestMethod.GET)
    public List<Pet> getAllPetByMasterId(@PathVariable("id") int MasterId ){
        return petService.getAllPetByMasterId(MasterId);
    }

}
