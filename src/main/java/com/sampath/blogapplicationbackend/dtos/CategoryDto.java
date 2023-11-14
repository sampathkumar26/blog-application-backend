package com.sampath.blogapplicationbackend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
    private int categoryID;

    @NotBlank
    @Size(min = 4,message = "min of 4 characters")
    private String categoryTitle;

    @NotBlank
    @Size(min = 10, message = "min of 10 characters")
    private String categoryDescription;
}
