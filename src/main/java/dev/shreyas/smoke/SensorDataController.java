package dev.shreyas.smoke;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/smokeValue")
public class SensorDataController {

    private final SensorDataService sensorDataService;

    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @GetMapping
    public List<SensorData> getSmokeData() {
//        sensorDataService.saveLatestSensorData();
        return sensorDataService.getSensorData();
    }

    @Scheduled(fixedRate = 40_000)
    public void getDataFromApi() {
        sensorDataService.saveLatestSensorData();

    }

}
