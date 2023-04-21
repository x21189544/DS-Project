package ds.smartbuilding.access;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import ds.smartbuilding.temperature.TemperatureGUI;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class AccessClient {
	//create logger
	private static final Logger logger = Logger.getLogger(AccessClient.class.getName());
	
	//create stubs
	public static AccessServiceGrpc.AccessServiceBlockingStub blockingStub;
	public static AccessServiceGrpc.AccessServiceStub asyncStub;
	
	//variables
	private ServiceInfo accessServiveInfo;
	
	//Launch application
	public static void main(String[] args){
		AccessClient client = new AccessClient();

		
		//occupantReport();
		//occupantCheckList();
		
		//shutdown channel
		//channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	//create application
	public AccessClient() {
		String access_service_type = "_access._tcp.local.";
		discoverAccessService(access_service_type);
		//get host and port variables
		String host = accessServiveInfo.getHostAddresses()[0];
		int port = accessServiveInfo.getPort();
		
		//build channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs
		blockingStub = AccessServiceGrpc.newBlockingStub(channel);
		asyncStub = AccessServiceGrpc.newStub(channel);
		
	}
	
	//discover jmdns
	private void discoverAccessService(String access_service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdnsAccess = JmDNS.create(InetAddress.getLocalHost());
			jmdnsAccess.addServiceListener(access_service_type, new ServiceListener() {

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Access Service added: " + event.getInfo());
					
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Access Service removed: " + event.getInfo());
					
				}

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Access Service resolved: " + event.getInfo());
					accessServiveInfo = event.getInfo();
					int port = accessServiveInfo.getPort();
					System.out.println("resolving " + access_service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + accessServiveInfo.getNiceTextString());
					System.out.println("\t host: " + accessServiveInfo.getHostAddresses()[0]);
				}
				
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			jmdnsAccess.close();
		}
		catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public static void occupantReport() {
		System.out.println("Starting Report");
		try {
			System.out.println("Starting try");
			String requested = "Yes";
			System.out.println("yes send");
			occupantReportRequest request = occupantReportRequest.newBuilder().setRequestReport(requested).build();
			
			System.out.println("Starting output");
			java.util.Iterator<occupantReportResponse> response = blockingStub.occupantReport(request);
		}
		catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;	
		}
	}
	
	public static void occupantCheckList() {
		StreamObserver<occupantCheckListResponse> responseObserver = new StreamObserver<occupantCheckListResponse>() {
			
			
			@Override
			public void onNext(occupantCheckListResponse value) {
				System.out.println("Recieved value " + value.getChecklistResponse());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				System.out.println("stream completeed");
				
			}
			
		};
		
		StreamObserver<occupantCheckListRequest> requestObserver = asyncStub.occupantCheckList(responseObserver);
		try {
			requestObserver.onNext(occupantCheckListRequest.newBuilder().setListOfNames("David").build());
			requestObserver.onNext(occupantCheckListRequest.newBuilder().setListOfNames("Divyaa").build());
			requestObserver.onNext(occupantCheckListRequest.newBuilder().setListOfNames("Joe").build());
			requestObserver.onNext(occupantCheckListRequest.newBuilder().setListOfNames("Jane").build());
			
			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);


		}
		catch (RuntimeException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
	}
}