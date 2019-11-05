import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class PeerClient {

public final static int  PORT=8778;
	public static void main(String[] args) {
		BufferedReader br=null;
		DatagramSocket socket=null;
		String s="",s1="";
		try {
			
			socket=new DatagramSocket();
			br=new BufferedReader(new InputStreamReader(System.in));
			
			InetAddress server=InetAddress.getByName("127.0.0.1");
			System.out.println("Client Socket Created.\nEnter msg:");
			while(!s.equals("by"))
			{
				System.out.print(">");
				s=br.readLine();
				byte[] sendMsg=s.getBytes();
				
				DatagramPacket sendingPacket=new DatagramPacket(sendMsg, sendMsg.length,server,PORT);
				socket.send(sendingPacket);
				System.out.println("Waiting for reply.");
				
				byte[] replyMsg=new byte[1000];
				
				DatagramPacket receivingPacket=new DatagramPacket(replyMsg, replyMsg.length);
				socket.receive(receivingPacket);
				 byte[] data=receivingPacket.getData();
				  s1=new String(data, 0,data.length);
				 System.out.println(receivingPacket.getAddress().getHostAddress()+":"+receivingPacket.getPort()+"=> "+s1);
			
			}
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
