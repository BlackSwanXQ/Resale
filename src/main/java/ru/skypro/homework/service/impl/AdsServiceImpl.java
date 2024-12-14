package ru.skypro.homework.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;
import ru.skypro.homework.exception.NotFoundException;
import ru.skypro.homework.mapper.AdMapper;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final AdRepository adRepository;
    private final AdMapper adMapper;
    private final UserService userService;

    @Override
    public AdsDto getAllAds() {
        List<Ad> ads = adRepository.findAll();
        return new AdsDto(ads.size(), ads.stream().map(adMapper::adToAdDto).collect(Collectors.toList()));
    }

    @Override
    public AdDto createAd(CreateOrUpdateAdDto createOrUpdateAd, MultipartFile image, String userName) {
        Ad ad = adMapper.createOrUpdateAdDtoToAd(createOrUpdateAd);
        User user = userService.getUser(userName);
        ad.setAuthor(user);
        return adMapper.adToAdDto(adRepository.save(ad));
    }

    @Override
    public ExtendedAdDto getAd(Long id) {
        Ad ad = adRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("Объявление %s не найдено.", id)));
        return adMapper.adToExtendedAdDto(ad);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @adRepository.existsByIdAndAuthorEmail(#id, authentication.principal.username)")
    public void deleteAd(Long id) {
        if (!adRepository.existsById(id)) throw new NotFoundException(String.format("Объявление %s не найдено.", id));
        adRepository.deleteById(id);
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @adRepository.existsByIdAndAuthorEmail(#id, authentication.principal.username)")
    @Transactional
    public AdDto updateAd(Long id, CreateOrUpdateAdDto createOrUpdateAd) {
        Ad ad = adRepository.findById(id).orElseThrow(()-> new NotFoundException(String.format("Объявление %s не найдено.", id)));
        adMapper.createOrUpdateAdDtoToAd(createOrUpdateAd,ad);
        return adMapper.adToAdDto(ad);
    }

    @Override
    public AdsDto getAdsAuthorizedUser(String userName) {
        User user = userService.getUser(userName);
        List<Ad> ads = adRepository.findByAuthor(user);
        return new AdsDto(ads.size(), ads.stream().map(adMapper::adToAdDto).collect(Collectors.toList()));
    }

    @Override
    public List<String> updateImage(Long id, MultipartFile image) {
        return List.of();
    }
}
