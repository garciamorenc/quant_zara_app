package org.quant.api;

import org.quant.domain.model.PriceDto;
import org.quant.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceControllerImpl implements PriceController {

    private final PriceService priceService;

    public PriceControllerImpl(PriceService priceService) {
        this.priceService = priceService;
    }

    @Override
    public ResponseEntity<PriceDto> getPriceByBrandProductDate(@RequestParam(name = "brandId") Integer brandId,
                                                               @RequestParam(name = "productId") Integer productId,
                                                               @RequestParam(name = "date") String date) {
        return new ResponseEntity<>(priceService.getPriceByBrandProductDate(brandId, productId, date), HttpStatus.OK);
    }
}
