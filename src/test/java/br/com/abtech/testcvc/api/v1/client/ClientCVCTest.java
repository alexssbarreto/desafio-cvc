package br.com.abtech.testcvc.api.v1.client;

import br.com.abtech.testcvc.api.v1.client.response.HotelResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientCVCTest {

    @Autowired
    private ClientCVC clientCVC;

    @Test
    public void shoudHotels_whenFindCodeCity() {
        List<HotelResponse> result = this.clientCVC.findHotelsByCity(1032);

        assertNotNull(result);
    }

    @Test
    public void shoudHotels_whenFindIdHotel_thenSuccess() {
        List<HotelResponse> result = this.clientCVC.findHotelsById(1);

        assertNotNull(result);
    }
}
