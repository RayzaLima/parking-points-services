package parkingpointsservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ParkingPointsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingPointsApplication.class, args);
	}

	@GetMapping("/hello")
	public String index() {
		return "Teste de Conecxão com o Postman";
	}

}
