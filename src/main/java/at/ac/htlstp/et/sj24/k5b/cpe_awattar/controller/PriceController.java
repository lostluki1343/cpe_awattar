package at.ac.htlstp.et.sj24.k5b.cpe_awattar.controller;

import at.ac.htlstp.et.sj24.k5b.cpe_awattar.model.PriceData;
import at.ac.htlstp.et.sj24.k5b.cpe_awattar.service.AwattarAjaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PriceController {

    @Autowired
    private AwattarAjaxService awattarService;

    @GetMapping("/prices")
    public String showPrices(
            @RequestParam(value = "start", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime start,
            @RequestParam(value = "end", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime end,
            Model model) {

        if (start == null || end == null) {
            start = LocalDateTime.now();
            end = start.plusHours(24);
        }

        List<PriceData> prices = awattarService.fetchPrices(start, end);
        model.addAttribute("prices", prices);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "forward:/index.html";

    }
}
