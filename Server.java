package first;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.net.ServerSocket;

public class server {
       public static void main(String[] args) throws IOException {
             int num, temp;
             ServerSocket s1 = new ServerSocket(1600); //Random Port, but has to be the same as the client
             Socket ss = s1.accept();
             Scanner sc = new Scanner(ss.getInputStream());
             num = sc.nextInt();
             
             temp = num * 2;
             
             PrintStream p = new PrintStream(ss.getOutputStream());
             p.println(temp);
             
       }
}
