package com.sampath.blogapplicationbackend.services;

import com.sampath.blogapplicationbackend.dtos.PostDto;
import com.sampath.blogapplicationbackend.entity.Category;
import com.sampath.blogapplicationbackend.entity.Post;
import com.sampath.blogapplicationbackend.entity.User;
import com.sampath.blogapplicationbackend.execeptions.ResourceNotFoundException;
import com.sampath.blogapplicationbackend.repository.CategoryRepository;
import com.sampath.blogapplicationbackend.repository.PostRepository;
import com.sampath.blogapplicationbackend.repository.UserRepository;
import com.sampath.blogapplicationbackend.services.interfaces.IPostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImp implements IPostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user =
                this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException(
                        "user","user id",userId));
        Category category =
                this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category","catergory id",categoryId));

        Post post = this.modelMapper.map(postDto,Post.class);
        post.setImageName("default.png");
        post.setDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savedPost =  this.postRepository.save(post);
        return this.modelMapper.map(savedPost,PostDto.class);
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","category id",categoryId));
        List<Post> posts = this.postRepository.findByCategory(category);
        List<PostDto> postDtos = posts.stream().map((post -> this.modelMapper.map(post, PostDto.class))).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user =
                this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","user id", userId));
        List<Post> posts = this.postRepository.findAllByUser(user);
        List<PostDto> postDtos = posts.stream().map((post -> this.modelMapper.map(post,
                PostDto.class))).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
