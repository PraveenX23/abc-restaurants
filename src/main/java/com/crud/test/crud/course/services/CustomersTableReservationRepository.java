package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.CustomerTableReservation;
import com.crud.test.crud.course.models.CustomerTableReservationDto;

                                              // Model name  // Type of the primary key
public interface CustomersTableReservationRepository extends JpaRepository<CustomerTableReservation, Integer> {

    public void save(CustomerTableReservationDto customerTableReservationDto);
    
}
    