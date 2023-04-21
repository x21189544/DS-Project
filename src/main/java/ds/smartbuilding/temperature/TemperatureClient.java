package ds.smartbuilding.temperature;
//NOT USED REPLACED BY TEMPERATUREGUI
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class TemperatureClient {
	//create logger
	private static final Logger logger = Logger.getLogger(TemperatureClient.class.getName());
	
	//create blockingStub
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
	
	//set temperature method
	public static void setTemp() {
		try {
			//hardcode vars for testing
			String areaCode = "Floor1";
			double temp = 21.6;
			//send set request
			setTempRequest request = setTempRequest.newBuilder().setAreaCode(areaCode).setTemperature(temp).build();
			
			//get set response
			setTempResponse response = blockingStub.setTemp(request);
			System.out.println("Setting temperature in area "+ areaCode + " to "+ temp);
		}
		//catch runtime exception
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    return;		   
	    }
	}
	
	public static void requestTemp() {
		try {
			//hardcode vars for testing
			String areaCode = "Floor1";
			//send get request
			getTempRequest request = getTempRequest.newBuilder().setAreaCode(areaCode).build();
			
			//get get response
			getTempResponse response = blockingStub.getTemp(request);
			System.out.println("Temp is: "+ response.getTemperature());
		}
		//catch runtime exception
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    return;		   
	    }  
	}
	
}