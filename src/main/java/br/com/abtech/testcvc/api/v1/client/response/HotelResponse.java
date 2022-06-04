package br.com.abtech.testcvc.api.v1.client.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class HotelResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private Integer cityCode;
    private String cityName;
    private List<RoomResponse> rooms;

}
