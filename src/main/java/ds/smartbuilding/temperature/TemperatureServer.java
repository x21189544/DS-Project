package ds.smartbuilding.temperature;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.smartbuilding.temperature.TemperatureServiceGrpc.TemperatureServiceImplBase;
import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class TemperatureServer extends TemperatureServiceImplBase {
	//create logger
	private static final Logger logger = Logger.getLogger(TemperatureServer.class.getName());
	
	public static void main(String[] args){
		TemperatureServer tempserver = new TemperatureServer();
		//set properties
		Properties prop = tempserver.getProperties();
		//RegisterService
		tempserver.registerService(prop);
		int port = Integer.valueOf(prop.getProperty("service_port"));
		//build server
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(tempserver)
					.build()
					.start();
			logger.info("Server started, listening on " + port);
			server.awaitTermination();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//get properties from temperature.properties file
	private Properties getProperties() {
		Properties prop = null;
		try (InputStream input = new FileInputStream("src/main/resources/temperature.properties")){
            
			prop = new Properties();

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            System.out.println("Temperature Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));
		} catch (IOException ex) {
            ex.printStackTrace();
        }
		return prop;
	}
	
	//register service method
	private void registerService(Properties prop) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			String service_type = prop.getProperty("service_type");
			String service_name = prop.getProperty("service_name");
			int service_port = Integer.valueOf(prop.getProperty("service_port"));
			String service_description_properties = prop.getProperty("service_description");
			
			//Register a service
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
			jmdns.registerService(serviceInfo);
			System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
			
			//Wait
			Thread.sleep(1000);
		} catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
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
		if (Context.current().isCancelled()) {
			responseObserver.onError(Status.CANCELLED.withDescription("Cancelled by client").asRuntimeException());
			 return;
		}
		
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
        if (Context.current().isCancelled())  {
        	responseObserver.onError(Status.CANCELLED.withDescription("Cancelled by client").asRuntimeException());
		}
	
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
		
	}
	
}