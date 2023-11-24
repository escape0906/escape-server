package com.example.escape.service;

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

    // TODO: 2023-11-24 theme 테이블에서 store 정보 분리
    private final StoreRepository storeRepository;

    public Page<StoreListItemDto> findAll(Pageable pageable) {
        return storeRepository.findAll(pageable).map(this::convert);
    }

    private StoreListItemDto convert(Store store) {
        return new StoreListItemDto(store.getName(), store.getAddress());
    }
}
