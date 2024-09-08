package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.AdminAdd;
import com.crud.test.crud.course.models.AdminAddDto;

                                              // Model name  // Type of the primary key
public interface AdminsAddRepository extends JpaRepository<AdminAdd, Integer> {

    public void save(AdminAddDto adminAddDto);
    
}
