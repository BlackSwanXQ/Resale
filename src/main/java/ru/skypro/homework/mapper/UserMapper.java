package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import ru.skypro.homework.dto.RegisterDto;
import ru.skypro.homework.dto.UpdateUserDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.AvatarEntity;
import ru.skypro.homework.entity.UserEntity;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserEntity toUpdateUser(UpdateUserDto source);

    @Mapping(target = "email", source = "username")
    UserEntity toUser(RegisterDto source);

    @Mapping(expression = "java(buildImageUrl(userEntity.getAvatar().getId()))", target = "image")
    @Mapping(source = "role", target = "role")
    UserDto toUserDto(UserEntity userEntity);

    default String map(AvatarEntity avatar) {
        return avatar != null ? avatar.getPath() : null;
    }

    default String buildImageUrl(Long id) {
        return "/users/me/image/" + id;
    }

}
