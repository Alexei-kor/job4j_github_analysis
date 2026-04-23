package ru.job4j.github.analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface GitHubRepository extends CrudRepository<Repository, Long>, JpaRepository<Repository, Long> {

}
