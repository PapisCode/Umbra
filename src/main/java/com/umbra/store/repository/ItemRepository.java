package com.umbra.store.repository;

import com.umbra.store.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsBySkuIgnoreCase(String sku);

    @Query("""
        SELECT i
        FROM Item i
        WHERE (:keyword IS NULL OR :keyword = ''
               OR LOWER(i.name) LIKE LOWER(CONCAT('%', :keyword, '%'))
               OR LOWER(i.sku) LIKE LOWER(CONCAT('%', :keyword, '%')))
          AND (:brandId IS NULL OR i.brand.id = :brandId)
          AND (:categoryId IS NULL OR i.category.id = :categoryId)
        """)
    Page<Item> searchItems(@Param("keyword") String keyword,
                           @Param("brandId") Long brandId,
                           @Param("categoryId") Long categoryId,
                           Pageable pageable);
}
