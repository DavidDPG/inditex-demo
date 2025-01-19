package com.daviddpg.inditexdemo.dataaccess.repository;


import com.daviddpg.inditexdemo.dataaccess.entity.RateJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateJpaRepository extends JpaRepository<RateJpaEntity, Long> {
    // Could write something like SELECT * FROM PRICES WHERE BRAND_ID=brandId AND PRODUCT_ID=productId AND START_DATE >= startDateTime AND END_DATE <= endDateTime ORDER BY PRIORITY DESC LIMIT 1
    // But this is a java coding challenge after all
    List<RateJpaEntity> findAllByBrandIdAndProductId(Integer brandId, Long productId);
}
