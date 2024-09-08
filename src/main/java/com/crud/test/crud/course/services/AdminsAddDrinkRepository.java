package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.AdminAddDrink;
import com.crud.test.crud.course.models.AdminAddDrinkDto;

                                              // Model name  // Type of the primary key
public interface AdminsAddDrinkRepository extends JpaRepository<AdminAddDrink, Integer> {

    public void save(AdminAddDrinkDto adminAddDrinkDto);
    
}
