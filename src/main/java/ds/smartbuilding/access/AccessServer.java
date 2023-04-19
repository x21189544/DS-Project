package ds.smartbuilding.access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

import ds.smartbuilding.access.AccessServiceGrpc.AccessServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class AccessServer extends AccessServiceImplBase{
	
	private static final Logger logger = Logger.getLogger(AccessServer.class.getName());
	
	public static void main(String[] args) {
		AccessServer accessServer = new AccessServer();
		int port = 50057;
		try {
			Server server = ServerBuilder.forPort(port).addService(accessServer).build().start();
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
	
	@Override
	public void occupantReport(occupantReportRequest request, StreamObserver<occupantReportResponse> responseObserver) {
		System.out.println("receiving occupant report request");
		String getReport = request.getRequestReport();
		
		String msg = "asdf, adfasdf,a dfasd,adf a,df a,sd,asdf,asd";
		occupantReportResponse reply = occupantReportResponse.newBuilder().setReportResponse(msg).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	
	
	public StreamObserver<occupantCheckListRequest> occupantCheckList(StreamObserver<occupantCheckListResponse> responseObserver) {
		
		return new StreamObserver<occupantCheckListRequest>() {
						
			@Override
			public void onNext(occupantCheckListRequest value) {
				System.out.println("receiving values: " + value.getListOfNames() + " is " + "in building");
				String returnedChecklist = value.getListOfNames() + " is " + "in building";
				occupantCheckListResponse reply = occupantCheckListResponse.newBuilder().setChecklistResponse(returnedChecklist ).build();
				responseObserver.onNext(reply);
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				System.out.println("reciveing complete");
				responseObserver.onCompleted();
			}
			
		};
			
	}
		

		
		
		
	
}