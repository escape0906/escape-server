package com.example.escape.controller;


import com.example.escape.dto.ErrorBody;
import com.example.escape.dto.SearchCondition;
import com.example.escape.dto.ThemeDetailDto;
import com.example.escape.dto.ThemeListItemDto;
import com.example.escape.exception.ThemeNotFoundException;
import com.example.escape.service.ThemeService;
import com.example.escape.util.Type;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping
    public Page<ThemeListItemDto> findAll(
            @RequestParam(value = "type", required = false) Type type,
            @RequestParam(value = "store", required = false) String store,
            Pageable pageable) {
        if (Type.STORE.equals(type))
            return themeService.findByStore(store, pageable);

        return themeService.findAll(pageable);
    }

    @GetMapping("/search")
    public Page<ThemeListItemDto> searchTheme(SearchCondition condition, Pageable pageable) {
        log.info(condition.toString());
        return themeService.search(condition, pageable);
    }

    @GetMapping("/{themeId}")
    public ThemeDetailDto findById(@PathVariable Long themeId) {
        return themeService.findById(themeId);
    }

    @ExceptionHandler(ThemeNotFoundException.class)
    public ResponseEntity<ErrorBody> handleNotFound(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(new ErrorBody("not found"), HttpStatus.NOT_FOUND);
    }
}
