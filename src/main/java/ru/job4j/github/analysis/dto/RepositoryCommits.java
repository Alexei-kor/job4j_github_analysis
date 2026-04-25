package ru.job4j.github.analysis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.github.analysis.model.MyRepository;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryCommits {
    @JsonProperty("commit.author.name")
    private String author;

    @JsonProperty("commit.message")
    private String message;

    @JsonProperty("commit.author.date")
    private LocalDateTime date;

}
