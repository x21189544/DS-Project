package ds.smartbuilding.access;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.html.HTMLDocument.Iterator;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class AccessClient {
	private static final Logger logger = Logger.getLogger(AccessClient.class.getName());
	
	public static AccessServiceGrpc.AccessServiceBlockingStub blockingStub;
	public static AccessServiceGrpc.AccessServiceStub asyncStub;
	
	public static void main(String[] args) throws Exception{
		//define host and port variables
		String host = "localhost";
		int port = 50057;
		
		//build channel
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//stubs
		blockingStub = AccessServiceGrpc.newBlockingStub(channel);
		asyncStub = AccessServiceGrpc.newStub(channel);
		
		AccessClient client = new AccessClient();
		occupantReport();
		//occupantCheckList();
		
		//shutdown channel
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
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
		
		try {
			Thread.sleep(15000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}