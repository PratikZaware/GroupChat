 package MainPackage;

import java.net.*;
import java.io.*;
import java.util.*;


class SendMessageThread implements Runnable
{
	private MulticastSocket socket;
	private InetAddress group;
	private int port;
	private static final int MAX_LEN = 1000;
	static String message="";

	SendMessageThread(MulticastSocket socket,InetAddress group,int port)
	{
		this.socket = socket;
		this.group = group;
		this.port = port;
	}
	
	@Override
	public void run()
	{
		System.out.println("Send started");
		while(true)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{

			}
			Scanner sc=new Scanner(System.in);
			String message;
			// message=sc.nextLine();
			message = Frame2.messageTextFeild.getText();
			// System.out.println("In sendmessage : "+message);
			if(!message.equals("") && Frame2.clicked)
			{
				try
				{
					if(message.equalsIgnoreCase("EXIT"))
					{
						GroupChat.finished = true;
						socket.leaveGroup(group);
						socket.close();
						break;
					}
					Frame2.wholeMessage+="\n "+message;
					message = GroupChat.name + ": " + message;
					byte[] buffer = message.getBytes();
					DatagramPacket datagram = new DatagramPacket(buffer,buffer.length,group,port);
					socket.send(datagram);
					Frame2.clicked=false;
					Frame2.messageTextFeild.setText("");
				}
				catch(IOException e)
				{
					System.out.println(e);
					System.out.println("Exception in sending");
				}
			}
		}
	}
}

