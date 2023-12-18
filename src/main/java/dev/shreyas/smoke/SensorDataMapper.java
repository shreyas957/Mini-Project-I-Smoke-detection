package dev.shreyas.smoke;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class SensorDataMapper {

    public static SensorData mapJsonToSensorData(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            SensorDataWrapper sensorDataWrapper = objectMapper.readValue(json, SensorDataWrapper.class);
            return sensorDataWrapper.getSensorData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // Handle exception as needed
        }
        return null;
    }

    private static class SensorDataWrapper {
        @JsonProperty("channel")
        private Channel channel;

        @JsonCreator
        private SensorDataWrapper(Channel channel) {
            this.channel = channel;
        }

        // Getter and setter for channel
        public Channel getChannel() {
            return channel;
        }

        public void setChannel(Channel channel) {
            this.channel = channel;
        }

        public SensorData getSensorData() {
            SensorData sensorData = new SensorData();
            sensorData.setName("Smoke Value");
            sensorData.setCreatedAt(channel.getFeeds().get(0).getCreatedAt());
            sensorData.setEntryId((channel.getFeeds().get(0).getEntryId()).intValue());
            if (channel.getFeeds() != null && !channel.getFeeds().isEmpty()) {
                sensorData.setField1(channel.getFeeds().get(0).getField1());
            }
            return sensorData;
        }
    }
}

