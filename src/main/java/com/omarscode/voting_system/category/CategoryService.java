package com.omarscode.voting_system.category;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.omarscode.voting_system.category.dto.CategoryResponseDTO;
import com.omarscode.voting_system.category.dto.CreateCategoryDTO;
import com.omarscode.voting_system.category.entity.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponseDTO> getCategoryByActivity(Long activityId){
        return categoryRepository.findByActivityId(activityId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CategoryResponseDTO getCategory(Long id){
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        return toResponse(category);
    }

    public void deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryRepository.delete(category);
    }

    public CategoryResponseDTO createCategory(CreateCategoryDTO dto){
        Category category = new Category(
            dto.name(),
            dto.categoryType(),
            dto.activity()
        );

        Category saved = categoryRepository.save(category);

        return toResponse(saved);
    }

    private CategoryResponseDTO toResponse(Category category){
        return new CategoryResponseDTO(
            category.geId(), 
            category.getName(),
            category.getType(), 
            category.getActivity()
        );
    }
    
}
