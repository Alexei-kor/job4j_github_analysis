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
    private Commit commit;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Commit {
        private Author author;
        private String message;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Author {
            private String name;
            private LocalDateTime date;
        }
    }
}
