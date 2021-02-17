package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomersRepository;
import com.lambdaschool.orders.views.CustomerOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomerServicesImp implements CustomerServices
{
    @Autowired
    private CustomersRepository customerrep;

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        return customerrep.save(customer);
    }

    @Override
    public List<Customer> findAllCustomers()
    {
        List <Customer> customerList = new ArrayList<>();
        customerrep.findAll().iterator().forEachRemaining(customerList::add);
        return customerList;

    }

    @Override
    public Customer findCustomerById(long id)
    {
       Customer customer = customerrep.findById(id)
           .orElseThrow(()-> new EntityNotFoundException("Customer "+id+" not found"));
       return  customer;
    }

    @Override
    public List<Customer> findCustomerByLikeName(String subname)
    {
        List <Customer> customerList  = customerrep.findCustomerByCustnameContainingIgnoringCase(subname);
        return customerList;
    }

    @Override
    public List<CustomerOrders> getCustomerOrdersCount()
    {
        List <CustomerOrders> customerOrders = customerrep.getCustomerOrders();
        return customerOrders;
    }
}
