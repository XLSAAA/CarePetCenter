package cn.moquan.controller;

import cn.moquan.bean.nurse.Nurse;
import cn.moquan.service.NurseService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nurse")
public class NurseController {

    @Autowired
    NurseService nurseService;


    @ResponseBody
    @RequestMapping(value = "/nurse", method = RequestMethod.POST)
    public String insertNurse(@RequestBody Nurse nurse) {

        if (nurseService.insertNurse(nurse))
            return SuccessMessage.INSERT_OK;
        else
            return SuccessMessage.INSERT_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/nurse/{id}", method = RequestMethod.DELETE)
    public String deleteNurseById(@PathVariable int id){

        if (nurseService.deleteNurseById(id))
            return SuccessMessage.DELETE_OK;
        else
            return SuccessMessage.DELETE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/nurse", method = RequestMethod.PUT)
    public String updateNurse(@RequestBody Nurse nurse){
        if (nurseService.updateNurse(nurse))
            return SuccessMessage.UPDATE_OK;
        else
            return SuccessMessage.UPDATE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/nurse/{id}", method = RequestMethod.GET)
    public Nurse getNurseById(@PathVariable int id){
        return nurseService.getNurseById(id);
    }

    @ResponseBody
    @RequestMapping("/nurses")
    public List<Nurse> getAllNurse(){
        return nurseService.getNurses();
    }

    @ResponseBody
    @RequestMapping("/gender/{genderId}")
    public List<Nurse> getNurseByGender(@PathVariable int genderId){

        return nurseService.getNursesByGender(genderId);
    }


    @ResponseBody
    @RequestMapping("/name/{name}")
    public List<Nurse> getNurseByName(@PathVariable String name){
        return nurseService.getNursesByName(name);
    }


}
