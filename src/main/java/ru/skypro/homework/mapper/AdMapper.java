package ru.skypro.homework.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.AdEntity;
import ru.skypro.homework.entity.AvatarEntity;
import ru.skypro.homework.entity.ImageAdEntity;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdMapper {

    @Mappings({
            @Mapping(target = "author", ignore = true),
            @Mapping(target = "id", source = "pk"),
            @Mapping(target = "image", ignore = true)
    })
    AdEntity toAd(AdDto adDTO);

    @Mappings({
            @Mapping(target = "author", source = "author.id"),
            @Mapping(target = "pk", source = "id"),
            @Mapping(target = "image", source = "image.path")
    })
    AdDto toAdDto(AdEntity ad);

    List<AdDto> toListAdDTO(List<AdEntity> ads);

    @Mappings({
            @Mapping(target = "pk", source = "id"),
            @Mapping(target = "authorFirstName", source = "author.firstName"),
            @Mapping(target = "authorLastName", source = "author.lastName"),
            @Mapping(target = "phone", source = "author.phone"),
            @Mapping(target = "email", source = "author.email"),
            @Mapping(target = "image", source = "image.path")
    })
    ExtendedAdDto adToExtendedAd(AdEntity ad);
}
