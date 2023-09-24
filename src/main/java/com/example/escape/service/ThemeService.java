package com.example.escape.service;

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

    private ThemeListItemDto convert(Theme theme) {
        ThemeListItemDto dto = new ThemeListItemDto();
        // TODO: 2023-09-24 db에 thumbnail 적용해야 함
        dto.setThumbnail("https://cdn2.thecatapi.com/images/a16.png");
        dto.setTitle(theme.getTitle());
        dto.setLocation(theme.getAddress());
        return dto;
    }
}

