package com.sampath.blogapplicationbackend.services;

import com.sampath.blogapplicationbackend.dtos.CategoryDto;
import com.sampath.blogapplicationbackend.entity.Category;
import com.sampath.blogapplicationbackend.execeptions.ResourceNotFoundException;
import com.sampath.blogapplicationbackend.repository.CategoryRepository;
import com.sampath.blogapplicationbackend.services.interfaces.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatergoryServiceImp implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto,Category.class);
        Category savedCategory = categoryRepository.save(category);
        return this.modelMapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category =
                this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category ID",categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCategory = this.categoryRepository.save(category);
        return this.modelMapper.map(updatedCategory,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
      Category category =
              this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category ID",categoryId));
        this.categoryRepository.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category =
                this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Category ID",categoryId));
        return this.modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        List<CategoryDto> categoryDtos =
                categories.stream().map(category->this.modelMapper.map(category,
                        CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
