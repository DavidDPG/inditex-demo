package com.daviddpg.inditexdemo.domain.entity;

import com.daviddpg.inditexdemo.domain.valueobject.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class Rate {

    private final RateId rateId;
    private final BrandId brandId;
    private final ProductId productId;
    private final RateCurrency currency;
    private final RatePrice price;
    private final RatePriority priority;
    private final RateStartDate startDate;
    private final RateEndDate endDate;

    public boolean matchesWithDateTime(LocalDateTime dateTime) {
        return startDate.isSameOrBeforeThan(dateTime) && endDate.isSameOrAfterThan(dateTime);
    }

    public RateId getRateId() {
        return rateId;
    }

    public BrandId getBrandId() {
        return brandId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public RateCurrency getCurrency() {
        return currency;
    }

    public RatePrice getPrice() {
        return price;
    }

    public RatePriority getPriority() {
        return priority;
    }

    public RateStartDate getStartDate() {
        return startDate;
    }

    public RateEndDate getEndDate() {
        return endDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    private Rate(Builder builder) {
        this.rateId = builder.rateId;
        this.brandId = builder.brandId;
        this.productId = builder.productId;
        this.currency = builder.currency;
        this.price = builder.price;
        this.priority = builder.priority;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public static final class Builder {
        private RateId rateId;
        private BrandId brandId;
        private ProductId productId;
        private RateCurrency currency;
        private RatePrice price;
        private RatePriority priority;
        private RateStartDate startDate;
        private RateEndDate endDate;

        private Builder() {
        }

        public Builder rateId(final RateId rateId) {
            this.rateId = rateId;
            return this;
        }

        public Builder brandId(final BrandId brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder productId(final ProductId productId) {
            this.productId = productId;
            return this;
        }

        public Builder currency(final RateCurrency currency) {
            this.currency = currency;
            return this;
        }

        public Builder price(final RatePrice price) {
            this.price = price;
            return this;
        }

        public Builder priority(final RatePriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder startDate(final RateStartDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(final RateEndDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Rate build() {
            return new Rate(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate rate = (Rate) o;
        return Objects.equals(rateId, rate.rateId)
                && Objects.equals(brandId, rate.brandId)
                && Objects.equals(productId, rate.productId)
                && Objects.equals(currency, rate.currency)
                && Objects.equals(price, rate.price)
                && Objects.equals(priority, rate.priority)
                && Objects.equals(startDate, rate.startDate)
                && Objects.equals(endDate, rate.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateId, brandId, productId, currency, price, priority, startDate, endDate);
    }
}
