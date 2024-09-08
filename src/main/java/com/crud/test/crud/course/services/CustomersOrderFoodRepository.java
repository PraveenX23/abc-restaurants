package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.CustomerOrderFood;
import com.crud.test.crud.course.models.CustomerOrderFoodDto;

                                              // Model name  // Type of the primary key
public interface CustomersOrderFoodRepository extends JpaRepository<CustomerOrderFood, Integer> {

    public void save(CustomerOrderFoodDto customerOrderFoodDto);
    
}
    