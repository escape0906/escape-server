package com.example.escape.controller;


import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping
    public Page<ThemeListItemDto> findAll(Pageable pageable) {

        return themeService.findAll(pageable);
    }
}
