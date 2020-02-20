import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import com.fazecast.jSerialComm.SerialPort;

public class SerialComm {

	private static String incomingMsg;
	private static HashMap<String, String> incomingData, outgoingData;
	private static Timer timer = new Timer("Arduino Serial Comm Timer", true);
	private static SerialPort comPort;
	
	public static void start() {
		comPort = SerialPort.getCommPorts()[0];
		comPort.openPort();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				
				String outgoingMsg = "";
				for (String curKey : outgoingData.keySet()) {
					outgoingMsg += curKey + "=" + outgoingData.get(curKey) + ",";
				}
				outgoingMsg = outgoingMsg.subSequence(0, outgoingMsg.length() - 1) + ";";
				comPort.writeBytes(outgoingMsg.getBytes(), outgoingMsg.length());
				
				if (comPort.bytesAvailable() > 0) {
					byte[] readBuffer = new byte[comPort.bytesAvailable()];
					int numRead = comPort.readBytes(readBuffer, readBuffer.length);
					
					for (int i = 0; i < numRead; i++) {
						char cur = (char) readBuffer[i];
						if (cur == ';') {
							String[] keyValuePairs = incomingMsg.split(",");
							for (String keyValue : keyValuePairs) {
								String[] keyAndValue = keyValue.split("=");
								incomingData.put(keyAndValue[0], keyAndValue[1]);
							}
							incomingMsg = "";
						} else {
							incomingMsg += cur;
						}
					}
				}
			}
		}, 0, 5);
	}
	
	public static String read(String key) {
		return incomingData.get(key);
	}
	
	public static void write(String key, String value) {
		outgoingData.put(key, value);
	}
}
