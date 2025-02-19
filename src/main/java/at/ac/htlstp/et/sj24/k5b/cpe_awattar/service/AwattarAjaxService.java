package at.ac.htlstp.et.sj24.k5b.cpe_awattar.service;

import at.ac.htlstp.et.sj24.k5b.cpe_awattar.model.AwattarResponse;
import at.ac.htlstp.et.sj24.k5b.cpe_awattar.model.PriceData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AwattarAjaxService {

    long endTimestamp = System.currentTimeMillis() + (2 * 24 * 60 * 60 * 1000);


    private final RestTemplate restTemplate = new RestTemplate();
    private final String AWATTAR_API_URL = "https://api.awattar.at/v1/marketdata?start=1561932000000&end="+endTimestamp;

    public List<PriceData> fetchPrices(LocalDateTime start, LocalDateTime end) {
        System.out.println("Rufe API für Zeitraum: " + start + " bis " + end + " auf.");
        try {
            AwattarResponse response = restTemplate.getForObject(AWATTAR_API_URL, AwattarResponse.class);
            if (response == null || response.getData() == null) {
                System.out.println("Keine Daten empfangen.");
                return Collections.emptyList();
            }
            List<PriceData> filtered = response.getData().stream()
                    .filter(price -> {
                        LocalDateTime timestamp = price.getStartTimestamp();
                        return (timestamp.isEqual(start) || timestamp.isAfter(start))
                                && (timestamp.isEqual(end)   || timestamp.isBefore(end));
                    })
                    .collect(Collectors.toList());
            System.out.println("Empfangene und gefilterte Daten: " + filtered.size() + " Einträge.");
            return filtered;
        } catch (Exception e) {
            System.out.println("Fehler beim Abrufen der Daten: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
