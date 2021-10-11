package cn.moquan.dao;

import cn.moquan.bean.order.Order;
import cn.moquan.bean.order.OrderStatusInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    boolean createOrder(Order order);

    List<Order> getAllOrder();

    boolean updateOrderStatus(OrderStatusInfo info);

    List<Order> getOrderBy(Order order);

    boolean endOrder(OrderStatusInfo info);
}
