package ru.job4j.github.analysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.MyRepository;
import ru.job4j.github.analysis.repository.CommitRepository;
import ru.job4j.github.analysis.repository.GitHubRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryService {

    @Autowired
    private GitHubRepository gitHubRepository;

    @Autowired
    private CommitRepository commitRepository;

    public List<MyRepository> getRepositoriesAll() {
        return gitHubRepository.findAll();
    }

    public List<Commit> getCommitsAllForRepo(String nameRepo) {
        return commitRepository.findAllByRepositoryName(nameRepo);
    }

    @Async
    public void create(MyRepository repository) {
        if (gitHubRepository.findByName(repository.getName()).isEmpty()) {
            gitHubRepository.save(repository);
        }
    }
}
