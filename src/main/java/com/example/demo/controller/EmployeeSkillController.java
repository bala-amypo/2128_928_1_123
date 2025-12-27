package com.example.demo.controller;

import com.example.demo.model.EmployeeSkill;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {

    @Operation(
        summary = "Create employee-skill mapping",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = EmployeeSkill.class)
            )
        )
    )
    @PostMapping
    public Object createMapping(
            @org.springframework.web.bind.annotation.RequestBody Object body) {
        return null;
    }

    @PutMapping("/{id}")
    public Object updateMapping(
            @PathVariable Long id,
            @org.springframework.web.bind.annotation.RequestBody Object body) {
        return null;
    }

    @GetMapping("/employee/{employeeId}")
    public Object getSkillsByEmployee(@PathVariable Long employeeId) {
        return null;
    }

    @GetMapping("/skill/{skillId}")
    public Object getEmployeesBySkill(@PathVariable Long skillId) {
        return null;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateMapping(@PathVariable Long id) {
    }
}
