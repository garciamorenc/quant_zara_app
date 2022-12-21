package org.quant.infrastructure.jpa.repository;

import org.quant.infrastructure.jpa.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query(value = "SELECT TOP 1 * " +
                    "FROM PRICES " +
                    "WHERE BRAND_ID = (:brandId) " +
                    "AND PRODUCT_ID = (:productId) " +
                    "AND (:date) BETWEEN START_DATE AND END_DATE " +
            "ORDER BY PRIORITY DESC",
            nativeQuery = true)
    PriceEntity findAllPrices(@Param("brandId") Integer brandId, @Param("productId")Integer productId, @Param("date") String date);
}
