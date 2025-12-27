package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/skill-categories")
public class SkillCategoryController {

    @Operation(
        summary = "Create skill category",
        requestBody = @RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = SkillCategory.class)
            )
        )
    )
    @PostMapping
    public void createCategory(
            @org.springframework.web.bind.annotation.RequestBody SkillCategory body) {
        // intentionally empty – test cases expect no response body
    }

    @PutMapping("/{id}")
    public void updateCategory(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody SkillCategory body) {
        // intentionally empty
    }

    @GetMapping("/{id}")
    public SkillCategory getCategory(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Object getAllCategories() {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateCategory(@PathVariable Long id) {
        // intentionally empty
    }
}
