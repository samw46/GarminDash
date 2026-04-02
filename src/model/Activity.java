package model;

import java.time.Instant;
import java.time.LocalDateTime;

public class Activity {
    private Instant startTime;
    private Integer elapsedTimeSeconds;
    private Double distanceMeters;
    private Integer avgHeartRate;
    private Integer maxHeartRate;
    private Double totalAscentMeters;
    private Double totalDescentMeters;
    private String sport;
    
    // Getters
    public Instant getStartTime() {
        return startTime;
    }
    
    public Integer getElapsedTimeSeconds() {
        return elapsedTimeSeconds;
    }
    
    public Double getDistanceMeters() {
        return distanceMeters;
    }
    
    public Integer getAvgHeartRate() {
        return avgHeartRate;
    }
    
    public Integer getMaxHeartRate() {
        return maxHeartRate;
    }
    
    public Double getTotalAscentMeters() {
        return totalAscentMeters;
    }
    
    public Double getTotalDescentMeters() {
        return totalDescentMeters;
    }
    
    public String getSport() {
        return sport;
    }
    
    // Setters
    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }
    
    public void setElapsedTimeSeconds(Integer elapsedTimeSeconds) {
        this.elapsedTimeSeconds = elapsedTimeSeconds;
    }
    
    public void setDistanceMeters(Double distanceMeters) {
        this.distanceMeters = distanceMeters;
    }
    
    public void setAvgHeartRate(Integer avgHeartRate) {
        this.avgHeartRate = avgHeartRate;
    }
    
    public void setMaxHeartRate(Integer maxHeartRate) {
        this.maxHeartRate = maxHeartRate;
    }
    
    public void setTotalAscentMeters(Double totalAscentMeters) {
        this.totalAscentMeters = totalAscentMeters;
    }
    
    public void setTotalDescentMeters(Double totalDescentMeters) {
        this.totalDescentMeters = totalDescentMeters;
    }
    
    public void setSport(String sport) {
        this.sport = sport;
    }
}