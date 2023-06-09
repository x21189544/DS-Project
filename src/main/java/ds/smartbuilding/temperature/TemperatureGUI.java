package ds.smartbuilding.temperature;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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

public class TemperatureGUI {
	//create logger
	private static final Logger logger = Logger.getLogger(TemperatureGUI.class.getName());
	
	//create blockingStub
	public static TemperatureServiceGrpc.TemperatureServiceBlockingStub blockingStub;
	
	//variables
	private ServiceInfo tempServiceInfo;
	
	//JFrame components
	private JFrame frame;
	private JTextField tempInputSet;
	private JTextArea textResponseSet;
	private JTextArea textResponseGet;
	
	//Launch application
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperatureGUI window = new TemperatureGUI();
					window.frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//create application
	public TemperatureGUI() throws InterruptedException {
		String temp_service_type = "_temperature._tcp.local.";
		discoverTempService(temp_service_type);
		//get host and port variables
		String host = tempServiceInfo.getHostAddresses()[0];
		int port = tempServiceInfo.getPort();
		
		//build channel
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.intercept(new TemperatureInterceptor())
				.build();
		
		//stubs
		blockingStub = TemperatureServiceGrpc.newBlockingStub(channel);
		
		//call method
		 initialize();
		
	}
	
	//discover jmdns
	private void discoverTempService(String service_type) {
		try {
			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			jmdns.addServiceListener(service_type, new ServiceListener() {

				@Override
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Temperature Service added: " + event.getInfo());
				}

				@Override
				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Temperature Service removed: " + event.getInfo());
				}

				@Override
				public void serviceResolved(ServiceEvent event) {
					System.out.println("Temperature Service resolved: " + event.getInfo());
					tempServiceInfo = event.getInfo();
					int port = tempServiceInfo.getPort();
					System.out.println("resolving " + service_type + " with properties ...");
					System.out.println("\t port: " + port);
					System.out.println("\t type:"+ event.getType());
					System.out.println("\t name: " + event.getName());
					System.out.println("\t description/properties: " + tempServiceInfo.getNiceTextString());
					System.out.println("\t host: " + tempServiceInfo.getHostAddresses()[0]);
				}
				
			});
			// Wait
			Thread.sleep(2000);
			
