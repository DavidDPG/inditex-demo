package com.daviddpg.inditexdemo.application.dto;

import com.daviddpg.inditexdemo.application.controller.RateController;
import com.daviddpg.inditexdemo.domain.entity.Rate;

public record RateOutputDto(Long productId, Integer brandId, Integer rateId, String startDateTime, String endDateTime, String finalPrice) {
    public static RateOutputDto ofEntity(Rate rate) {
        return new RateOutputDto(
                rate.getProductId().id(),
                rate.getBrandId().id(),
                rate.getRateId().id(),
                rate.getStartDate().startDate().format(RateController.INDITEX_DATE_TIME_FORMATTER),
                rate.getEndDate().endDate().format(RateController.INDITEX_DATE_TIME_FORMATTER),
                // I assume that "final price" in requirements.txt means "final price & currency" because otherwise currency is meaningless, so I join them
                rate.getPrice().price().toPlainString() + " " + rate.getCurrency().currency()
        );
    }
}
