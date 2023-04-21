package ds.smartbuilding.lighting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.smartbuilding.lighting.LightServiceGrpc.LightServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LightingServer extends LightServiceImplBase {
	//create logger
	private static final Logger logger = Logger.getLogger(LightingServer.class.getName());
	
	public static void main(String[] args) {
		LightingServer lightserver = new LightingServer();
		//set properties
		Properties prop = lightserver.getProperties();
		//RegisterService
		lightserver.registerService(prop);
		//get port
		int port = Integer.valueOf(prop.getProperty("service_port"));
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(lightserver)
					.build()
					.start();
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
	
	//get properties from lighting.properties file
	private Properties getProperties() {
		Properties prop = null;
		try (InputStream input = new FileInputStream("src/main/resources/lighting.properties")){
            
			prop = new Properties();

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            System.out.println("Lighting Service properies ...");
            System.out.println("\t service_type: " + prop.getProperty("service_type"));
            System.out.println("\t service_name: " +prop.getProperty("service_name"));
            System.out.println("\t service_description: " +prop.getProperty("service_description"));
	        System.out.println("\t service_port: " +prop.getProperty("service_port"));
		}
		catch (IOException ex) {
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
		}
		catch (IOException e) {
            System.out.println(e.getMessage());
        } 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Turn lights on Method gRPC
	@Override
	public void lightOn(lightOnRequest request, StreamObserver<lightResponse> responseObserver) {
		//Light On request
		System.out.println("Receiving Light On request");
		String area = request.getAreaCode(); //get area code
		System.out.println("Requested Light On in area code: " + area);
		
		//Light On response
		String msg = "Light turned on in area: " + area;
		lightResponse reply = lightResponse.newBuilder().setMsgResponse(msg).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	
	//Turn lights on Method gRPC
	@Override
	public void lightOff(lightOffRequest request, StreamObserver<lightResponse> responseObserver) {
		//Light Off request
		System.out.println("Receiving Light Off request");
		String area = request.getAreaCode(); //get area code
		System.out.println("Requested Light Off in area code: " + area);
		
		//Light Off response
		String msg = "Light turned Off in area: " + area;
		lightResponse reply = lightResponse.newBuilder().setMsgResponse(msg).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}