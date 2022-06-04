package br.com.abtech.testcvc.api.v1.travel;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class SimulationTravelDTO {

    private Integer cityCode;

    private Integer hotelId;

    @NotNull
    private LocalDate checkIn;

    @NotNull
    private LocalDate checkOut;

    @NotNull
    private Integer numAdult;

    @NotNull
    private Integer numChild;

}
