package com.sampath.blogapplicationbackend.services.interfaces;

import com.sampath.blogapplicationbackend.dtos.CategoryDto;

import java.util.List;

public interface ICategoryService {
    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId);
    public void deleteCategory(Integer categoryId);
    public CategoryDto getCategory(Integer categoryId);
    public List<CategoryDto> getAllCategories();


}
