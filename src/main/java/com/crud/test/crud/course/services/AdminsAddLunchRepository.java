package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.AdminAddLunch;
import com.crud.test.crud.course.models.AdminAddLunchDto;

                                              // Model name  // Type of the primary key
public interface AdminsAddLunchRepository extends JpaRepository<AdminAddLunch, Integer> {

    public void save(AdminAddLunchDto adminAddLunchDto);
    
}
