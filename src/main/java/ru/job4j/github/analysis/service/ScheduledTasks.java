package ru.job4j.github.analysis.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Component
public class ScheduledTasks {
    private final RepositoryService repositoryService;
    private final GitHubService gitHubService;

    @Scheduled(fixedRate = 5000)
    public void fetchCommits() {
        gitHubService.fetchRepositories("Alexei-kor").stream().forEach(repositoryService::create);
    }
}
