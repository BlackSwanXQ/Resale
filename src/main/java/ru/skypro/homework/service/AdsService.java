package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;

import java.util.List;

public interface AdsService {
    AdDto createAd(CreateOrUpdateAdDto createOrUpdateAd, MultipartFile image, String userName);
    AdsDto getAllAds();
    ExtendedAdDto getAd(Long id);
    void deleteAd(Long id);
    List<String> updateImage(Long id, MultipartFile image);
    AdsDto getAdsAuthorizedUser(String userName);
    AdDto updateAd(Long id, CreateOrUpdateAdDto createOrUpdateAd);
//    URL getImage(Long id, HttpServletResponse response) throws MalformedURLException;
}
