package br.com.abtech.testcvc.api.v1.travel;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roomId;
    private String categoryName;
    private BigDecimal totalPrice;
    private PriceDetail priceDetail;

}
