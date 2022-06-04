package br.com.abtech.testcvc.api.v1.client.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PriceResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    BigDecimal adult;
    BigDecimal child;
}
