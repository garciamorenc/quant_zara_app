package org.quant.infrastructure.jpa.adapter;

import org.quant.domain.model.PriceDto;
import org.quant.domain.port.PricePersistencePort;
import org.quant.infrastructure.jpa.entities.PriceEntity;
import org.quant.infrastructure.jpa.repository.PriceRepository;
import org.springframework.stereotype.Service;

@Service
public class PriceJpaAdapter implements PricePersistencePort {

    private final PriceRepository priceRepository;

    public PriceJpaAdapter(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public PriceDto getPriceByBrandProductDate(Integer brandId, Integer productId, String date) {
        var entity = priceRepository.findAllPrices(brandId, productId, date);
        return this.getPrices(entity);
    }

    private PriceDto getPrices(PriceEntity pricesEntity) {
        return PriceDto.builder()
                .brandId(pricesEntity.getBrandId())
                .startDate(pricesEntity.getStartDate())
                .endDate(pricesEntity.getEndDate())
                .priceList(pricesEntity.getPriceList())
                .productId(pricesEntity.getProductId())
                .price(pricesEntity.getPrice())
                .build();
    }
}
