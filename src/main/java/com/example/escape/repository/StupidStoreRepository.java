package com.example.escape.repository;

import com.example.escape.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class StupidStoreRepository implements StoreRepository {
    @Override
    public Page<Store> findAll(Pageable pageable) {
        return Page.empty(pageable);
    }

    @Override
    public Page<Store> search(Pageable pageable) {
        return Page.empty(pageable);
    }
}
