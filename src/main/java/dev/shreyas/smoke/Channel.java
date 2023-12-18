package dev.shreyas.smoke;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(allowSetters = true, ignoreUnknown = true)
public class Channel {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("field1")
    private String field1;
    @JsonProperty("channel.created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Date createdAt;
    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Date updatedAt;
    @JsonProperty("last_entry_id")
    private int lastEntryId;
    @JsonProperty("feeds")
    private List<Feed> feeds;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Channel() {

    }

    public Channel(
            Long id, String name, String latitude, String longitude,
            String field1, Date createdAt, Date updatedAt, int lastEntryId, List<Feed> feeds
    ) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.field1 = field1;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastEntryId = lastEntryId;
        this.feeds = feeds;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getLastEntryId() {
        return lastEntryId;
    }

    public void setLastEntryId(int lastEntryId) {
        this.lastEntryId = lastEntryId;
    }

    public List<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Feed> feeds) {
        this.feeds = feeds;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", field1='" + field1 + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", lastEntryId=" + lastEntryId +
                ", feeds=" + feeds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return lastEntryId == channel.lastEntryId && Objects.equals(id, channel.id) && Objects.equals(name, channel.name) && Objects.equals(latitude, channel.latitude) && Objects.equals(longitude, channel.longitude) && Objects.equals(field1, channel.field1) && Objects.equals(createdAt, channel.createdAt) && Objects.equals(updatedAt, channel.updatedAt) && Objects.equals(feeds, channel.feeds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, field1, createdAt, updatedAt, lastEntryId, feeds);
    }
}
