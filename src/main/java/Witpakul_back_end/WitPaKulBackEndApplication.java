package Witpakul_back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class WitPaKulBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(WitPaKulBackEndApplication.class, args);
    }

    @GetMapping("/health")
    public String Gethealth(){
        return "Backend Service is Health";
    }

}
