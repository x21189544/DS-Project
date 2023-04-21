package ds.smartbuilding.allocate;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.JOptionPane;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class AllocateClient{
	//create logger
	private static final Logger logger = Logger.getLogger(AllocateClient.class.getCanonicalName());
	
	//create stub
	public static AllocateServiceGrpc.AllocateServiceStub asyncStub;
	
	//variables
	private ServiceInfo allocateServiceInfo;
	
	//Launch application
	public static void main(String[] args) throws Exception{
		
		AllocateClient client = new AllocateClient();
		
		//call function
		allocateRoom();
		
		//shutdown channel
		//channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public AllocateClient() {
		String allocate_service_type = "_allocate._tcp.local.";
		discoverAccessService(allocate_service_type);
		//get host and port variables
		String host = allocateServiceInfo.getHostAddresses()[0];
		int port = allocateServiceInfo.getPort();
		
		//build channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//stubs
		asyncStub = AllocateServiceGrpc.newStub(channel);
	}
	
	//discover jmdns
	private void discoverAccessService(String allocate_service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdnsAllocate = JmDNS.create(InetAddress.getLocalHost());
			jmdnsAllocate.addServiceListener(allocate_service_type, new ServiceListener() {

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Allocate Service added: " + event.getInfo());
					
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Allocate Service removed: " + event.getInfo());
					
				}

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Temperature Service resolved: " + event.getInfo());
					allocateServiceInfo = event.getInfo();
					int port = allocateServiceInfo.getPort();
					System.out.println("resolving " + allocate_service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + allocateServiceInfo.getNiceTextString());
					System.out.println("\t host: " + allocateServiceInfo.getHostAddresses()[0]);
				}
				
			});
			
			// Wait a bit
			Thread.sleep(2000);
			
			//jmdnsAllocate.close();
		}
		catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void allocateRoom() {
		StreamObserver<meetingRoomResponse> responseObserver = new StreamObserver<meetingRoomResponse>() {

			@Override
			public void onNext(meetingRoomResponse value) {
				System.out.println("Receiving name: " + value.getMeetingRoom());
				JOptionPane.showMessageDialog(null, value.getMeetingRoom());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				System.out.println("Stream is completed");
				
			}
			
		};
		
		StreamObserver<listofAttendeesRequest> requestObserver = asyncStub.allocateRoom(responseObserver);
		
		try {
			requestObserver.onNext(listofAttendeesRequest.newBuilder().setListOfAttendees("David").build());
			Thread.sleep(500);
			
			requestObserver.onNext(listofAttendeesRequest.newBuilder().setListOfAttendees("Divyaa").build());
			Thread.sleep(500);
			
			requestObserver.onNext(listofAttendeesRequest.newBuilder().setListOfAttendees("Joe").build());
			Thread.sleep(500);
			
			requestObserver.onNext(listofAttendeesRequest.newBuilder().setListOfAttendees("Jane").build());
			Thread.sleep(500);
			
			// Mark the end of requests
			requestObserver.onCompleted();


			// Sleep for a bit before sending the next one.
			Thread.sleep(new Random().nextInt(1000) + 500);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}