import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class shaun_client{
	private static Socket socket;
	public static void main(String[] args) throws IOException {
		String sent, reply;
		BufferedReader r = new BufferedReader(new FileReader("ipFile.csv"));
		String line = "";

		while((line = r.readLine()) != null){
			int tempIndex = line.indexOf(",");
			int portIndex = tempIndex + 1;
		
			String ipaddr = line.substring(0,tempIndex);
			int port = Integer.parseInt(line.substring(portIndex));
			
		//	Scanner sc = new Scanner(System.in);
			Socket s = new Socket(ipaddr,portIndex);
		//	Scanner sc1 = new Scanner(s.getInputStream());
		
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
		
			sent = "Hello, this is client.";
			bw.write(sent);
			bw.flush();
			System.out.println("Message sent to server: " + sent);
		
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			reply = br.readLine();
			System.out.println("Message recieved from Server: " + reply);
			}
		}
	}
