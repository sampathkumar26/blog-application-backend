package com.sampath.blogapplicationbackend.repository;

import com.sampath.blogapplicationbackend.entity.Category;
import com.sampath.blogapplicationbackend.entity.Post;
import com.sampath.blogapplicationbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByUser(User user);
    List<Post> findByCategory(Category category);
}
