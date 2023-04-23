package ds.smartbuilding.allocate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
	
	//JFrame components
	private JFrame frame;
	private static JTextArea textResponse;
	
	//Launch application
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllocateClient window = new AllocateClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
				
	}
	
	//create application
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
		
		//call method
		initialize();
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
					System.out.println("Allocate Service resolved: " + event.getInfo());
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
			
			jmdnsAllocate.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//Initialize JFrame
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("GUI Client for Allocate Controller");
		frame.setBounds(100, 100, 250, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		//JPanel for occupant report 
		JPanel panel_allocate = new JPanel();
		frame.getContentPane().add(panel_allocate);
		panel_allocate.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
		panel_allocate.setBackground(Color.orange);
		
		//buttons
		JButton btnAllocate = new JButton("Start Allocate Meeting Room");
		btnAllocate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				allocateRoom();
			}
			
		});
		panel_allocate.add(btnAllocate);
		textResponse = new JTextArea(3,20);
		panel_allocate.add(textResponse);
	}
	
	public static void allocateRoom() {
		StreamObserver<meetingRoomResponse> responseObserver = new StreamObserver<meetingRoomResponse>() {

			@Override
			public void onNext(meetingRoomResponse value) {
				System.out.println("Receiving name: " + value.getMeetingRoom());
				textResponse.setText(value.getMeetingRoom());
				JOptionPane.showMessageDialog(null, value.getMeetingRoom());
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}

			@Override
			public void onCompleted() {
				System.out.println("Stream is completed");
			}
			
		};
		
		StreamObserver<listofAttendeesRequest> requestObserver = asyncStub.allocateRoom(responseObserver);
		
		try {
			String input = JOptionPane.showInputDialog("Enter First Name:");

			while (input != null && !input.isEmpty()) {
				requestObserver.onNext(listofAttendeesRequest.newBuilder().setListOfAttendees(input).build());
			    input = JOptionPane.showInputDialog("Enter next name or leave blank and click ok to finish");
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
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}