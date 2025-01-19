package com.daviddpg.inditexdemo.service;

import com.daviddpg.inditexdemo.dataaccess.entity.RateJpaEntity;
import com.daviddpg.inditexdemo.domain.entity.Rate;
import com.daviddpg.inditexdemo.domain.valueobject.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RateMapper {
    Rate fromRateJpaEntityToRateDomainEntity(RateJpaEntity rateJpaEntity) {
        log.debug("Mapping RateJpaEntity#{} to domain Rate", rateJpaEntity.getId());
        return Rate.builder()
                .rateId(new RateId(rateJpaEntity.getId()))
                .brandId(new BrandId(rateJpaEntity.getBrandId()))
                .productId(new ProductId(rateJpaEntity.getProductId()))
                .priority(new RatePriority(rateJpaEntity.getPriority()))
                .startDate(new RateStartDate(rateJpaEntity.getStartDate()))
                .endDate(new RateEndDate(rateJpaEntity.getEndDate()))
                .price(new RatePrice(rateJpaEntity.getPrice()))
                .currency(new RateCurrency(rateJpaEntity.getCurrency()))
                .build();
    }
}
