import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class AppClient extends Frame implements ActionListener,Runnable
{

 Button b;
 TextField tf;
 TextArea ta;
 Socket s;
 PrintWriter pw;
 BufferedReader br;
 Thread th;
 
 public AppClient()
 {
  Frame f=new Frame("Client Side Chatting");
  f.setLayout(new FlowLayout());
  f.setBackground(Color.orange);
  b=new Button("Send");
  b.addActionListener(this);
  f.addWindowListener(new W1());
  tf=new TextField(15);
  ta=new TextArea(12,20);
  ta.setBackground(Color.cyan);
  f.add(tf);
  f.add(b);
  f.add(ta);
  try{
   s=new Socket(InetAddress.getLocalHost(),12000);

   br=new BufferedReader(new InputStreamReader(s.getInputStream()));

   pw=new PrintWriter(s.getOutputStream(),true);
  }catch(Exception e)  
  {
  }
  th=new Thread(this);
  th.setDaemon(true);
  th.start();
  setFont(new Font("Arial",Font.BOLD,20));
  f.setSize(200,200);
  f.setVisible(true);
  f.setLocation(100,300);
  f.validate();
 }

 private class W1 extends WindowAdapter
 {
  public void windowClosing(WindowEvent we)
  {
   System.exit(0);
  }
 }

 public void actionPerformed(ActionEvent ae)
 {
  pw.println(tf.getText());
  tf.setText("");
 }

 public void run()
 {
  while(true)
  {
   try{
    ta.append(br.readLine()+"\n");
   }catch(Exception e) {}
  }
 }

 public static void main(String args[])
 {

  AppClient client = new AppClient();
 }
}


