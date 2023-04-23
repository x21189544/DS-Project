package ds.smartbuilding.access;

import static io.grpc.Metadata.ASCII_STRING_MARSHALLER;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ClientCall.Listener;
import io.grpc.stub.StreamObserver;

public class AccessClient {
	//create logger
	private static final Logger logger = Logger.getLogger(AccessClient.class.getName());
	
	//create stubs
	public static AccessServiceGrpc.AccessServiceBlockingStub blockingStub;
	public static AccessServiceGrpc.AccessServiceStub asyncStub;
	
	//variables
	private ServiceInfo accessServiveInfo;
	
	//JFrame components
	private JFrame frame;
	private static JTextArea textResponse;
	static JTextArea textArea = new JTextArea();
	
	//Launch application
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccessClient window = new AccessClient();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
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
				.intercept(new AccessInterceptor())
				.build();
		
		//stubs
		blockingStub = AccessServiceGrpc.newBlockingStub(channel);
		asyncStub = AccessServiceGrpc.newStub(channel);
		
		initialize();
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
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//MetaData
	static class AccessInterceptor implements ClientInterceptor{
		@Override
		public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
				CallOptions callOptions, Channel next) {
			return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
		         @Override
		         public void start(Listener<RespT>responseListener, Metadata headers) {
		            headers.put(Metadata.Key.of("METADATA", ASCII_STRING_MARSHALLER), " my access metadata ");
		            logger.info("Added metadata" + headers);
		            super.start(responseListener, headers);   
		         }
			};
		}
	}
	
	//Initialize JFrame
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("GUI Client for Access Controller");
		frame.setBounds(100, 100, 400, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		//JPanel for occupant report 
		JPanel panel_report = new JPanel();
		frame.getContentPane().add(panel_report);
		panel_report.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		panel_report.setBackground(Color.magenta);
		
		//JPanel3 for occupant checklist title
		JPanel panel_checklist = new JPanel();
		frame.getContentPane().add(panel_checklist);
		panel_checklist.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		panel_checklist.setBackground(Color.pink);

		
		//buttons
		JButton btnOccupantReport = new JButton("Generate Occupant Report");
		btnOccupantReport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				occupantReport();
			}
			
		});
		panel_report.add(btnOccupantReport);
		
		JButton btnChecklist = new JButton("Check if Person is in building");
		btnChecklist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				occupantCheckList();
			}
			
		});
		//JTextArea for response
		panel_checklist.add(btnChecklist);
		textResponse = new JTextArea(3,20);
		panel_checklist.add(textResponse);
	}
	
	public static void occupantReport() {
		System.out.println("Occupant Report Button pressed");
		occupantReportRequest request = occupantReportRequest.newBuilder().setRequestReport("Yes").build();
		
		StreamObserver<occupantReportResponse> responseObserver = new StreamObserver<occupantReportResponse>() {
			
			@Override
			public void onNext(occupantReportResponse value) {
				System.out.println("Output " + value.getReportResponse());
		        textArea.append(value.getReportResponse());
		        textArea.append("\n");
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream is completed ");
				JOptionPane.showMessageDialog(null, textArea);		
				textArea.setText("");
			}
			
		};
		
		CallOptions.Key<String> metaDataKey = CallOptions.Key.create("my_key");
		asyncStub.withOption(metaDataKey, "bar").withDeadlineAfter(3, TimeUnit.MINUTES).occupantReport(request, responseObserver);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void occupantCheckList() {

		StreamObserver<occupantCheckListResponse> responseObserver = new StreamObserver<occupantCheckListResponse>() {
			
			@Override
			public void onNext(occupantCheckListResponse value) {
				System.out.println("Recieved value " + value.getChecklistResponse());
				textArea.append(value.getChecklistResponse());
			    textArea.append("\n");
				textResponse.setText(value.getChecklistResponse());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("stream completeed");
				textArea.setText("");
			}
			
		};
		
		CallOptions.Key<String> metaDataKey = CallOptions.Key.create("my_key");
		StreamObserver<occupantCheckListRequest> requestObserver = asyncStub.withOption(metaDataKey, "bar").withDeadlineAfter(3, TimeUnit.MINUTES).occupantCheckList(responseObserver);
		try {
			System.out.println("sending stream");
			String input = JOptionPane.showInputDialog("Enter Name:");
			while (input != null && !input.isEmpty()) {
				requestObserver.onNext(occupantCheckListRequest.newBuilder().setListOfNames(input).build());
				input = JOptionPane.showInputDialog("Enter Name or click OK to finish");
			}
			// Mark the end of requests
			requestObserver.onCompleted();
			
			// Sleep for a bit before sending the next one.
			Thread.sleep(50);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
	}
}