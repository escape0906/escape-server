package com.example.escape.controller;

import com.example.escape.controller.doc.StoreControllerSwagger;
import com.example.escape.dto.SearchCondition;
import com.example.escape.dto.StoreListItemDto;
import com.example.escape.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/stores")
@RequiredArgsConstructor
@RestController
public class StoreController implements StoreControllerSwagger {

    private final StoreService storeService;

    @GetMapping
    @Override
    public Page<StoreListItemDto> findAll(Pageable pageable) {
        return storeService.findAll(pageable);
    }

    //    @GetMapping("/search")
    @Override
    public Page<StoreListItemDto> search(SearchCondition condition, Pageable pageable) {
        return null;
    }
}
