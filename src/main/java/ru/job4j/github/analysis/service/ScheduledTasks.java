package ru.job4j.github.analysis.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.job4j.github.analysis.dto.CommitDTO;
import ru.job4j.github.analysis.dto.CommitMapper;
import ru.job4j.github.analysis.dto.RepositoryMapper;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.MyRepository;
import ru.job4j.github.analysis.repository.CommitRepository;
import ru.job4j.github.analysis.repository.GitHubRepository;

import java.util.List;

@AllArgsConstructor
@Service
@Component
public class ScheduledTasks {
    private final GitHubRepository gitHubRepository;
    private final CommitRepository commitRepository;
    private final GitHubRemote gitHubRemote;
    private final RepositoryMapper repositoryMapper;
    private final CommitMapper commitMapper;

    @Scheduled(fixedRate = 60000)
    public void fetchRepositories() {
        gitHubRemote.fetchRepositories("Alexei-kor")
                .stream()
                .map(repositoryMapper::getEntityFromModel)
                .filter(repo -> gitHubRepository.findByName(repo.getName()).isEmpty())
                .forEach(gitHubRepository::save);
    }

    @Scheduled(fixedRate = 65000)
    public void fetchCommits() {
        for (MyRepository repo : gitHubRepository.findAll()) {
            List<Commit> commitList = gitHubRemote.fetchCommits("Alexei-kor", repo.getName())
                    .stream()
                    .map(commitMapper::getEntityFromModel)
                    .toList();
            for (Commit commit : commitList) {
                commit.setRepository(repo);
                if (commitRepository.findBySha(commit.getSha()).isEmpty())
                    commitRepository.save(commit);
            }
        }

    }
}
