package com.uic.webbasederp.service;

import com.uic.webbasederp.domain.po.Order;
import com.uic.webbasederp.domain.vo.OrderNumberVo;

import java.util.List;

public interface OrderService {
    void saveOrder(Order order);
    void updateOrder(Order order);
    List<Order> listOrder(int page);
    void removeOrder(int orderId);
    OrderNumberVo getOrderNumber(String startDate, String endDate) throws Exception;
}
