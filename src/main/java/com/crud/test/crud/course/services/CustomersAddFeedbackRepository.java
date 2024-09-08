package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.CustomerAddFeedback;
import com.crud.test.crud.course.models.CustomerAddFeedbackDto;

                                              // Model name  // Type of the primary key
public interface CustomersAddFeedbackRepository extends JpaRepository<CustomerAddFeedback, Integer> {

    public void save(CustomerAddFeedbackDto customerAddFeedbackDto);
    
}