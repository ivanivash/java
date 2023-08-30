package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.dto.category.CategoryCreateDTO;
import org.example.dto.category.CategoryItemDTO;
import org.example.dto.category.CategoryUpdateDTO;
import org.example.entities.CategoryEntity;
import org.example.mappers.CategoryMapper;
import org.example.repositories.CategoryRepository;
import org.example.storage.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final StorageService storageService;
    @GetMapping("/category")
    public ResponseEntity<List<CategoryItemDTO>> index() {
        List<CategoryItemDTO> items = categoryMapper.listCategoriesToItemDTO(categoryRepository.findAll());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
    @PostMapping(value = "/category", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CategoryItemDTO create(@ModelAttribute CategoryCreateDTO dto) {
        String fileName = storageService.saveMultipartFile(dto.getImage());
        CategoryEntity cat = CategoryEntity
                .builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .image(fileName)
                .build();
        categoryRepository.save(cat);
        return categoryMapper.categoryToItemDTO(cat);
    }
    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryItemDTO> getCategoryById(@PathVariable int id) {
        Optional<CategoryEntity> categoryOptional = categoryRepository.findById(id);
        return categoryOptional
                .map(category -> ResponseEntity.ok().body(categoryMapper.categoryToItemDTO(category)))
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryItemDTO> updateCategory(@PathVariable int id, @RequestBody CategoryUpdateDTO dto) {
        Optional<CategoryEntity> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.map(category -> {
            category.setName(dto.getName());
            category.setDescription(dto.getDescription());
            category.setImage(dto.getImage());
            categoryRepository.save(category);
            return ResponseEntity.ok().body(categoryMapper.categoryToItemDTO(category));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        Optional<CategoryEntity> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}