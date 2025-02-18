package at.ac.htlstp.et.sj24.k5b.cpe_awattar.controller;

import at.ac.htlstp.et.sj24.k5b.cpe_awattar.model.PriceData;
import at.ac.htlstp.et.sj24.k5b.cpe_awattar.service.AwattarAjaxService;
import at.ac.htlstp.et.sj24.k5b.cpe_awattar.service.AwattarAjaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PriceRestController {

    @Autowired
    private AwattarAjaxService awattarService;

    @GetMapping("/api/prices")
    public List<PriceData> getPrices(
            @RequestParam(value = "start", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime start,
            @RequestParam(value = "end", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime end) {

        if (start == null || end == null) {
            start = LocalDateTime.now();
            end = start.plusHours(24);
        }
        return awattarService.fetchPrices(start, end);
    }
}
