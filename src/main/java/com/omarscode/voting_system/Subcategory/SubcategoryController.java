package com.omarscode.voting_system.Subcategory;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omarscode.voting_system.Subcategory.dto.CreateSubcategoryDTO;
import com.omarscode.voting_system.Subcategory.dto.SubcategoryResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("subcategories")
@RequiredArgsConstructor
public class SubcategoryController {
    
    private final SubcategoryService subcategoryService;

    @GetMapping("{id}")
    public List<SubcategoryResponseDTO> getSubcategories(@PathVariable Long id){
        return subcategoryService.getSubcategoryByCategory(id);
    }

    @GetMapping("{id}")
    public SubcategoryResponseDTO getSubcategory(Long id){
        return subcategoryService.getSubcategory(id);
    }

    @DeleteMapping("{id}")
    public String deleteSubcategory(Long id){
        subcategoryService.deleteSubcategory(id);
        return "Subcategory deleted with success!";
    }

    @PostMapping
    public SubcategoryResponseDTO createSubcategory(@Valid @RequestBody CreateSubcategoryDTO dto){
        return subcategoryService.createSubcategory(dto);
    }

}
