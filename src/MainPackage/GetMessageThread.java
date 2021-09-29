package MainPackage;

import java.net.*;
import java.io.*;
import java.util.*;

import javax.swing.JTextField;

class GetMessageThread implements Runnable
{
	private MulticastSocket socket;
	private InetAddress group;
	private int port;
	private static final int MAX_LEN = 1000;
	static String message="";

	GetMessageThread(MulticastSocket socket,InetAddress group,int port)
	{
		this.socket = socket;
		this.group = group;
		this.port = port;
	}
	
	@Override
	public void run()
	{
		System.out.println("Get started");
		while(!GroupChat.finished)
		{
			String msg;
			// System.out.println("Waiting for message in getThread!!!!");
			byte[] buffer = new byte[GetMessageThread.MAX_LEN];
			DatagramPacket datagram = new DatagramPacket(buffer,buffer.length,group,port);
			try
			{
				socket.receive(datagram);
				message = new String(buffer,0,datagram.getLength(),"UTF-8");
				if(!message.equals(""))
				{
					// System.out.println("In GetMessageThread : "+message);
					Frame2.wholeMessage+="\n";
					
					if(!message.startsWith(GroupChat.name))
					{
						for(int i=1;i<(110-message.length()-3);i++)
						{
							Frame2.wholeMessage+=" ";
						}
						Frame2.wholeMessage+=message;
					}
					// Frame2.wholeMessage+=message+"\n";
					// System.out.println(Frame2.wholeMessage);
					Frame2.messagesTextFeild.setText(Frame2.wholeMessage);
				}
			}
			catch(IOException e)
			{
				System.out.println(e);
				System.out.println("Socket closed!");
			}
			
		}
	}
}

