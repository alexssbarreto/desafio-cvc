package br.com.abtech.testcvc.api.v1.travel;

import br.com.abtech.testcvc.api.v1.client.ClientCVC;
import br.com.abtech.testcvc.api.v1.client.response.HotelResponse;
import br.com.abtech.testcvc.api.v1.exception.ErrorSystem;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Period;
import java.util.*;

@Service
@Validated
public class TravelService {

    private ClientCVC clientCVC;

    private CalculatorSimulationService calculatorSimulationService;

    public TravelService(
            ClientCVC clientCVC,
            CalculatorSimulationService calculatorSimulationService
    ) {
        this.clientCVC = clientCVC;
        this.calculatorSimulationService = calculatorSimulationService;
    }

    public List<Simulation> simulationTravelForHotels(@Valid SimulationTravelDTO simulationTravelDTO) {
        if (simulationTravelDTO.getCityCode() == null) {
            throw new ErrorSystem("cityCode é obrigatório.");
        }

        List<HotelResponse> hotelResponses = this.clientCVC.findHotelsByCity(simulationTravelDTO.getCityCode());

        if (hotelResponses.isEmpty()) {
            throw new RuntimeException("Cidade não encontrada");
        }

        return this.calculatorSimulationService.calc(simulationTravelDTO, hotelResponses);
    }

    public Simulation simulationTravelForHotel(@Valid SimulationTravelDTO simulationTravelDTO) {
        if (simulationTravelDTO.getHotelId() == null) {
            throw new ErrorSystem("hotelId é obrigatório.");
        }

        List<HotelResponse> hotelResponses = this.clientCVC.findHotelsById(simulationTravelDTO.getHotelId());

        if (hotelResponses.isEmpty()) {
            throw new RuntimeException("Cidade não encontrada");
        }

        return this.calculatorSimulationService.calc(simulationTravelDTO, hotelResponses).get(0);
    }
}
