package com.omarscode.voting_system.Subcategory;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.omarscode.voting_system.Subcategory.dto.CreateSubcategoryDTO;
import com.omarscode.voting_system.Subcategory.dto.SubcategoryResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    public List<SubcategoryResponseDTO> getSubcategoryByCategory(Long subcategoryId){
        return subcategoryRepository.findByCategoryId(subcategoryId)
            .stream()
            .map(this::toResponse)
            .toList();        
    }

    public SubcategoryResponseDTO getSubcategory(Long id){
        Subcategory subcategory = subcategoryRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory not found"));
        return toResponse(subcategory);
    }

    public void deleteSubcategory(Long id) {
        Subcategory subcategory = subcategoryRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcaegory not found"));
        subcategoryRepository.delete(subcategory);
    }

    public SubcategoryResponseDTO createSubcategory(CreateSubcategoryDTO dto){
        Subcategory subcategory = new Subcategory(
            dto.name(),
            dto.category()
        );

        Subcategory saved = subcategoryRepository.save(subcategory);

        return toResponse(saved);
    }

    public SubcategoryResponseDTO toResponse(Subcategory subcategory) {
        return new SubcategoryResponseDTO(
            subcategory.getId(),
            subcategory.getName(),
            subcategory.getCategory()
        );
    }
    
}
