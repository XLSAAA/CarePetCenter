package cn.moquan.service;

import cn.moquan.bean.item.Item;
import cn.moquan.bean.master.Master;
import cn.moquan.bean.order.Order;
import cn.moquan.bean.order.OrderStatus;
import cn.moquan.bean.order.OrderStatusInfo;
import cn.moquan.dao.OrderDao;
import cn.moquan.util.MemberBenefitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    MailService mailService;
    @Autowired
    MasterService masterService;
    @Autowired
    ItemService itemService;

    public boolean createOrder(Order order) {

        // 扣款
        Master masterById = masterService.getMasterById(order.getMasterId());
        Item itemById = itemService.getItemById(order.getItemId());
        int vip = masterById.getVip();
        // 计算金额
        int pay = (int)Math.round(itemById.getPrice() * MemberBenefitUtil.getBenefit(vip));
        int balance =  (masterById.getBalance() - pay);

        // 检查余款
        if ((balance < 0)) {
            // 余额不足
            return false;
        } else {
            order.setPay(pay);
            // 扣款成功
            masterById.setBalance(balance);
            // 更新客户余额
            masterService.updateMaster(masterById);
            // 创建订单
            return orderDao.createOrder(order);
        }
    }

    public List<Order> getAllOrder() {
        return orderDao.getAllOrder();
    }

    public boolean updateOrderStatus(OrderStatusInfo info) {

        if (info.getStatus() != OrderStatus.SERVE_NEED) {
            Order order = new Order();
            order.setId(info.getId());
            Order getOrder = getOrderBy(order).get(0);
            if (info.getStatus() == OrderStatus.NORMAL) {
                // order id 唯一
                mailService.createMail(getOrder);

            }else if(info.getStatus() == OrderStatus.PAY_RETURN){
                // 退钱
                Master masterById = masterService.getMasterById(getOrder.getMasterId());
                masterById.setBalance(masterById.getBalance()+getOrder.getPay());
                masterService.updateMaster(masterById);
            }

            return orderDao.endOrder(info);
        } else {
            return orderDao.updateOrderStatus(info);
        }
    }

    public List<Order> getOrderBy(Order order) {
        return orderDao.getOrderBy(order);
    }
}
