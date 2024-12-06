package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.entity.ImageAdEntity;

import java.io.IOException;
import java.util.List;

public interface ImageAdService {
    ImageAdEntity updateAdImage(Integer id, MultipartFile file) throws IOException;

//    List<String> updateImage(Long id, MultipartFile image);

    byte[] getImageAd(Integer id) throws IOException;
    AdDto createAd(AdDto AdDto, MultipartFile image, String userName) throws IOException;
    default String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}