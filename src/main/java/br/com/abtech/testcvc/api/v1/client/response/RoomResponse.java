package br.com.abtech.testcvc.api.v1.client.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RoomResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer roomID;
    private String categoryName;
    private PriceResponse price;

}
