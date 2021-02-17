package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "orderServices")
public class OrderServiceImpl implements OrderServices
{
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    @Override
    public Order save(Order order)
    {
        return orderRepository.save(order);
    }

    @Override
    public Order findOrderById(long id)
    {
        Order order = orderRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order "+ id + " Not found"));
        return order;
    }

    @Override
    public List<Order> getAdvanceAmount()
    {
      List<Order> orderList = orderRepository.getWithAdvanceAmountBiggerThanZero();
      return orderList;
    }
}
