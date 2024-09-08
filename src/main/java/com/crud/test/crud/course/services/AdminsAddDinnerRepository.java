package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.AdminAddDinner;
import com.crud.test.crud.course.models.AdminAddDinnerDto;

                                              // Model name  // Type of the primary key
public interface AdminsAddDinnerRepository extends JpaRepository<AdminAddDinner, Integer> {

    public void save(AdminAddDinnerDto adminAddDinnerDto);
    
}
