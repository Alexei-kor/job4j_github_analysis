package ru.job4j.github.analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.github.analysis.dto.CommitDTO;
import ru.job4j.github.analysis.dto.RepositoryDTO;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.repository.GitHubRepository;

import java.util.List;

@Service
public class GitHubRemote {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GitHubRepository gitHubRepository;

    public List<RepositoryDTO> fetchRepositories(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        ResponseEntity<List<RepositoryDTO>> response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<RepositoryDTO>>() {

                });
        return response.getBody();
    }

    public List<CommitDTO> fetchCommits(String username, String repository) {
        String url = "https://api.github.com/repos/" + username + "/" + repository + "/commits";

        ResponseEntity<List<CommitDTO>> response = restTemplate.exchange(
                url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<CommitDTO>>() {

                });
        return response.getBody();
    }
}
