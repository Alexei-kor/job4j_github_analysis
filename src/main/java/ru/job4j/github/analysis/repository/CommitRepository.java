package ru.job4j.github.analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.MyRepository;

import java.util.List;
import java.util.Optional;

public interface CommitRepository extends CrudRepository<Commit, Long>, JpaRepository<Commit, Long> {
    Optional<Commit> findBySha(String sha);

    List<Commit> findAllByRepositoryName(String nameRepo);
}
