package ru.job4j.github.analysis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDTO {
    private Long id;
    private String name;
    private String url;
}
