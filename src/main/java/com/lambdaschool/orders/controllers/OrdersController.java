package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.services.OrderServices;
import com.lambdaschool.orders.views.AdvanceAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController
{
    @Autowired
    private OrderServices orderServices;

    @GetMapping(value = "/order/{orderid}",produces = "application/json")
    public ResponseEntity<?> findOrderById(@PathVariable long orderid)
    {
        Order order = orderServices.findOrderById(orderid);
        return new ResponseEntity<>(order,
            HttpStatus.OK);
    }
    @GetMapping(value = "/advanceamount")
    public ResponseEntity<?> getAdvanceAmount()
    {
        List<AdvanceAmount> advanceAmounts = orderServices.getAdvanceAmount();
        return new ResponseEntity<>(advanceAmounts,HttpStatus.OK);
    }
}
