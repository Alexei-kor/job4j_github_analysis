package ru.job4j.github.analysis.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "commits")
public class Commit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String author;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "repository_id")
    private MyRepository repository;

    public Commit(String message, String author, LocalDateTime date, MyRepository repository) {
        this.message = message;
        this.author = author;
        this.date = date;
        this.repository = repository;
    }
}
