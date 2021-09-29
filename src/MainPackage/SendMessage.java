package MainPackage;

import java.awt.*;
import java.awt.event.*;

class SendMessage implements ActionListener
{
	Frame2 ref;

	SendMessage(Frame2 temp)
	{
		ref=temp;
	}

	public void actionPerformed(ActionEvent e) 
	{
		Frame2.clicked=true;
		
		// SendMessageThread.message=ref.messageTextFeild.getText();
		// Frame2.wholeMessage=SendMessageThread.message+"\n"+GetMessageThread.message;
		// ref.messagesTextFeild.setText(Frame2.wholeMessage);

		// Thread perform=new Thread(new PerformAll(ref));
		// perform.start();

		// SendMessageThread.message=ref.messageTextFeild.getText();
		// System.out.println("Printing from sendmessage : "+SendMessageThread.message);
		// ref.messagesTextFeild.setText(SendMessageThread.message);
		// ref.messagesTextFeild.setText(GetMessageThread.message);
	}
}
