package ru.job4j.github.analysis.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.github.analysis.model.Commit;
import ru.job4j.github.analysis.model.MyRepository;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommitMapper {

    @Mapping(target = "sha", expression = "java(commitDTO.getSha())")
    @Mapping(target = "message", expression = "java(commitDTO.getCommit().getMessage())")
    @Mapping(target = "author", expression = "java(commitDTO.getCommit().getAuthor().getName())")
    @Mapping(target = "date", expression = "java(commitDTO.getCommit().getAuthor().getDate())")
    Commit getEntityFromModel(CommitDTO commitDTO);
}
