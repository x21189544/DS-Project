package ds.smartbuilding.allocate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import ds.smartbuilding.allocate.AllocateServiceGrpc.AllocateServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AllocateServer extends AllocateServiceImplBase {
	private static final Logger logger = Logger.getLogger(AllocateServer.class.getName());
	
	public static void main(String[] args) {
		AllocateServer allocateserver = new AllocateServer();
		int port = 50058;
		
		try {
			Server server = ServerBuilder.forPort(port).addService(allocateserver).build().start();
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
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				System.out.println("Reciveing Complete");
				
				String meetingRoom = "";
				int length = list.size();
				if(length < 5) {
					meetingRoom = "Please use meeting room A";
				}
				else if(length > 5 & length < 50) {
					meetingRoom = "Please use meeting room B";
				}
				else{
					meetingRoom = "Please use other building";
				}
				
				meetingRoomResponse reply = meetingRoomResponse.newBuilder().setMeetingRoom(meetingRoom).build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}
			

			
		};
		
	}

}