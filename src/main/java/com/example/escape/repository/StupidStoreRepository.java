package com.example.escape.repository;

import com.example.escape.dto.SearchCondition;
import com.example.escape.entity.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class StupidStoreRepository implements StoreRepository {

    private final EntityManager entityManager;

    @Override
    public Page<Store> findAll(Pageable pageable) {
        TypedQuery<Store> query = entityManager.createQuery("select distinct new com.example.escape.entity.Store(store, address)" +
                "from Theme t", Store.class
        );
        List<Store> resultList = query.getResultList();
        return new PageImpl<>(resultList, pageable, resultList.size());
    }

    @Override
    public Page<Store> search(SearchCondition condition, Pageable pageable) {
        TypedQuery<Store> query = entityManager.createQuery("select distinct new com.example.escape.entity.Store(store, address)" +
                "from Theme t WHERE t.store like concat('%',:name,'%')", Store.class
        ).setParameter("name", condition.getKeyword());
        if (condition.hasAddress()) {
            StringBuilder sql = new StringBuilder("select distinct new com.example.escape.entity.Store(store, address)" +
                    "from Theme t WHERE t.store like concat('%',:name,'%')");

            String[] addresses = condition.getAddress();
            for (int i = 1; i <= addresses.length; i++) {
                sql.append(" and t.address like concat('%',")
                        .append("?").append(i).append(",'%')");
            }

            query = entityManager.createQuery(sql.toString(), Store.class)
                    .setParameter("name", condition.getKeyword());

            for (int i = 0; i < addresses.length; i++) {
                query = query.setParameter(i + 1, addresses[i]);
            }
        }
        List<Store> resultList = query.getResultList();
        return new PageImpl<>(resultList, pageable, resultList.size());
    }
}
