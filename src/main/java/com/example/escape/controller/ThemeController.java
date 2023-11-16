package com.example.escape.controller;


import com.example.escape.dto.ThemeDetailDto;
import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.service.ThemeService;
import com.example.escape.util.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping
    public Page<ThemeListItemDto> findAll(
            @RequestParam(value = "type",required = false) Type type,
            @RequestParam(value = "store",required = false) String store,
            Pageable pageable) {
        if (Type.STORE.equals(type))
            return themeService.findByStore(store, pageable);

        return themeService.findAll(pageable);
    }

    @GetMapping("/{themeId}")
    public ThemeDetailDto findById(@PathVariable Long themeId) {
        return themeService.findById(themeId);
    }
}
