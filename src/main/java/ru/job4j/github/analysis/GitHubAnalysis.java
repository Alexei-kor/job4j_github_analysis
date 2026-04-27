package ru.job4j.github.analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class GitHubAnalysis {
    public static void main(String[] args) {
        SpringApplication.run(GitHubAnalysis.class, args);
    }
}
