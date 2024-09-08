package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.CustomerMakePayment;
import com.crud.test.crud.course.models.CustomerMakePaymentDto;

                                              // Model name  // Type of the primary key
public interface CustomersMakePaymentRepository extends JpaRepository<CustomerMakePayment, Integer> {

    public void save(CustomerMakePaymentDto customerMakePaymentDto);
    
}
