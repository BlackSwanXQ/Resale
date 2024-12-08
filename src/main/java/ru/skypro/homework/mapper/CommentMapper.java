package ru.skypro.homework.mapper;

import org.mapstruct.*;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.entity.Comment;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentMapper {

    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "authorImage", source = "author.image")
    @Mapping(target = "authorFirstName", source = "author.firstName")
    @Mapping(target = "createdAt", qualifiedByName = "localDateTimeToLong")
    CommentDto commentToCommentDto(Comment comment);

    @Named("localDateTimeToLong")
    default long localDateTimeToLong(LocalDateTime dateTime) {
        return dateTime.toInstant(ZoneOffset.UTC).getEpochSecond();
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author",ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Comment createOrUpdateCommentDtoToComment(CreateOrUpdateCommentDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author",ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void createOrUpdateCommentDtoToComment(CreateOrUpdateCommentDto dto, @MappingTarget Comment comment);
}
