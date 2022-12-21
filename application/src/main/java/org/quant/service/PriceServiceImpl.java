package org.quant.service;

import org.quant.domain.model.PriceDto;
import org.quant.domain.port.PricePersistencePort;
import org.springframework.stereotype.Service;

@Service
public class PriceServiceImpl implements PriceService {

    private final PricePersistencePort pricePersistencePort;

    public PriceServiceImpl(PricePersistencePort pricePersistencePort) {
        this.pricePersistencePort = pricePersistencePort;
    }

    @Override
    public PriceDto getPriceByBrandProductDate(Integer brandId, Integer productId, String date) {
        return pricePersistencePort.getPriceByBrandProductDate(brandId, productId, date);
    }
}
