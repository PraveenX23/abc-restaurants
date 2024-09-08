package com.crud.test.crud.course.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.test.crud.course.models.AdminAddGallery;
import com.crud.test.crud.course.models.AdminAddGalleryDto;

                                              // Model name  // Type of the primary key
public interface AdminsAddGalleryRepository extends JpaRepository<AdminAddGallery, Integer> {
    public void save(AdminAddGalleryDto adminAddGalleryDto);
}
