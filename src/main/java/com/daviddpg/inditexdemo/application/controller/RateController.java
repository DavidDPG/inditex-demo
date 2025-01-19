package com.daviddpg.inditexdemo.application.controller;

import com.daviddpg.inditexdemo.application.dto.RateOutputDto;
import com.daviddpg.inditexdemo.service.RateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/rates")
public class RateController {

    // Custom date time formatter in order to format output dates as per the format in requirements.txt
    public static final DateTimeFormatter INDITEX_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    // In a real world model with real brand and product entities, using @PathVariable could be better suited
    // However I thought about it and I could not come up with a good enough pattern to justify them in this slice case
    @GetMapping
    public ResponseEntity<RateOutputDto> getRateByProductAndBrandAndDate(
            @RequestParam Long productId,
            @RequestParam Integer brandId,
            // I'd rather parse the LocalDateTime here than configure the jackson deserializer to use the custom format on the requirements.txt
            // If that was an application-wide format then configuring jackson would be better.
            @RequestParam String dateTime
    ) {
        log.info("GET /rates?productId={}&brand={}&date={}", productId, brandId, dateTime);

        log.debug("Parsing dateTime: {}", dateTime);
        var parsedDateTime = LocalDateTime.parse(dateTime, INDITEX_DATE_TIME_FORMATTER);

        var rate = rateService.getRateForProductBrandInDate(brandId, productId, parsedDateTime);
        var rateDto = RateOutputDto.ofEntity(rate);

        log.debug("Returning rateDto: {}", rateDto);
        return ResponseEntity.ok(rateDto);
    }

}
