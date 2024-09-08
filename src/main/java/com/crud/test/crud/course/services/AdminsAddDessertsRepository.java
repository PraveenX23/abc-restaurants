package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.AdminAddDesserts;
import com.crud.test.crud.course.models.AdminAddDessertsDto;

                                              // Model name  // Type of the primary key
public interface AdminsAddDessertsRepository extends JpaRepository<AdminAddDesserts, Integer> {

    public void save(AdminAddDessertsDto adminAddDessertsDto);
    
}
