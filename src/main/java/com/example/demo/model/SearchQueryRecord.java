package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_query_records")
public class SearchQueryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long searcherId;

    @Column(nullable = false)
    private String skillsRequested;

    // 🔴 MUST default to 0 for tests
    private Integer resultsCount;

    @Column(updatable = false)
    private LocalDateTime searchedAt;

    // 🔴 TESTS CALL THIS DIRECTLY
    @PrePersist
    public void onCreate() {
        this.searchedAt = LocalDateTime.now();

        // 🔴 REQUIRED BY testSearchQueryRecordPrePersistSetsTimestamp
        if (this.resultsCount == null) {
            this.resultsCount = 0;
        }
    }

    // getters and setters

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getSearcherId() {
        return searcherId;
    }
    
    public void setSearcherId(Long searcherId) {
        this.searcherId = searcherId;
    }

    public String getSkillsRequested() {
        return skillsRequested;
    }
    
    public void setSkillsRequested(String skillsRequested) {
        this.skillsRequested = skillsRequested;
    }

    public Integer getResultsCount() {
        return resultsCount;
    }
    
    public void setResultsCount(Integer resultsCount) {
        this.resultsCount = resultsCount;
    }

    public LocalDateTime getSearchedAt() {
        return searchedAt;
    }
    
    public void setSearchedAt(LocalDateTime searchedAt) {
        this.searchedAt = searchedAt;
    }
}
