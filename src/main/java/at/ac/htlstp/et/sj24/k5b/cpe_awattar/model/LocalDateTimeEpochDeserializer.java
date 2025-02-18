package at.ac.htlstp.et.sj24.k5b.cpe_awattar.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeEpochDeserializer extends StdDeserializer<LocalDateTime> {

    public LocalDateTimeEpochDeserializer() {
        this(null);
    }

    public LocalDateTimeEpochDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        long timestamp = p.getLongValue();
        // Hier wird der Zeitstempel (Millisekunden) in LocalDateTime umgewandelt.
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }
}
