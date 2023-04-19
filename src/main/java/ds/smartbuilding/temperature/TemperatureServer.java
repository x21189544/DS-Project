package ds.smartbuilding.temperature;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import ds.smartbuilding.temperature.TemperatureServiceGrpc.TemperatureServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class TemperatureServer extends TemperatureServiceImplBase {
	//create logger
	private static final Logger logger = Logger.getLogger(TemperatureServer.class.getName());
	
	public static void main(String[] args){
		TemperatureServer tempserver = new TemperatureServer();
		int port = 50055;
		try {
			Server server = ServerBuilder.forPort(port).addService(tempserver).build().start();
			logger.info("Server started, listening on " + port);
			server.awaitTermination();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//set Temperature Method gRPC
	@Override
	public void setTemp(setTempRequest request, StreamObserver<setTempResponse> responseObserver) {
		//Set Temperature request
		System.out.println("Receiving set Temperature request");
		String area = request.getAreaCode(); //get area code
		double temp = request.getTemperature(); //get required temperature
		System.out.println("Requested temperature " + temp + " in area code: " + area);
		
		//Set Temperature response
		String msg = "Area code " + area + " set to temperature " + temp;
		setTempResponse reply = setTempResponse.newBuilder().setMsgResponse(msg).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	
	//get Temperature Method gRPC
	@Override
	public void getTemp(getTempRequest request, StreamObserver<getTempResponse> responseObserver) {
		//Get Temperature request
		System.out.println("Receiving get Temperature request");
		String area = request.getAreaCode(); //get area code
		System.out.println("Requested area code: " + area);
		
		//Generate a random temperature between 15 and 30 to one decimal place
        Random rand = new Random();
        double randomValue = 15 + (rand.nextDouble() * (30 - 15));
        double returnTemp = Math.round(randomValue * 10) / 10.0;
		
        //Get Temperature response
		getTempResponse reply = getTempResponse.newBuilder().setTemperature(returnTemp).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}