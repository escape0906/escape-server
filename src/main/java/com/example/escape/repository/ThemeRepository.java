package com.example.escape.repository;

import com.example.escape.entity.Theme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Override
    Page<Theme> findAll(Pageable pageable);

    Page<Theme> findAllByStore(String store, Pageable pageable);
}
