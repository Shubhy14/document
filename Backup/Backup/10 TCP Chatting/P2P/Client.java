import java.net.*;
import java.io.*;  
import java.util.*;
public class Client {

	public static void main(String args[])throws Exception{  
		Socket s=new Socket("127.0.0.1",6006);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		Scanner sc=new Scanner(System.in); 

		String str1="",str2="";  
		System.out.println("Client Socket Created.\nENter msg:");
		while(!str1.equals("by")){  
			System.out.print(">");
			str1=sc.nextLine();  
			dout.writeUTF(str1);  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Server says: "+str2);  
		}  
	  
		dout.close();  
		s.close();  
	}}