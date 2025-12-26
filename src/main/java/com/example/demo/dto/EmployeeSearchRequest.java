package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public class EmployeeSearchRequest {

    @Schema(
        description = "List of skill IDs to search employees by",
        example = "[1, 2, 3]",
        required = true
    )
    private List<Long> skillIds;

    public List<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(List<Long> skillIds) {
        this.skillIds = skillIds;
    }
}
