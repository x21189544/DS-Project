package ds.smartbuilding.access;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import ds.smartbuilding.access.AccessServiceGrpc.AccessServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AccessServer extends AccessServiceImplBase{
	//create logger
	private static final Logger logger = Logger.getLogger(AccessServer.class.getName());
	
	public static void main(String[] args) {
		AccessServer accessServer = new AccessServer();
		//set properties
		Properties prop = accessServer.getProperties();
		//RegisterService
		accessServer.registerService(prop);
		//get port
		int port = Integer.valueOf(prop.getProperty("service_port"));
		//build server
		try {
			Server server = ServerBuilder.forPort(port)
					.addService(accessServer)
					.build()
					.start();
			logger.info("Server started, listening on " + port);
			server.awaitTermination();
		}
		//Catch IOException
		catch (IOException e) {
			e.printStackTrace();
		}
		//Catch InterruptedException
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//get properties from access.properties file
	private Properties getProperties() {
		Properties prop = null;
		try (InputStream input = new FileInputStream("src/main/resources/access.properties")){
            
			prop = new Properties();

            // load a properties file
            prop.load(input);
            // get the property value and print it out
            System.out.println("Access Service properies ...");
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
			Thread.sleep(100);
		}
		catch (IOException e) {
            System.out.println(e.getMessage());
        } 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//occupant report method
	@Override
	public void occupantReport(occupantReportRequest request, StreamObserver<occupantReportResponse> responseObserver) {
		System.out.println("receiving occupant report request");
		//Choose random 5 names from 10 to stream to client
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			int randomNumber = random.nextInt(10) + 1;
			   String response = "";
			    if (randomNumber == 1) {
			      response = "David Scallan-Walsh";
			    } else if (randomNumber == 2) {
			      response = "Joe Bloggs";
			    } else if (randomNumber == 3) {
			      response = "Jane Doe";
			    } else if (randomNumber == 4) {
			      response = "John Doe";
			    } else if (randomNumber == 5) {
			      response = "Mary Murphy";
			    } else if (randomNumber == 6) {
			      response = "Patrick Smith";
			    } else if (randomNumber == 7) {
			      response = "Kevin Clark";
			    } else if (randomNumber == 8) {
			      response = "Alice Jones";
			    } else if (randomNumber == 9) {
			      response = "Angela Turner";
			    } else if (randomNumber == 10) {
			      response = "Margaret Jones";
			    }
			System.out.println("Starting response " + response);
			occupantReportResponse reply = occupantReportResponse.newBuilder().setReportResponse(response).build();
			responseObserver.onNext(reply);
			}
		
		responseObserver.onCompleted();
	}
	
	
	public StreamObserver<occupantCheckListRequest> occupantCheckList(StreamObserver<occupantCheckListResponse> responseObserver) {
		
		return new StreamObserver<occupantCheckListRequest>() {
						
			@Override
			public void onNext(occupantCheckListRequest value) {
				//Choose random random response of " is in the building" or " is NOT in the building" to stream to client
				String[] items = {" is in the building", " is NOT in the building"};
				Random rand = new Random();
				int index = rand.nextInt(items.length);
				System.out.println("receiving values: " + value.getListOfNames() + items[index]);
				String returnedChecklist = (value.getListOfNames() + items[index]);
				occupantCheckListResponse reply = occupantCheckListResponse.newBuilder().setChecklistResponse(returnedChecklist).build();
				responseObserver.onNext(reply);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("reciveing complete");
				responseObserver.onCompleted();
			}
		};
	}
		
}