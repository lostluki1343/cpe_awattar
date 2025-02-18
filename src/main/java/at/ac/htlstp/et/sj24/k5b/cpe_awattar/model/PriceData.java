package at.ac.htlstp.et.sj24.k5b.cpe_awattar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.LocalDateTime;

public class PriceData {

    @JsonProperty("start_timestamp")
    @JsonDeserialize(using = LocalDateTimeEpochDeserializer.class)
    private LocalDateTime startTimestamp;

    @JsonProperty("end_timestamp")
    @JsonDeserialize(using = LocalDateTimeEpochDeserializer.class)
    private LocalDateTime endTimestamp;

    @JsonProperty("marketprice")
    private Double marketprice;

    // Getter und Setter

    public LocalDateTime getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(LocalDateTime startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public LocalDateTime getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(LocalDateTime endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public Double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(Double marketprice) {
        this.marketprice = marketprice;
    }
}
