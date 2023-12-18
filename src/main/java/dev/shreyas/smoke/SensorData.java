package dev.shreyas.smoke;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "sensor_data")
@JsonDeserialize(builder = SensorData.class)
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Date createdAt;

    private int entryId;

    private String field1;

    public SensorData() {
    }

    public SensorData(Long id, String name, Date createdAt, int entryId, String field1) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.entryId = entryId;
        this.field1 = field1;
    }

    public SensorData(String name, Date createdAt, int entryId, String field1) {
        this.name = name;
        this.createdAt = createdAt;
        this.entryId = entryId;
        this.field1 = field1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", entryId=" + entryId +
                ", field1='" + field1 + '\'' +
                '}';
    }
}

