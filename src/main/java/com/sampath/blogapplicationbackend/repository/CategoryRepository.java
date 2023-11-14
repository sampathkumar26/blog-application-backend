package com.sampath.blogapplicationbackend.repository;

import com.sampath.blogapplicationbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
