package com.example.escape.service;

import com.example.escape.dto.SearchCondition;
import com.example.escape.dto.ThemeDetailDto;
import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.entity.Theme;
import com.example.escape.exception.ThemeNotFoundException;
import com.example.escape.repository.ThemeRepository;
import com.example.escape.repository.spceification.ThemeSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    public Page<ThemeListItemDto> findAll(Pageable pageable) {
        Page<Theme> themePage = themeRepository.findAll(pageable);
        return themePage.map(this::convert);
    }

    public Page<ThemeListItemDto> findByStore(String store, Pageable pageable) {
        Page<Theme> themePage = themeRepository.findAllByStore(store, pageable);
        return themePage.map(this::convert);
    }

    public ThemeDetailDto findById(Long themeId) {
        Theme theme = themeRepository.findById(themeId)
                .orElseThrow(() -> new ThemeNotFoundException(themeId));

        return convertToDetailDto(theme);
    }

    public Page<ThemeListItemDto> search(SearchCondition condition, Pageable pageable) {
        Specification<Theme> spec = Specification.where(ThemeSpecification.likeTitle(condition.getKeyword()));

        if (condition.hasAddress()) {
            spec = spec.and(ThemeSpecification.likeAddress(condition.getAddress()));
        }
        if (condition.hasDifficult()) {
            spec = spec.and(ThemeSpecification.equalDifficult(condition.getDifficult()));
        }

        return themeRepository.findAll(spec, pageable).map(this::convert);
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

