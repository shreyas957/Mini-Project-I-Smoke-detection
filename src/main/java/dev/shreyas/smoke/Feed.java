package dev.shreyas.smoke;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Objects;

public class Feed {

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Date createdAt;
    @JsonProperty("entry_id")
    private Long entryId;
    @JsonProperty("field1")
    private String field1;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Feed() {

    }

    public Feed(Date createdAt, Long entryId, String field1) {
        this.createdAt = createdAt;
        this.entryId = entryId;
        this.field1 = field1;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getEntryId() {
        return entryId;
    }

    public void setEntryId(Long entryId) {
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
        return "Feed{" +
                "createdAt=" + createdAt +
                ", entryId=" + entryId +
                ", field1='" + field1 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feed feed = (Feed) o;
        return entryId == feed.entryId && Objects.equals(createdAt, feed.createdAt) && Objects.equals(field1, feed.field1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, entryId, field1);
    }
}

