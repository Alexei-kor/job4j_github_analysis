 package ru.job4j.github.analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.github.analysis.dto.CommitDTO;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.MyRepository;
import ru.job4j.github.analysis.repository.GitHubRepository;

import java.util.List;

@Service
public class GitHubService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GitHubRepository gitHubRepository;

    public List<MyRepository> fetchRepositories(String username) {
        return List.of();
    }

    public List<Commit> fetchCommits(String username, String repository) {
        return List.of();
    }
}