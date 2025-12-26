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
private String query;

@Column(nullable = false)
private LocalDateTime timestamp;

public SearchQueryRecord() {}

public SearchQueryRecord(String query) {
this.query = query;
this.timestamp = LocalDateTime.now();
}

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getQuery() {
return query;
}

public void setQuery(String query) {
this.query = query;
}

public LocalDateTime getTimestamp() {
return timestamp;
}

public void setTimestamp(LocalDateTime timestamp) {
this.timestamp = timestamp;
}
}
