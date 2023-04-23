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
import io.grpc.Context;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.ServerCall.Listener;
import io.grpc.stub.StreamObserver;

public class LightingServer extends LightServiceImplBase {
	//create logger
	private static final Logger logger = Logger.getLogger(LightingServer.class.getName());
	
	public static void main(String[] args) {
		LightingServer lightserver = new LightingServer();
		
		//metadata
		class LightingServerInterceptor implements ServerInterceptor{
			
			@Override
			public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
					ServerCallHandler<ReqT, RespT> next) {
				logger.info("Recieved following metadata: " + headers);
				return next.startCall(call, headers);
			}
		}
		//set properties
		Properties prop = lightserver.getProperties();
		//RegisterService
		lightserver.registerService(prop);
		//get port
		int port = Integer.valueOf(prop.getProperty("service_port"));
		
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(lightserver)
					.intercept(new LightingServerInterceptor())
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
			JmDNS jmdnsLight = JmDNS.create(InetAddress.getLocalHost());
			
			String light_service_type = prop.getProperty("service_type");
			String light_service_name = prop.getProperty("service_name");
			int light_service_port = Integer.valueOf(prop.getProperty("service_port"));
			String light_service_description_properties = prop.getProperty("service_description");
			
			//Register a service
			ServiceInfo lightServiceInfo = ServiceInfo.create(light_service_type, light_service_name, light_service_port, light_service_description_properties);
			jmdnsLight.registerService(lightServiceInfo);
			System.out.printf("registrering service with type %s and name %s \n", light_service_type, light_service_name);
			System.out.println(lightServiceInfo);
			//Wait
			Thread.sleep(1000);
		} catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
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
		if (Context.current().isCancelled()) {
			responseObserver.onError(Status.CANCELLED.withDescription("Cancelled by client").asRuntimeException());
			 return;
		}
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
		if (Context.current().isCancelled()) {
			responseObserver.onError(Status.CANCELLED.withDescription("Cancelled by client").asRuntimeException());
			 return;
		}
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}