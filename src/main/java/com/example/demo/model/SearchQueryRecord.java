package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_queries")
public class SearchQueryRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillsRequested;

    private Integer resultsCount;

    private LocalDateTime searchedAt;

    @ManyToOne
    @JoinColumn(name = "searcher_id")
    private User searcher;

    @PrePersist
    public void onSearch() {
        this.searchedAt = LocalDateTime.now();
    }

    // -------- Getters & Setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getSearcher() {
        return searcher;
    }

    public void setSearcher(User searcher) {
        this.searcher = searcher;
    }
}
