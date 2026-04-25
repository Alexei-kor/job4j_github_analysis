package ru.job4j.github.analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import ru.job4j.github.analysis.model.MyRepository;

public interface GitHubRepository extends CrudRepository<MyRepository, Long>, JpaRepository<MyRepository, Long> {

}
