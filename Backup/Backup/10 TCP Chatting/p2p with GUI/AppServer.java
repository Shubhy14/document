import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class AppServer extends Frame implements ActionListener,Runnable
{

 Button b1;
 TextField tf;
 TextArea ta;
 ServerSocket ss;
 Socket s;
 PrintWriter pw;
 BufferedReader br;
 Thread th;
 
 public AppServer()
 {
  Frame f=new Frame("Server Side Chatting");
  f.setLayout(new FlowLayout());
  f.setBackground(Color.orange);
  b1=new Button("Send");
  b1.setBackground(Color.pink);
  b1.addActionListener(this);
  tf=new TextField(15);
  ta=new TextArea(12,20);
  ta.setBackground(Color.cyan);
  f.addWindowListener(new W1());
  f.add(tf);
  f.add(b1);
  f.add(ta);
  try{
   ss=new ServerSocket(12000);
   s=ss.accept();
   System.out.println(s);

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
  f.setLocation(300,300);
  f.setVisible(true);
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
    String s=br.readLine();
    ta.append(s+"\n");
   }catch(Exception e)
   {
   }
  } 
 }

 public static void main(String args[]) 
 {

  AppServer server = new AppServer();
 }
} 

