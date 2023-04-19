package ds.smartbuilding.temperature;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class TemperatureClient {
	private static final Logger logger = Logger.getLogger(TemperatureClient.class.getName());
	
	public static TemperatureServiceGrpc.TemperatureServiceBlockingStub blockingStub;
	
	public static void main(String[] args) throws Exception{
		//define host and port variables
		String host = "localhost";
		int port = 50055;
		
		//build channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs
		blockingStub = TemperatureServiceGrpc.newBlockingStub(channel);
		
		TemperatureClient client = new TemperatureClient();
		
		//call functions
		requestTemp();
		setTemp();
		
		//shutdown channel
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	
	public static void setTemp() {
		try {
			String areaCode = "Floor1";
			double temp = 21.6;
			setTempRequest request = setTempRequest.newBuilder().setAreaCode(areaCode).setTemperature(temp).build();
			
			setTempResponse response = blockingStub.setTemp(request);
			System.out.println("Setting temperature in area "+ areaCode + " to "+ temp);
		}
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		   
	    }
	}
	
	public static void requestTemp() {
		try {
			String areaCode = "Floor1";
			getTempRequest request = getTempRequest.newBuilder().setAreaCode(areaCode).build();
			
			getTempResponse response = blockingStub.getTemp(request);
			System.out.println("Temp is: "+ response.getTemperature());
		}
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		   
	    }  
		
	}
	
}