package MainPackage;

import java.net.*;
import java.io.*;
import java.util.*;

public class GroupChat
{
	static String name;
	static volatile boolean finished = false;
	static InetAddress group;
	static int port;
	static MulticastSocket socket;

	public static void main(String[] args)
	{
		try
		{
			port=6789;
			group = InetAddress.getByName("228.5.6.7");
			socket = new MulticastSocket(port);
			socket.joinGroup(group);
			
			Frame1 obj=new Frame1();			
		}
		catch(SocketException se)
		{
			System.out.println("Error creating socket");
		}
		catch(IOException ie)
		{
			System.out.println("Error reading/writing from/to socket");
		}
	}
}

