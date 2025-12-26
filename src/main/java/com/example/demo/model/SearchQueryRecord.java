package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "search_queries")
public class SearchQueryRecord {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String query;

private LocalDateTime timestamp;

public SearchQueryRecord() {}

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
