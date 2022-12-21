package org.quant.domain.model;

import lombok.Builder;

public record PriceDto(
        Integer brandId,
        String startDate,
        String endDate,
        Integer priceList,
        Integer productId,
        Double price
) {
    @Builder
    public PriceDto {
    }
}
