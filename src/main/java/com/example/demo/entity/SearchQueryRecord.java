package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "search_queries")
public class SearchQueryRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Query text cannot be empty")
private String queryText;

public SearchQueryRecord() {}

public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getQueryText() { return queryText; }
public void setQueryText(String queryText) {
this.queryText = queryText;
}
}
