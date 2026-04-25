 package ru.job4j.github.analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.github.analysis.dto.RepositoryCommits;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.MyRepository;

import java.util.List;

@Service
public class GitHubService {

    @Autowired
    private RestTemplate restTemplate;

    public List<MyRepository> fetchRepositories(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        ResponseEntity<List<MyRepository>> response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<MyRepository>>() {});
        return response.getBody();
    }

    public List<Commit> fetchCommits(String username, String repository) {
        String url = "https://api.github.com/repos/" + username + "/" + repository + "/commits";

        ResponseEntity<List<RepositoryCommits>> response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<RepositoryCommits>>() {});
        return response.getBody().stream()
                .map(commit -> new Commit(
                        commit.getCommit().getMessage(),
                        commit.getCommit().getAuthor().getName(),
                        commit.getCommit().getAuthor().getDate())
                ).toList();
    }
}