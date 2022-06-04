package br.com.abtech.testcvc.api.v1.travel;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Simulation implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String cityName;
    private List<Room> rooms;

}
