package com.daviddpg.inditexdemo.service;

import com.daviddpg.inditexdemo.dataaccess.repository.RateJpaRepository;
import com.daviddpg.inditexdemo.domain.entity.Rate;
import com.daviddpg.inditexdemo.service.exception.RateNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class RateService {

    private final RateJpaRepository rateJpaRepository;
    private final RateMapper rateMapper;

    public RateService(RateJpaRepository rateJpaRepository, RateMapper rateMapper) {
        this.rateJpaRepository = rateJpaRepository;
        this.rateMapper = rateMapper;
    }

    public Rate getRateForProductBrandInDate(Integer brandId, Long productId, LocalDateTime dateTime) {
        log.debug("Querying rate for product brand {} in product {}", brandId, productId);
        var rateList = rateJpaRepository.findAllByBrandIdAndProductId(brandId, productId);

        log.debug("Filtering list of rates for date {} and top priority", dateTime);
        var foundRate = rateList.stream()
                .map(rateMapper::fromRateJpaEntityToRateDomainEntity)
                .filter(rate -> rate.matchesWithDateTime(dateTime))
                .max(Comparator.comparing(Rate::getPriority))
                .orElseThrow(() -> new RateNotFoundException("Could not find Rate that matches parameters"));

        return foundRate;
    }
}
