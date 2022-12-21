package org.quant.domain.port;

import org.quant.domain.model.PriceDto;

public interface PricePersistencePort {
    PriceDto getPriceByBrandProductDate(Integer brandId, Integer productId, String date);
}
