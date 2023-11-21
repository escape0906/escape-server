package com.example.escape.repository.spceification;

import com.example.escape.entity.Theme;
import org.springframework.data.jpa.domain.Specification;

public class ThemeSpecification {

    public static Specification<Theme> equalDifficult(Integer difficult) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("difficult"), difficult);
    }

    public static Specification<Theme> likeTitle(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Theme> likeStore(String store) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("store"), "%" + store + "%");
    }

    public static Specification<Theme> likeAddress(String address) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("address"), "%" + address + "%");
    }

}
