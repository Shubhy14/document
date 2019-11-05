import java.util.Scanner;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class PeerServer {

	public static void main(String[] args) {
		String s="";

		DatagramSocket socket=null;
		try
		{
			socket=new DatagramSocket(8778); //server socket
			
			byte[] buffer=new byte[1000]; //buffer for msg
			
			DatagramPacket incomingPacket=new DatagramPacket(buffer, buffer.length); //packet to receive data
			
			System.out.println("Server Socket Created.\nWaiting for data..\n");
			
			while(!s.equals("by"))
			{
				socket.receive(incomingPacket);
				 byte[] msg=incomingPacket.getData();
				 
				  s=new String(msg);
				 
				 System.out.println(incomingPacket.getAddress().getHostAddress()+":"+incomingPacket.getPort()+" > "+s);
			
					 Scanner br=new Scanner(System.in);
					 System.out.print(">");
					 s=br.nextLine();
					 msg=s.getBytes();
					 
					 DatagramPacket sendPacket=new DatagramPacket(msg, msg.length,incomingPacket.getAddress(),incomingPacket.getPort());
					 socket.send(sendPacket);
		
			}
			socket.close();
		}
		catch(Exception e)
		{
			
		}
	}

}