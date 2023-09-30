package com.example.escape.service;

import com.example.escape.dto.ThemeDetailDto;
import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.entity.Theme;
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
        Theme theme = themeRepository.findById(themeId).orElseThrow(() -> new RuntimeException());
        // TODO: 2023-09-30 Exception 재정의
        ThemeDetailDto dto = new ThemeDetailDto();
        return dto;
    }

    private ThemeListItemDto convert(Theme theme) {
        ThemeListItemDto dto = new ThemeListItemDto();
        dto.setThumbnail(theme.getThumbnail());
        dto.setTitle(theme.getTitle());
        dto.setLocation(theme.getAddress());
        return dto;
    }

}

