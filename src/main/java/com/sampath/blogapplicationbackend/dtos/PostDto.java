package com.sampath.blogapplicationbackend.dtos;

import com.sampath.blogapplicationbackend.entity.Category;
import com.sampath.blogapplicationbackend.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;

    private String content;

    private String imageName;

    private Date date;

    private UserDto user;

    private CategoryDto category;
}
