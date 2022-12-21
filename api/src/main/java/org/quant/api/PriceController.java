package org.quant.api;

import org.quant.domain.model.PriceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PriceController {
    @GetMapping("/prices")
    ResponseEntity<PriceDto> getPriceByBrandProductDate(Integer brandId, Integer productId, String date);
}
