package dev.shreyas.smoke;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SensorDataService {

    private final SensorDataRepository sensorDataRepository;
    private final String apiUrl;

    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
        this.apiUrl = "https://api.thingspeak.com/channels/2376414/feeds.json?api_key=XZOFVC4PYTOA3QN0&results=1";
    }

    public void saveLatestSensorData() {
        RestTemplate restTemplate = new RestTemplate();
        String json = restTemplate.getForObject(apiUrl, String.class);
        System.out.println(json);
        SensorData sensorData = SensorDataMapper.mapJsonToSensorData(json);

        if (sensorData != null && !checkSensorDataExists(sensorData)) {
            sensorDataRepository.save(sensorData);
            System.out.println(sensorData);
        } else {
            System.out.println("SensorData is NULL OR already exists");
        }
    }

    public boolean checkSensorDataExists(SensorData sensorData) {
        return sensorDataRepository.existsByCreatedAt(sensorData.getCreatedAt());
    }

    public List<SensorData> getSensorData() {
        return sensorDataRepository.findAll();
    }
}

