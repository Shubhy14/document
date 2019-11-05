import java.net.*;
import java.io.*;  
import java.util.*;

public class Server {
	public static void main(String args[])throws Exception{  
		ServerSocket ss=new ServerSocket(6006);  
		Socket s=ss.accept();  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		Scanner sc=new Scanner(System.in); 
		  
		String str1="",str2="";  
		System.out.println("Server Socket Created.\nWaiting for data..\n");
		while(!str1.equals("by")){  
			str1=din.readUTF();  
			System.out.println("client says: "+str1);  
			str2=sc.nextLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}}   
	