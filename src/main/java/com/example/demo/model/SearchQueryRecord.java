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
private String queryText;

@Column(nullable = false)
private LocalDateTime searchedAt;

public SearchQueryRecord() {
this.searchedAt = LocalDateTime.now();
}

/* getters & setters */

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getQueryText() {
return queryText;
}

public void setQueryText(String queryText) {
this.queryText = queryText;
}

public LocalDateTime getSearchedAt() {
return searchedAt;
}

public void setSearchedAt(LocalDateTime searchedAt) {
this.searchedAt = searchedAt;
}
}
