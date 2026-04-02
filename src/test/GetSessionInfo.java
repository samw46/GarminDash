package test;

import com.garmin.fit.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GetSessionInfo {
	 public static void main(String[] args) {
	        System.out.printf("FIT Decoder Example Application - Protocol %d.%d Profile %d.%d %s\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION_MAJOR, Fit.PROFILE_VERSION_MINOR, Fit.PROFILE_TYPE);

	        if (args.length != 1) {
	            System.out.println("Usage: java -jar DecoderExample.jar <filename>");
	            return;
	        }

	        byte[] bytes;

	        try {
	            bytes = Files.readAllBytes(Paths.get(args[0]));
	        }
	        catch (java.io.IOException e) {
	            throw new RuntimeException("Error opening file " + args[0] + " [2]");
	        }

	        Decoder decoder = new Decoder(bytes);

	        // Use a FitListener to capture all decoded messages in a FitMessages object
	        FitListener fitListener = new FitListener();
	        decoder.addListener((MesgListener) fitListener);
	        decoder.addListener((DeveloperFieldDescriptionListener) fitListener);


	        // Use a MesgBroadcaster for easy integration with existing projects
	        // MesgBroadcaster mesgBroadcaster = new MesgBroadcaster();
	        // mesgBroadcaster.addListener((RecordMesgListener)customListener);
	        // mesgBroadcaster.addListener((MesgDefinitionListener)customListener);
	        // decoder.addListener((MesgListener) mesgBroadcaster);
	        // decoder.addListener((MesgDefinitionListener)mesgBroadcaster);

	        try {
	            decoder.read();

	            FitMessages fitMessages = fitListener.getFitMessages();

	            fitMessages.getFileIdMesgs().forEach(DecoderExample::printFileIdMesg);
	            fitMessages.getSessionMesgs().forEach(GetSessionInfo::displaySessionInfo);
	            
	            System.out.println("Decoded FIT file " + args[0] + ".");
	            
	        }
	        catch (Exception e) {
	            System.err.print("Exception decoding file: ");
	            System.err.println(e.getMessage());
	        }
	    }
	 public static void displaySessionInfo(SessionMesg mesg) {
		 System.out.println("Sport: " + mesg.getSportProfileName());
		 System.out.println("Average Heart Rate: " +  mesg.getAvgHeartRate());
		 System.out.println("Max Heart Rate: " + mesg.getMaxHeartRate());
		 System.out.println("Start Time " +mesg.getStartTime());
		 System.out.println("Calories Burned: " + mesg.getTotalCalories());
		 System.out.println("Total Elapsed Time: " + mesg.getTotalElapsedTime());
		 System.out.println("Total Distance: " + mesg.getTotalDistance());
		 System.out.println("Total Ascent: " + mesg.getTotalAscent());
		 System.out.println("Average Cadence: " + mesg.getAvgCadence());
	 }
	 
}
