package ds.smartbuilding.allocate;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class AllocateClient{
	
	public static AllocateServiceGrpc.AllocateServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception{
		//define host and port variables
		String host = "localhost";
		int port = 50058;
		
		//build channel
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//stubs
		asyncStub = AllocateServiceGrpc.newStub(channel);
		
		AllocateClient client = new AllocateClient();
		
		//call function
		allocateRoom();
		
		//shutdown channel
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
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