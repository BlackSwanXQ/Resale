package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ad;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.dto.ExtendedAd;
import ru.skypro.homework.service.AdsService;

import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {
    @Override
    public Ads getAdAll() {
        return null;
    }

    @Override
    public Ad createAd(CreateOrUpdateAd createOrUpdateAd, MultipartFile image) {
        return null;
    }

    @Override
    public ExtendedAd getAd(Long id) {
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
    public Ad updateAds(Long id, CreateOrUpdateAd createOrUpdateAd) {
        return null;
    }

    @Override
    public Ads getAdsAuthorizedUser() {
        return null;
    }

    @Override
    public List<String> updateImage(Long id, MultipartFile image) {
        return List.of();
    }
}
