package ds.smartbuilding.lighting;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import ds.smartbuilding.lighting.LightServiceGrpc.LightServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class LightingClient {
	private static final Logger logger = Logger.getLogger(LightingClient.class.getName());
	
	public static LightServiceGrpc.LightServiceBlockingStub blockingStub;
	
	public static void main(String[] args) throws Exception{
		//define host and port variables
		String host = "localhost";
		int port = 50056;
		
		//build channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs
		blockingStub = LightServiceGrpc.newBlockingStub(channel);
		
		LightingClient client = new LightingClient();
		
		//call functions
		lightOn();
		lightOff();
		//shutdown channel
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public static void lightOn() {
		try {
			String areaCode = "Floor1";
			lightOnRequest request = lightOnRequest.newBuilder().setAreaCode(areaCode).build();
		
			lightResponse response = blockingStub.lightOn(request);
			System.out.println("Lights in area "+ areaCode + " turned on.");
		}
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		   
	    }
	}
	
	
	public static void lightOff() {
		try {
			String areaCode = "Floor3";
			lightOffRequest request = lightOffRequest.newBuilder().setAreaCode(areaCode).build();
			
			lightResponse response = blockingStub.lightOff(request);
			System.out.println("Lights in area "+ areaCode + " turned off.");
		}
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		   
	    }
	}
}