package com.sampath.blogapplicationbackend.services.interfaces;

import com.sampath.blogapplicationbackend.dtos.PostDto;
import com.sampath.blogapplicationbackend.entity.Post;

import java.util.List;

public interface IPostService {
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    public Post updatePost(PostDto postDto, Integer postId);

    public void deletePost(Integer postId);

    public List<Post> getAllPost();

    public Post getPostById(Integer postId);

    public List<PostDto> getPostByCategory(Integer categoryId);
    public List<PostDto> getPostByUser(Integer userId);

    public  List<Post> searchPost(String keyword);

}
