package ds.smartbuilding.lighting;

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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import io.grpc.StatusRuntimeException;
import io.grpc.ClientCall.Listener;

public class LightingGUI {
	//create logger
	private static final Logger logger = Logger.getLogger(LightingGUI.class.getName());
	
	//create blockingStub
	public static LightServiceGrpc.LightServiceBlockingStub blockingStub;
	
	//variables
	private ServiceInfo lightingServiceInfo;
	
	//JFrame components
	private JFrame frame;
	private JTextArea textResponse;
	
	//Launch application
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LightingGUI window = new LightingGUI();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	//create application
	public LightingGUI() throws Exception {
		String light_service_type = "_light._tcp.local.";
		discoverLightingService(light_service_type);
		//get host and port variables
		String host = lightingServiceInfo.getHostAddresses()[0];
		int port = lightingServiceInfo.getPort();
		//build channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.intercept(new LightingInterceptor())
				.build();
		
		//stubs
		blockingStub = LightServiceGrpc.newBlockingStub(channel);
		
		//call method
		initialize();
		
	}
	
	//discover jmdns
	private void discoverLightingService(String Lservice_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdnsL = JmDNS.create(InetAddress.getLocalHost());
			jmdnsL.addServiceListener(Lservice_type, new ServiceListener() {

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Lighting Service added: " + event.getInfo());
					
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Lighting Service removed: " + event.getInfo());
					
				}

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Lighting Service resolved: " + event.getInfo());
					lightingServiceInfo = event.getInfo();
					System.out.println("info + " + event.getInfo());
					int port = lightingServiceInfo.getPort();
					System.out.println("resolving " + Lservice_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + lightingServiceInfo.getNiceTextString());
					System.out.println("\t host: " + lightingServiceInfo.getHostAddresses()[0]);
					
				}
				
			});
			// Wait 
			Thread.sleep(2000);
			
			jmdnsL.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//MetaData
	static class LightingInterceptor implements ClientInterceptor{
		@Override
		public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
				CallOptions callOptions, Channel next) {
			return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
		         @Override
		         public void start(Listener<RespT>responseListener, Metadata headers) {
		            headers.put(Metadata.Key.of("METADATA", ASCII_STRING_MARSHALLER), " my lighting metadata ");
		            logger.info("Added metadata" + headers);
		            super.start(responseListener, headers);   
		         }
			};
		}
	}
	
	//Initialize JFrame
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("GUI Client for Lighting Controller");
		frame.setBounds(100, 100, 400, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		//JPanel1 for title
		JPanel panel_title = new JPanel();
		frame.getContentPane().add(panel_title);
		panel_title.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel_title.setBackground(Color.green);
		JLabel label_title = new JLabel("Turn Lights On/Off");
		panel_title.add(label_title);
		
		//JPanel2 for drop down area code selection
		JPanel panel_selectArea = new JPanel();
		frame.getContentPane().add(panel_selectArea);
		panel_selectArea.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		panel_selectArea.setBackground(Color.green);
		JLabel label_selectArea = new JLabel("Choose Area Code");
		panel_selectArea.add(label_selectArea);
		//Jcombobox for drop down of Area Codes
		JComboBox comboSelectArea = new JComboBox();
		comboSelectArea.setModel(new DefaultComboBoxModel(new String[] {"Floor 1", "Floor 2", "Floor 3", "Meeting Room A", "Meeting Room B", "Meeting Room C"}));
		panel_selectArea.add(comboSelectArea);
		
		//JPanel3 for Buttons
		JPanel panel_buttons = new JPanel();
		frame.getContentPane().add(panel_buttons);
		panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
		panel_buttons.setBackground(Color.green);
		//buttons
		JButton btnTurnOn = new JButton("Turn Lights On");
		JButton btnTurnOff = new JButton("Turn Lights Off");
		//button actions
		//button turn on
		btnTurnOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Turn On Button Pressed");
				try {
					System.out.println(comboSelectArea.getSelectedItem()); //set selected item from drop down combo box
					String areaCode = (String) comboSelectArea.getSelectedItem(); //convert drop down item selection to string to pass to grpc
					//send turn on request
					lightOnRequest request = lightOnRequest.newBuilder().setAreaCode(areaCode).build();
				
					//get turn on response, deadline, metadata
					CallOptions.Key<String> metaDataKey = CallOptions.Key.create("my_key");
					lightResponse response = blockingStub.withOption(metaDataKey, "bar").withDeadlineAfter(1000, TimeUnit.MILLISECONDS).lightOn(request);
					System.out.println("Lights in area "+ areaCode + " turned on.");
					textResponse.setText(response.getMsgResponse()); //set textResponseSet as the message response
				}
				//catch runtime exception
				catch (StatusRuntimeException e1) {
					logger.log(Level.WARNING, "RPC failed: ", e1.getStatus());
				}
			}
			
		});
		
		//button turn off
		btnTurnOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Turn On Button Pressed");
				try {
					System.out.println(comboSelectArea.getSelectedItem()); //set selected item from drop down combo box
					String areaCode = (String) comboSelectArea.getSelectedItem(); //convert drop down item selection to string to pass to grpc
					//send turn off request
					lightOffRequest request = lightOffRequest.newBuilder().setAreaCode(areaCode).build();
					
					//get turn off response, deadline, metadata
					CallOptions.Key<String> metaDataKey = CallOptions.Key.create("my_key");
					lightResponse response = blockingStub.withOption(metaDataKey, "bar").withDeadlineAfter(1000, TimeUnit.MILLISECONDS).lightOff(request);
					System.out.println("Lights in area "+ areaCode + " turned off."); //print output response
					textResponse.setText(response.getMsgResponse()); //set textResponseSet as the message response
				}
				//catch runtime exception
				catch (StatusRuntimeException e1) {
				    logger.log(Level.WARNING, "RPC failed: {0}", e1.getStatus());
				    
				    return;		   
			    }
				
			}
			
		});
		
		panel_buttons.add(btnTurnOn);
		panel_buttons.add(btnTurnOff);
		
		//JPanel4 for output box
		JPanel panel_textBox = new JPanel();
		frame.getContentPane().add(panel_textBox);
		panel_textBox.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 0));
		panel_textBox.setBackground(Color.green);
		textResponse = new JTextArea(2,25);
		textResponse.setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		panel_textBox.add(textResponse);
	}
	
}