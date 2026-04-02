package util;

import java.time.Instant;
import java.util.Date;
import com.garmin.fit.SessionMesg;
import model.Activity;

public class FitExtractor {
    
    public Activity extractSession(SessionMesg session) {
        Activity activity = new Activity();
        
        // Start time
        if (session.getStartTime() != null) {
            Date dateTime = session.getStartTime().getDate();
            if (dateTime != null) {
                activity.setStartTime(dateTime.toInstant());
            }
        }
        
        // Elapsed time
        Float elapsedSeconds = session.getTotalElapsedTime();
        if (elapsedSeconds != null) {
            activity.setElapsedTimeSeconds(Math.round(elapsedSeconds));
        }
        
        // Distance
        Float distance = session.getTotalDistance();
        if (distance != null) {
            activity.setDistanceMeters(distance.doubleValue());
        }
        
        // Average heart rate
        Short avgHr = session.getAvgHeartRate();
        if (avgHr != null) {
            activity.setAvgHeartRate(avgHr.intValue());
        }
        
        // Max heart rate
        Short maxHr = session.getMaxHeartRate();
        if (maxHr != null) {
            activity.setMaxHeartRate(maxHr.intValue());
        }
        
        // Total ascent
        Integer ascent = session.getTotalAscent();
        if (ascent != null) {
            activity.setTotalAscentMeters(ascent.doubleValue());
        }
        
        // Total descent
        Integer descent = session.getTotalDescent();
        if (descent != null) {
            activity.setTotalDescentMeters(descent.doubleValue());
        }
        
        // Sport
        if (session.getSportProfileName() != null) {
            activity.setSport(session.getSportProfileName());
        }
        
        return activity;
    }
}