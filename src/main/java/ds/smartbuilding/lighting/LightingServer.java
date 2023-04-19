package ds.smartbuilding.lighting;

import java.io.IOException;
import java.util.logging.Logger;

import ds.smartbuilding.lighting.LightServiceGrpc.LightServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LightingServer extends LightServiceImplBase {
	private static final Logger logger = Logger.getLogger(LightingServer.class.getName());
	
	public static void main(String[] args) {
		LightingServer lightserver = new LightingServer();
		int port = 50056;
		
		try {
			Server server = ServerBuilder.forPort(port).addService(lightserver).build().start();
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
	public void lightOn(lightOnRequest request, StreamObserver<lightResponse> responseObserver) {
		System.out.println("Receiving Light On request");
		String area = request.getAreaCode();
		System.out.println("Requested Light On in area code: " + area);
		
		String msg = "Light turned on in area: " + area;
		lightResponse reply = lightResponse.newBuilder().setMsgResponse(msg).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
	
	@Override
	public void lightOff(lightOffRequest request, StreamObserver<lightResponse> responseObserver) {
		System.out.println("Receiving Light Off request");
		String area = request.getAreaCode();
		System.out.println("Requested Light Off in area code: " + area);
		
		String msg = "Light turned Off in area: " + area;
		lightResponse reply = lightResponse.newBuilder().setMsgResponse(msg).build();
		responseObserver.onNext(reply);
		responseObserver.onCompleted();
	}
}