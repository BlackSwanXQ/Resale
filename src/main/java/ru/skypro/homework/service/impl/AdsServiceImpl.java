package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.service.AdsService;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {
    @Override
    public AdsDto getAdAll() {
        return null;
    }

    @Override
    public AdDto createAd(CreateOrUpdateAdDto createOrUpdateAd, MultipartFile image) {
        return null;
    }

    @Override
    public ExtendedAdDto getAd(Long id) {
        return null;
    }

    @Override
    public void deleteAd(Long id) {

    }

//    @Override
//    public Ad updateAd(Ad ad) {
//        return null;
//    }

    @Override
    public AdDto updateAds(Long id, CreateOrUpdateAdDto createOrUpdateAd) {
        return null;
    }

    @Override
    public AdsDto getAdsAuthorizedUser() {
        return null;
    }

    @Override
    public List<String> updateImage(Long id, MultipartFile image) {
        return List.of();
    }
}
