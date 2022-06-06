package br.com.abtech.testcvc.api.v1.travel;

import br.com.abtech.testcvc.api.v1.ConstructClass;
import br.com.abtech.testcvc.api.v1.client.ClientCVC;
import br.com.abtech.testcvc.api.v1.client.response.HotelResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TravelServiceTest {

    @Autowired
    private TravelService travelService;

    @MockBean
    private ClientCVC clientCVC;

    private SimulationTravelDTO simulationTravelDTO;

    private List<HotelResponse> hotelResponses;

    @BeforeEach
    public void setup() {
        this.simulationTravelDTO = ConstructClass.buildSimulationTravelDTO();
        this.hotelResponses = ConstructClass.buildListHotelResponse();

        when(this.clientCVC.findHotelsById(any())).thenReturn(this.hotelResponses);
        when(this.clientCVC.findHotelsByCity(any())).thenReturn(this.hotelResponses);
    }

    @Test
    public void shoudBeSimulationForHotels_WhenFiveDaysAndTwoAdultAndOneChildAndCostAdultHundredAndCostChildFifty() {
        List<Simulation> result = this.travelService.simulationTravelForHotels(this.simulationTravelDTO);

        assertEquals(BigDecimal.valueOf(142.86), result.get(0).getRooms().get(0).getPriceDetail().pricePerDayAdult);
        assertEquals(BigDecimal.valueOf(71.43), result.get(0).getRooms().get(0).getPriceDetail().pricePerDayChild);
        assertEquals(BigDecimal.valueOf(3035.71), result.get(0).getRooms().get(0).getTotalPrice());
    }

    @Test
    public void shoudBeSimulationForHotels_WhenThreeDaysAndTwoAdultAndOneChildAndCostAdultHundredAndCostChildFifty() {
        simulationTravelDTO.setCheckIn(LocalDate.now());
        simulationTravelDTO.setCheckOut(LocalDate.now().plusDays(3));

        List<Simulation> result = this.travelService.simulationTravelForHotels(this.simulationTravelDTO);

        assertEquals(BigDecimal.valueOf(142.86), result.get(0).getRooms().get(0).getPriceDetail().pricePerDayAdult);
        assertEquals(BigDecimal.valueOf(71.43), result.get(0).getRooms().get(0).getPriceDetail().pricePerDayChild);
        assertEquals(BigDecimal.valueOf(1821.43), result.get(0).getRooms().get(0).getTotalPrice());
    }

    @Test
    public void shoudBeSimulationForHotel_WhenFiveDaysAndTwoAdultAndOneChildAndCostAdultHundredAndCostChildFifty() {
        Simulation result = this.travelService.simulationTravelForHotel(this.simulationTravelDTO);

        assertEquals(BigDecimal.valueOf(142.86), result.getRooms().get(0).getPriceDetail().pricePerDayAdult);
        assertEquals(BigDecimal.valueOf(71.43), result.getRooms().get(0).getPriceDetail().pricePerDayChild);
        assertEquals(BigDecimal.valueOf(3035.71), result.getRooms().get(0).getTotalPrice());
    }

    @Test
    public void shoudBeSimulationForHotel_WhenThreeDaysAndTwoAdultAndOneChildAndCostAdultHundredAndCostChildFifty() {
        simulationTravelDTO.setCheckIn(LocalDate.now());
        simulationTravelDTO.setCheckOut(LocalDate.now().plusDays(3));

        Simulation result = this.travelService.simulationTravelForHotel(this.simulationTravelDTO);

        assertEquals(BigDecimal.valueOf(142.86), result.getRooms().get(0).getPriceDetail().pricePerDayAdult);
        assertEquals(BigDecimal.valueOf(71.43), result.getRooms().get(0).getPriceDetail().pricePerDayChild);
        assertEquals(BigDecimal.valueOf(1821.43), result.getRooms().get(0).getTotalPrice());
    }
}
