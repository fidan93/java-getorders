package com.lambdaschool.orders.views;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.models.Payment;

import java.util.Set;

public interface AdvanceAmount
{
    long getOrdnum();
    double getOrdamount();
    double getAdvanceamount();
    Customer getCustomer();
    String getOrderdescription();
    Set<Payment> getPayments();
}
