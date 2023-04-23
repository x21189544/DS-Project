package ds.smartbuilding.allocate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.smartbuilding.allocate.AllocateServiceGrpc.AllocateServiceImplBase;
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

public class AllocateServer extends AllocateServiceImplBase {
	//create logger
	private static final Logger logger = Logger.getLogger(AllocateServer.class.getName());
	
	public static void main(String[] args) {
		AllocateServer allocateserver = new AllocateServer();
		
		//metadata
		class AllocateServerInterceptor implements ServerInterceptor{
			
			@Override
			public <ReqT, RespT> Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
					ServerCallHandler<ReqT, RespT> next) {
				logger.info("Recieved following metadata: " + headers);
				return next.startCall(call, headers);
			}
		}
		//set properties
		Properties prop = allocateserver.getProperties();
		//RegisterService
		allocateserver.registerService(prop);
		//get port
		int port = Integer.valueOf(prop.getProperty("service_port"));
		//build server
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(allocateserver)
					.intercept(new AllocateServerInterceptor())
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
	
	//get properties from allocate.properties file
	private Properties getProperties() {
		Properties prop = null;
		try (InputStream input = new FileInputStream("src/main/resources/allocate.properties")){
            
			prop = new Properties();

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            System.out.println("Allocate Service properies ...");
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
	
	
	//allocate room method
	public StreamObserver<listofAttendeesRequest> allocateRoom(StreamObserver<meetingRoomResponse> responseObserver){
		
		return new StreamObserver<listofAttendeesRequest>() {

			ArrayList<String> list = new ArrayList();
			
			
			@Override
			public void onNext(listofAttendeesRequest value) {
				System.out.println(value.getListOfAttendees());
				list.add(value.getListOfAttendees());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();				
			}

			@Override
			public void onCompleted() {
				System.out.println("Reciveing Complete");
				
				String meetingRoom = "";
				int length = list.size();
				if(length <= 5) {
					meetingRoom = "Please use meeting room A";
				}
				else if(length > 5 & length < 50) {
					meetingRoom = "Please use meeting room B";
				}
				else{
					meetingRoom = "Please use other building";
				}
				
				meetingRoomResponse reply = meetingRoomResponse.newBuilder().setMeetingRoom(meetingRoom).build();
				if (Context.current().isCancelled()) {
					responseObserver.onError(Status.CANCELLED.withDescription("Cancelled by client").asRuntimeException());
					 return;
				}
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
			
		};
		
	}

}