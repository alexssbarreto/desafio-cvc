package br.com.abtech.testcvc.api.v1.travel;

import br.com.abtech.testcvc.api.v1.client.response.HotelResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorSimulationService {

    public List<Simulation> calc(SimulationTravelDTO simulationTravelDTO, List<HotelResponse> hotelResponse) {
        Integer numDays = intervalDate(simulationTravelDTO);

        List<Simulation> result = new ArrayList<>();

        hotelResponse.parallelStream().forEach(hotel -> {
            List<Room> rooms = new ArrayList<>();

            hotel.getRooms().parallelStream().forEach(roomResponse -> {
                BigDecimal valueForAdult = this.valueForPerson(numDays, roomResponse.getPrice().getAdult());
                BigDecimal comissionAdult = this.comission(valueForAdult);
                BigDecimal subtotalAdult = comissionAdult.multiply(BigDecimal.valueOf(simulationTravelDTO.getNumAdult()));

                BigDecimal valueForChild = this.valueForPerson(numDays, roomResponse.getPrice().getChild());
                BigDecimal comissionChild = this.comission(valueForChild);
                BigDecimal subtotalChild = comissionChild.multiply(BigDecimal.valueOf(simulationTravelDTO.getNumChild()));

                BigDecimal totalPrice = subtotalAdult.add(subtotalChild);

                PriceDetail priceDetail = new PriceDetail();
                priceDetail.setPricePerDayAdult(comissionAdult);
                priceDetail.setPricePerDayChild(comissionChild);

                Room room = new Room();
                room.setRoomId(roomResponse.getRoomID());
                room.setCategoryName(roomResponse.getCategoryName());
                room.setPriceDetail(priceDetail);
                room.setTotalPrice(totalPrice);

                rooms.add(room);
            });

            Simulation simulation = new Simulation();
            simulation.setId(1);
            simulation.setCityName(hotel.getCityName());
            simulation.setRooms(rooms);

            result.add(simulation);
        });

        return result;
    }

    private BigDecimal valueForPerson(Integer numDays, BigDecimal value) {
        BigDecimal numDaysFinal = BigDecimal.valueOf(numDays);

        return numDaysFinal.multiply(value);
    }

    private BigDecimal comission(BigDecimal value) {
        return value.divide(BigDecimal.valueOf(0.7), 2, RoundingMode.HALF_UP);
    }

    private Integer intervalDate(SimulationTravelDTO simulationTravelDTO) {
        Integer numDays = Period.between(simulationTravelDTO.getCheckIn(), simulationTravelDTO.getCheckOut()).getDays();

        if (numDays == 0) {
            numDays++;
        }

        return numDays;
    }
}