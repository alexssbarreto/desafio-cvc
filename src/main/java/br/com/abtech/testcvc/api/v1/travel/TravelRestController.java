package br.com.abtech.testcvc.api.v1.travel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/travels")
public class TravelRestController {

    private final TravelService travelService;

    public TravelRestController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping("/hotels")
    public ResponseEntity<List<Simulation>> simularioForHotels(@Valid SimulationTravelDTO simulationTravelDTO) {
        List<Simulation> simulations = this.travelService.simulationTravelForHotels(simulationTravelDTO);

        return ResponseEntity.ok().body(simulations);
    }

    @GetMapping("/hotel")
    public ResponseEntity<Simulation> simularioForHotel(@Valid SimulationTravelDTO simulationTravelDTO) {
        Simulation simulation = this.travelService.simulationTravelForHotel(simulationTravelDTO);

        return ResponseEntity.ok().body(simulation);
    }
}
