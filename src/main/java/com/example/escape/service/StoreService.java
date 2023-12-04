package com.example.escape.service;

import com.example.escape.dto.SearchCondition;
import com.example.escape.dto.StoreListItemDto;
import com.example.escape.entity.Store;
import com.example.escape.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public Page<StoreListItemDto> findAll(Pageable pageable) {
        return storeRepository.findAll(pageable).map(this::convert);
    }

    public Page<StoreListItemDto> search(SearchCondition condition, Pageable pageable) {
        return storeRepository.search(condition, pageable).map(this::convert);
    }

    private StoreListItemDto convert(Store store) {
        return new StoreListItemDto(store.getName(), store.getAddress());
    }
}
