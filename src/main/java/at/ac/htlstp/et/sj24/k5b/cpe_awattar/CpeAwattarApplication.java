package at.ac.htlstp.et.sj24.k5b.cpe_awattar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class CpeAwattarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CpeAwattarApplication.class, args);
    }

}
