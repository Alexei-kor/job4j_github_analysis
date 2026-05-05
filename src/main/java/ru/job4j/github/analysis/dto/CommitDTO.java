package ru.job4j.github.analysis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommitDTO {
    private Commit commit;
    private String sha;

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
