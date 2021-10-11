package cn.moquan.controller;

import cn.moquan.bean.master.AddMoneyInfo;
import cn.moquan.bean.master.Master;
import cn.moquan.service.MasterService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    MasterService masterService;

    @ResponseBody
    @RequestMapping(value = "/master/{tel}", method = RequestMethod.GET)
    public Master getMasterByTel(@PathVariable("tel") String tel) {
        return masterService.getMasterByTel(tel);
    }

    @ResponseBody
    @RequestMapping("/masters")
    public List<Master> getAllMaster() {
        return masterService.getAllMaster();
    }

    @ResponseBody
    @RequestMapping(value = "/master", method = RequestMethod.POST)
    public String insertMaster(@RequestBody Master master) {

        if (masterService.insertMaster(master))
            return SuccessMessage.INSERT_OK;
        else
            return SuccessMessage.INSERT_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/master/{id}", method = RequestMethod.DELETE)
    public String deleteMasterById(@PathVariable("id") int id){

        if (masterService.deleteMasterById(id))
            return SuccessMessage.DELETE_OK;
        else
            return SuccessMessage.DELETE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/master", method = RequestMethod.PUT)
    public String updateMaster(@RequestBody Master master){
        if (masterService.updateMaster(master))
            return SuccessMessage.UPDATE_OK;
        else
            return SuccessMessage.UPDATE_FILED;
    }

    @ResponseBody
    @RequestMapping("/addMoney")
    public String addMoney(@RequestBody AddMoneyInfo addMoneyInfo){


        if(masterService.addMoney(addMoneyInfo.getId(), addMoneyInfo.getMoney())){
            return SuccessMessage.ADD_MONEY_OK;

        }else{
            return SuccessMessage.ADD_MONEY_FILED;
        }

    }

    @ResponseBody
    @RequestMapping("/pay")
    public String pay(@RequestBody Master master){

        if(masterService.pay(master)){
            return SuccessMessage.PAY_OK;
        }else{
            return SuccessMessage.PAY_FILED;
        }

    }
}
