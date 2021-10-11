package cn.moquan.controller;

import cn.moquan.bean.item.Item;
import cn.moquan.service.ItemService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;


    @ResponseBody
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public String insertItem(@RequestBody Item item) {

        if (itemService.insertItem(item))
            return SuccessMessage.INSERT_OK;
        else
            return SuccessMessage.INSERT_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public String deleteItemById(@PathVariable int id){

        if (itemService.deleteItemById(id))
            return SuccessMessage.DELETE_OK;
        else
            return SuccessMessage.DELETE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public String updateItem(@RequestBody Item item){
        if (itemService.updateItem(item))
            return SuccessMessage.UPDATE_OK;
        else
            return SuccessMessage.UPDATE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable int id){
        return itemService.getItemById(id);
    }

    @ResponseBody
    @RequestMapping("/items")
    public List<Item> getAllItem(){
        return itemService.getItems();
    }

    @ResponseBody
    @RequestMapping("/name/{name}")
    public List<Item> getItemByName(@PathVariable("name") String name){
        return itemService.getItemByName(name);
    }

}
