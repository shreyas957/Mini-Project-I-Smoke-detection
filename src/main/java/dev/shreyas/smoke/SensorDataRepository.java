package dev.shreyas.smoke;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    boolean existsByCreatedAt(Date createdAt);
}
