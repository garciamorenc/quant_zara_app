package org.quant.infrastructure.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Prices")
@Getter
@Setter
@ToString
public class PriceEntity {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name="BRAND_ID")
    private Integer brandId;

    @Column(name="START_DATE")
    public String startDate;

    @Column(name="END_DATE")
    public String endDate;

    @Column(name="PRICE_LIST")
    public Integer priceList;

    @Column(name="PRODUCT_ID")
    public Integer productId;

    @Column(name="PRIORITY")
    public Integer priority;

    @Column(name="PRICE")
    public Double price;

    @Column(name="CURR")
    public String curr;
}
