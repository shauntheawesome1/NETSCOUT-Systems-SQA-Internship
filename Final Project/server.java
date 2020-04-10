import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.*;

public class server{
	private static Socket socket;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("ipFile.csv"));
		String line = "";
		int count = 0;

		while((line = r.readLine()) != null){
			ProcessBuilder pb = new ProcessBuilder();
			pb.command("bash", "-c", "ifup interface");

			int tempIndex = line.indexOf(",");
			int portIndex = tempIndex + 1;
			System.out.println(line);
			String ipaddr = line.substring(0,tempIndex);
			InetAddress server = InetAddress.getByName(ipaddr);
		//	String server = ipaddr;		
			int port = Integer.parseInt(line.substring(portIndex));
			
			String[] cmd = {"pathway/ip_change.sh", ipaddr};
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
			ServerSocket s1 = new ServerSocket(port,128,server);
//			
			
			//Input to server and console
			socket = s1.accept();
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String message = br.readLine();
			System.out.println("Message recieved from Client:" + message);

			//Output to client and console
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			String returnMessage = "Hello, recieved your message.";
			bw.write(returnMessage);
			System.out.println("Message sent to the client is: " + returnMessage);
			bw.flush();

			count++;
			pb.command("bash", "-c", "ifdown interface");
		}
	}
}
