package MainPackage;

import java.awt.*;
import java.awt.event.*;

class ChatClicked implements ActionListener
{
	Frame1 ref;
	ChatClicked(Frame1 temp)
	{
		ref=temp;
	}

	public void actionPerformed(ActionEvent e) 
	{
		GroupChat.name=ref.namefield.getText();
		ref.dispose();
		new Frame2();

		Thread send=new Thread(new SendMessageThread(GroupChat.socket,GroupChat.group,GroupChat.port));
		send.start();

		Thread rec= new Thread(new GetMessageThread(GroupChat.socket,GroupChat.group,GroupChat.port));
		rec.start();
	}
}