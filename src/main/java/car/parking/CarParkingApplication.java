package car.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "car.parking")
public class CarParkingApplication {
    public static void main(String[] args) {
        SpringApplication.run(CarParkingApplication.class, args);
    }
}