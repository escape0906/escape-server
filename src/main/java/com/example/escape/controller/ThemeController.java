package com.example.escape.controller;


import com.example.escape.dto.ThemeDetailDto;
import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping
    public Page<ThemeListItemDto> findAll(Pageable pageable) {

        return themeService.findAll(pageable);
    }

    @GetMapping("/{themeId}")
    public ThemeDetailDto findById(@PathVariable Long themeId) {
        return themeService.findById(themeId);
    }
}
