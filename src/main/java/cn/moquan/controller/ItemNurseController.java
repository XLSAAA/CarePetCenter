package cn.moquan.controller;

import cn.moquan.bean.item.Item;
import cn.moquan.bean.link.ItemNurse;
import cn.moquan.bean.nurse.Nurse;
import cn.moquan.service.ItemNurseService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/itemAndNurse")
public class ItemNurseController {

    @Autowired
    ItemNurseService itemNurseService;

    @ResponseBody
    @RequestMapping("/add")
    public String add(@RequestBody ItemNurse itemNurse) {

        if (itemNurseService.add(itemNurse)) {
            return SuccessMessage.INSERT_OK;
        } else {
            return  SuccessMessage.INSERT_FILED;
        }
    }

    @ResponseBody
    @RequestMapping("/del")
    public String del(@RequestBody ItemNurse itemNurse) {

        if (itemNurseService.del(itemNurse)) {
            return SuccessMessage.DELETE_OK;
        } else {
            return  SuccessMessage.DELETE_FILED;
        }
    }


    @ResponseBody
    @RequestMapping(value = "/nurses/{itemId}")
    public List<Nurse> getNurseByItemId(@PathVariable("itemId") int itemId){
        return itemNurseService.getNurseByItemId(itemId);
    }

    @ResponseBody
    @RequestMapping(value = "/item/{nurseId}")
    public List<Item> getItemByNurseId(@PathVariable("nurseId") int nurseId){
        return itemNurseService.getItemByNurseId(nurseId);
    }

    @ResponseBody
    @RequestMapping(value = "/nursesNot/{itemId}")
    public List<Nurse> whoWillNotThisItem(@PathVariable("itemId") int itemId){
        return itemNurseService.whoWillNotThisItem(itemId);
    }

    @ResponseBody
    @RequestMapping(value = "/itemNot/{nurseId}")
    public List<Item> nurseWillNotItem(@PathVariable("nurseId") int nurseId){
        return itemNurseService.nurseWillNotItem(nurseId);
    }
}
