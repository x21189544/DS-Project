package ds.smartbuilding.lighting;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import ds.smartbuilding.lighting.LightServiceGrpc.LightServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class LightingClient {
	//create logger
	private static final Logger logger = Logger.getLogger(LightingClient.class.getName());
	
	//create blockingStub
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
	
	//Light On method
	public static void lightOn() {
		try {
			//hardcode vars for testing
			String areaCode = "Floor1";
			//Light On request
			lightOnRequest request = lightOnRequest.newBuilder().setAreaCode(areaCode).build();
		
			//Light On response
			lightResponse response = blockingStub.lightOn(request);
			System.out.println("Lights in area "+ areaCode + " turned on.");
		}
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		   
	    }
	}
	
	//Light Off method
	public static void lightOff() {
		try {
			//hardcode vars for testing
			String areaCode = "Floor3";
			//Light Off request
			lightOffRequest request = lightOffRequest.newBuilder().setAreaCode(areaCode).build();
			
			//Light Off response
			lightResponse response = blockingStub.lightOff(request);
			System.out.println("Lights in area "+ areaCode + " turned off.");
		}
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    return;		   
	    }
	}
}