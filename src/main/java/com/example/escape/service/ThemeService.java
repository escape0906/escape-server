package com.example.escape.service;

import com.example.escape.dto.ThemeDetailDto;
import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.entity.Theme;
import com.example.escape.exception.ThemeNotFoundException;
import com.example.escape.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    public Page<ThemeListItemDto> findAll(Pageable pageable) {
        Page<Theme> themePage = themeRepository.findAll(pageable);
        return themePage.map(this::convert);
    }

    public ThemeDetailDto findById(Long themeId) {
        Theme theme = themeRepository.findById(themeId)
                .orElseThrow(() -> new ThemeNotFoundException(themeId));

        return convertToDetailDto(theme);
    }

    private ThemeDetailDto convertToDetailDto(Theme theme) {
        ThemeDetailDto dto = new ThemeDetailDto();
        dto.setId(theme.getId());
        dto.setTitle(theme.getTitle());
        dto.setThumbnail(theme.getThumbnail());
        dto.setGenre(theme.getGenre());
        dto.setStore(theme.getStore());
        dto.setAddress(theme.getAddress());
        dto.setPlayTime(theme.getPlayTime());
        dto.setRecommendedPeople(theme.getRecommendedPeople());
        dto.setMaximumPeople(theme.getMaximumPeople());
        return dto;
    }

    private ThemeListItemDto convert(Theme theme) {
        ThemeListItemDto dto = new ThemeListItemDto();
        dto.setId(theme.getId());
        dto.setThumbnail(theme.getThumbnail());
        dto.setTitle(theme.getTitle());
        dto.setLocation(theme.getAddress());
        return dto;
    }

}

