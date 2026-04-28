package com.omarscode.voting_system.category;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omarscode.voting_system.category.dto.CategoryResponseDTO;
import com.omarscode.voting_system.category.dto.CreateCategoryDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("activity/{activityId}")
    public List<CategoryResponseDTO> getCategories(@PathVariable Long activityId){
        return categoryService.getCategoryByActivity(activityId);
    }

    @GetMapping("{id}")
    public CategoryResponseDTO getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    public CategoryResponseDTO createCategory(@Valid @RequestBody CreateCategoryDTO dto){
        return categoryService.createCategory(dto);
    }
    
}
