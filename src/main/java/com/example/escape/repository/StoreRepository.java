package com.example.escape.repository;

import com.example.escape.dto.SearchCondition;
import com.example.escape.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreRepository {

    Page<Store> findAll(Pageable pageable);

    Page<Store> search(SearchCondition condition, Pageable pageable);
}
