package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.Product;

                                              // Model name  // Type of the primary key
public interface ProductsRepository extends JpaRepository<Product, Integer> {
    
}
