package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.views.AdvanceAmount;

import java.util.List;

public interface OrderServices
{
    public Order save(Order order);

    Order findOrderById(long id);

    List<AdvanceAmount> getAdvanceAmount();
}
