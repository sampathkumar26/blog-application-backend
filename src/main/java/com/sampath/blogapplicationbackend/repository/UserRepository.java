package com.sampath.blogapplicationbackend.repository;

import com.sampath.blogapplicationbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
