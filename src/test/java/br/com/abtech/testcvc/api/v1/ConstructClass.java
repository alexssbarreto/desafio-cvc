package br.com.abtech.testcvc.api.v1;

import br.com.abtech.testcvc.api.v1.client.response.HotelResponse;
import br.com.abtech.testcvc.api.v1.client.response.PriceResponse;
import br.com.abtech.testcvc.api.v1.client.response.RoomResponse;
import br.com.abtech.testcvc.api.v1.travel.SimulationTravelDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ConstructClass {

    public static RoomResponse buildRoomResponse() {
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setAdult(BigDecimal.valueOf(100));
        priceResponse.setChild(BigDecimal.valueOf(50));

        RoomResponse roomResponse = new RoomResponse();
        roomResponse.setRoomID(0);
        roomResponse.setCategoryName("Standard");
        roomResponse.setPrice(priceResponse);

        return roomResponse;
    }

    public static HotelResponse buildHotelResponse() {
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setId(1);
        hotelResponse.setCityCode(1032);
        hotelResponse.setCityName("Porto Seguro");
        hotelResponse.setName("Hotel Teste 1");
        hotelResponse.setRooms(Arrays.asList(buildRoomResponse()));

        return hotelResponse;
    }

    public static List<HotelResponse> buildListHotelResponse() {
        HotelResponse hotelResponse = new HotelResponse();
        hotelResponse.setId(1);
        hotelResponse.setCityCode(1032);
        hotelResponse.setCityName("Porto Seguro");
        hotelResponse.setName("Hotel Teste 1");
        hotelResponse.setRooms(Arrays.asList(buildRoomResponse()));

        return Arrays.asList(hotelResponse);
    }

    public static SimulationTravelDTO buildSimulationTravelDTO() {
        SimulationTravelDTO simulationTravelDTO = new SimulationTravelDTO();
        simulationTravelDTO.setCheckIn(LocalDate.now());
        simulationTravelDTO.setCheckOut(LocalDate.now().plusDays(5));
        simulationTravelDTO.setNumAdult(2);
        simulationTravelDTO.setNumChild(1);
        simulationTravelDTO.setCityCode(1);
        simulationTravelDTO.setHotelId(1);

        return simulationTravelDTO;
    }
}
