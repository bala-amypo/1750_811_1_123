package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SearchQuery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String skills;

    private LocalDateTime searchedAt = LocalDateTime.now();

    // getters & setters
}
