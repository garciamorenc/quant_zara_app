package org.quant.service;

import org.quant.domain.model.PriceDto;

public interface PriceService {
    PriceDto getPriceByBrandProductDate(Integer brandId, Integer productId, String date);
}
