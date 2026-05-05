package ru.job4j.github.analysis.dto;

import org.mapstruct.Mapper;
import ru.job4j.github.analysis.model.MyRepository;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepositoryMapper {

    MyRepository getEntityFromModel(RepositoryDTO repositoryDTO);

}
