package com.example.demo.controller;

import com.example.demo.model.SkillCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/skill-categories")
public class SkillCategoryController {

    @Operation(
        summary = "Create skill category",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = SkillCategory.class)
            )
        )
    )
    @PostMapping
    public Object createCategory(
            @org.springframework.web.bind.annotation.RequestBody Object body) {
        return null;
    }

    @PutMapping("/{id}")
    public Object updateCategory(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody Object body) {
        return null;
    }

    @GetMapping("/{id}")
    public Object getCategory(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public Object getAllCategories() {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateCategory(@PathVariable Long id) {
    }
}
