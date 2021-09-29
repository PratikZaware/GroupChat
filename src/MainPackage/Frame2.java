package MainPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame2 extends JFrame
{
	JPanel mainPanel;
	JButton sendButton,closeButton;
	static JTextArea messagesTextFeild,messageTextFeild;
	static String wholeMessage="";
	static volatile boolean clicked=false;

	Frame2()
	{
		setTitle("GroupChat");
		setLayout(null);
		setSize(800,800);
		setResizable(false);
		addComponent();
		addWindowListener(new WindowCloser());
		setVisible(true);
	}

	public void addComponent()
	{
		mainPanel=new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,800,800);
		mainPanel.setBackground(new Color(18,140,126));

		messagesTextFeild=new JTextArea("");
		messagesTextFeild.setFont(new Font("verdana",Font.BOLD,14));
		messagesTextFeild.setBounds(40,50,700,500);
		mainPanel.add(messagesTextFeild);

		messageTextFeild=new JTextArea("");
		messageTextFeild.setFont(new Font("verdana",Font.BOLD,14));
		messageTextFeild.setBounds(40,580,550,70);
		mainPanel.add(messageTextFeild);


		sendButton=new JButton("SEND");
		sendButton.setBounds(600,580,140,70);
		sendButton.setFont(new Font("verdana",Font.BOLD,14));
		sendButton.addActionListener(new SendMessage(this));
		mainPanel.add(sendButton);
		
		closeButton=new JButton("CLOSE");
		closeButton.setBounds(350,700,100,40);
		closeButton.addActionListener(new WindowCloser());
		mainPanel.add(closeButton);
		
		add(mainPanel);
	}
}




