package cn.moquan.controller;

import cn.moquan.bean.order.Order;
import cn.moquan.bean.order.OrderStatusInfo;
import cn.moquan.service.OrderService;
import cn.moquan.util.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String createOrder(@RequestBody Order order) {

        if (orderService.createOrder(order)) {
            return SuccessMessage.INSERT_OK;
        } else{
            return SuccessMessage.INSERT_FILED;
        }

    }

    @ResponseBody
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable("id") int orderId){
        return SuccessMessage.DELETE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public String updateOrder(@RequestBody Order order){

//        if (orderService.updateOrder(order)) {
//            return SuccessMessage.UPDATE_OK;
//        } else{
//            return SuccessMessage.UPDATE_FILED;
//        }

        return SuccessMessage.UPDATE_FILED;
    }

    @ResponseBody
    @RequestMapping(value = "/orders")
    public List<Order> getAllOrder(){
        return orderService.getAllOrder();
    }

    @ResponseBody
    @RequestMapping(value = "/by")
    public List<Order> getOrderBy(@RequestBody Order order){

        System.out.println(order);

        return orderService.getOrderBy(order);
    }
    
    @ResponseBody
    @RequestMapping("/status")
    public String updateOrderStatus(@RequestBody OrderStatusInfo info){

        if (orderService.updateOrderStatus(info)) {
            return SuccessMessage.UPDATE_OK;
        } else{
            return SuccessMessage.UPDATE_FILED;
        }
    }
}
