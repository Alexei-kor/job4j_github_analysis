package ru.job4j.github.analysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.MyRepository;
import ru.job4j.github.analysis.service.GitHubService;
import ru.job4j.github.analysis.service.RepositoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/repositories")
    public List<MyRepository> getAllRepositories() {
        return gitHubService.fetchRepositories("Alexei-kor");
    }

    @GetMapping("/commits/{repo}")
    public List<Commit> getCommits(@PathVariable(value = "repo") String repo) {
         return gitHubService.fetchCommits("Alexei-kor", repo);
    }

    @PostMapping("/repository")
    public ResponseEntity<Void> create(@RequestBody MyRepository repository) {
        repositoryService.create(repository);
        return ResponseEntity.noContent().build();
    }
}
