package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import com.lambdaschool.orders.views.CustomerOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerControllers
{
    @Autowired
    private CustomerServices customerServices;
   // http://localhost:2019/customers/orders
   @GetMapping(value = "/orders")
    public ResponseEntity<?> findAllCustomers()
   {
       List<Customer> customerList = customerServices.findAllCustomers();
       return new ResponseEntity<>(customerList,
           HttpStatus.OK);
   }
//    http://localhost:2019/customers/customer/7
    @GetMapping(value = "customer/{custid}",produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long custid)
    {
        Customer customer = customerServices.findCustomerById(custid);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
//    http://localhost:2019/customers/customer/77
//    http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{subname}",produces = "application/json")
    public ResponseEntity<?> findCustomerByLikeName(@PathVariable String subname)
    {
      List<Customer> customerList = customerServices.findCustomerByLikeName(subname);
      return new ResponseEntity<>(customerList,HttpStatus.OK);
    }


//    /customers/orders/count
    @GetMapping(value = "/orders/count",produces = "application/json")
    public ResponseEntity<?> getCustomerOrdersCount()
    {
        List <CustomerOrders> customerOrders = customerServices.getCustomerOrdersCount();
        return new ResponseEntity<>(customerOrders,HttpStatus.OK);
    }
}
