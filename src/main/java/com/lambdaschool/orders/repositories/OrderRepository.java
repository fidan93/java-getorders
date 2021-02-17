package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.views.AdvanceAmount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrderRepository extends CrudRepository<Order,Long>
{
    @Query(value = "SELECT o.*,c.custcity,c.custcountry,c.custname,c.grade,c.openingamt,c.OUTSTANDINGAMT,c.PAYMENTAMT,c.PHONE,c.RECEIVEAMT,c.WORKINGAREA,c.AGENTCODE " +
        "FROM orders o LEFT JOIN customers c " +
        "ON o.custcode = c.custcode " +
        "WHERE o.advanceamount>0",nativeQuery = true)
    List<AdvanceAmount> getWithAdvanceAmountBiggerThanZero();

}
