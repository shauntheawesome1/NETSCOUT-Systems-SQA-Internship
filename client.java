package first;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client {
       public static void main(String[] args) throws UnknownHostException, IOException {
             int num, temp;
             Scanner sc = new Scanner(System.in);
             Socket s = new Socket("283.32.74.82",1600); //Random IP Address and port
             Scanner sc1 = new Scanner(s.getInputStream());
             System.out.println("Enter any Number");
             num = sc.nextInt();
             PrintStream p = new PrintStream(s.getOutputStream());
             p.println(num);
             temp = sc1.nextInt();
             System.out.println(temp);
             
       }
       
             
       
}
