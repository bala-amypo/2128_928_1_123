package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_queries")
public class SearchQueryRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String skillsRequested;
private int resultsCount;
private LocalDateTime searchedAt = LocalDateTime.now();

public SearchQueryRecord() {}

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getSkillsRequested() { return skillsRequested; }
public void setSkillsRequested(String skillsRequested) { this.skillsRequested = skillsRequested; }

public int getResultsCount() { return resultsCount; }
public void setResultsCount(int resultsCount) { this.resultsCount = resultsCount; }

public LocalDateTime getSearchedAt() { return searchedAt; }
public void setSearchedAt(LocalDateTime searchedAt) { this.searchedAt = searchedAt; }
}
