package ru.job4j.github.analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.job4j.github.analysis.model.MyRepository;
import ru.job4j.github.analysis.repository.GitHubRepository;

@Service
public class RepositoryService {

    @Autowired
    private GitHubRepository gitHubRepository;

    @Async
    public void create(MyRepository repository) {
        if (gitHubRepository.findByName(repository.getName()).isEmpty()) {
            gitHubRepository.save(repository);
        }
    }
}