			jmdns.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	//MetaData
	static class TemperatureInterceptor implements ClientInterceptor{
		@Override
		public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> method,
				CallOptions callOptions, Channel next) {
			return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
		         @Override
		         public void start(Listener<RespT>responseListener, Metadata headers) {
		            headers.put(Metadata.Key.of("METADATA", ASCII_STRING_MARSHALLER), " my temperature metadata ");
		            logger.info("Added metadata" + headers);
		            super.start(responseListener, headers);   
		         }
			};
		}
	}
	
	//Initialize JFrame
	public void initialize() {
		frame = new JFrame();
		frame.setTitle("GUI Client for Temperature Controller");
		frame.setBounds(100, 100, 700, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		//SET TEMPERATURE
		//JPanel1 for set temperature
		JPanel panel_setTemp1 = new JPanel();
		frame.getContentPane().add(panel_setTemp1);
		panel_setTemp1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel_setTemp1.setBackground(Color.yellow);
		JLabel setTempLabel1 = new JLabel("Set Temperature");
		panel_setTemp1.add(setTempLabel1);
		
		//JPanel2 for set temperature
		JPanel panel_setTemp2 = new JPanel();
		frame.getContentPane().add(panel_setTemp2);
		panel_setTemp2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		panel_setTemp2.setBackground(Color.yellow);
		JLabel setTempLabel2 = new JLabel("Choose Area Code to set Temperature");
		panel_setTemp2.add(setTempLabel2);
		//JCombobox for drop down of Area Codes
		JComboBox comboAreaSet = new JComboBox();
		comboAreaSet.setModel(new DefaultComboBoxModel(new String[] {"Floor 1", "Floor 2", "Floor 3", "Meeting Room A", "Meeting Room B", "Meeting Room C"}));
		panel_setTemp2.add(comboAreaSet);
		//text box for input of temperature
		JLabel setTempLabel3 = new JLabel("Input Temperature");
		panel_setTemp2.add(setTempLabel3);
		tempInputSet = new JTextField();
		panel_setTemp2.add(tempInputSet);
		tempInputSet.setColumns(10);
		//text box for output
		textResponseSet = new JTextArea(3, 20);
		textResponseSet.setLineWrap(true);
		textResponseSet.setWrapStyleWord(true);
		textResponseSet.setEditable(false);
		JScrollPane scrollPaneSet = new JScrollPane(textResponseSet);
		panel_setTemp2.add(scrollPaneSet);
		//button to send request
		JButton btnSetTemp = new JButton("Set Temperature");
		//button action
		btnSetTemp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Set Button Pressed");
				try {
					System.out.println(comboAreaSet.getSelectedItem()); //set selected item from drop down combo box
					String areaCode = (String) comboAreaSet.getSelectedItem(); //convert drop down item selection to string to pass to grpc
					try
					{
						double temp = Double.parseDouble(tempInputSet.getText()); //parse input temperature from string to double
						if (temp >= 15 && temp <= 30) {
							//send set temperature request
							setTempRequest request = setTempRequest.newBuilder().setAreaCode(areaCode).setTemperature(temp).build();
							//get set temperature response, deadline, metadata
							CallOptions.Key<String> metaDataKey = CallOptions.Key.create("my_key");
							setTempResponse response = blockingStub.withOption(metaDataKey, "bar").withDeadlineAfter(2000, TimeUnit.MILLISECONDS).setTemp(request);
							System.out.println("output response is +"+response); //print output response
							textResponseSet.setText(response.getMsgResponse()); //set textResponseSet as the message response
						}
						else {
							JOptionPane.showMessageDialog(null, "Enter a value between 15.0 and 30.0");
						}
					}
					catch(NumberFormatException e1)
					{
						JOptionPane.showMessageDialog(null, "Enter a NUMBER value between 15.0 and 30.0");
					}
					
				}
				//catch runtime exception
				catch (StatusRuntimeException e1) {
					logger.log(Level.WARNING, "RPC failed: ", e1.getStatus());
				}
			}
		});
		panel_setTemp2.add(btnSetTemp);
		
		//GET TEMPERATURE
		//JPanel3 for get temperature
		JPanel panel_getTemp1 = new JPanel();
		frame.getContentPane().add(panel_getTemp1);
		panel_getTemp1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel_getTemp1.setBackground(Color.cyan);
		JLabel getTempLabel1 = new JLabel("Get Temperature");
		panel_getTemp1.add(getTempLabel1);
		
		//JPanel4 for get temperature
		JPanel panel_getTemp2 = new JPanel();
		frame.getContentPane().add(panel_getTemp2);
		panel_getTemp2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 25));
		panel_getTemp2.setBackground(Color.cyan);
		JLabel getTempLabel2 = new JLabel("Choose Area Code to get Temperature");
		panel_getTemp2.add(getTempLabel2);
		//JCombobox for dropdown of Area Codes
		JComboBox comboAreaGet = new JComboBox();
		comboAreaGet.setModel(new DefaultComboBoxModel(new String[] {"Floor 1", "Floor 2", "Floor 3", "Meeting Room A", "Meeting Room B", "Meeting Room C"}));
		panel_getTemp2.add(comboAreaGet);
		//text box for output
		textResponseGet = new JTextArea(3, 20);
		textResponseGet .setLineWrap(true);
		textResponseGet.setWrapStyleWord(true);
		textResponseGet.setEditable(false);
		JScrollPane scrollPaneGet = new JScrollPane(textResponseGet);
		panel_getTemp2.add(scrollPaneGet);
		//button to get request
		JButton btnGetTemp = new JButton("Get Temperature");
		//button action
		btnGetTemp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
				System.out.println("Processing request from " + clientId);
				System.out.println("Get Button Pressed");
				try {
					String areaCode = (String) comboAreaGet.getSelectedItem(); //get selected item from drop down combo box
					System.out.println("Area code selected: "+areaCode); 
					//send get temperature request
					getTempRequest request = getTempRequest.newBuilder().setAreaCode(areaCode).build();
					
					//get get temperature response, deadline, metadata
					CallOptions.Key<String> metaDataKey = CallOptions.Key.create("my_key");
					getTempResponse response = blockingStub.withOption(metaDataKey, "bar").withDeadlineAfter(2000, TimeUnit.MILLISECONDS).getTemp(request);
					System.out.println("Temp is: "+ response.getTemperature()); //print output response
					String output = response.toString();
					textResponseGet.setText(output); //set textResponseGet as the message response
				}
				catch (StatusRuntimeException e1) {
				    logger.log(Level.WARNING, "RPC failed: ", e1.getStatus());		   
			    }
			}
			
		});
		panel_getTemp2.add(btnGetTemp);
		
	}
	
}