package br.com.abtech.testcvc.api.v1.client;

import br.com.abtech.testcvc.api.v1.client.response.HotelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class ClientCVC {

    @Value("${host_cvc:}")
    private String hotels;

    @Autowired
    RestTemplate restTemplate;

    public List<HotelResponse> findHotelsByCity(Integer id) {
        StringBuilder url = new StringBuilder(this.hotels);
        url.append("/hotels/avail/");
        url.append(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try {
            ResponseEntity<HotelResponse[]> response = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, HotelResponse[].class);

            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Serviço externo indisponível");
        }
    }

    public List<HotelResponse> findHotelsById(Integer id) {
        StringBuilder url = new StringBuilder(this.hotels);
        url.append("/hotels/");
        url.append(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        try {
            ResponseEntity<HotelResponse[]> response = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, HotelResponse[].class);

            return Arrays.asList(response.getBody());
        } catch (Exception e) {
            throw new RuntimeException("Serviço externo indisponível");
        }
    }
}