package MainPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Frame1 extends JFrame
{
	JPanel mainPanel;
	JButton chatButton;
	JLabel nameLabel;
	JTextField namefield;

	Frame1()
	{
		setTitle("GroupChat");
		setLayout(null);
		setSize(500,500);
		setResizable(false);
		addComponent();
		addWindowListener(new WindowCloser());
		setVisible(true);
	}

	public void addComponent()
	{
		mainPanel=new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,500,500);
		mainPanel.setBackground(new Color(18,140,126));

		chatButton=new JButton("Chat");
		chatButton.setBounds(200,350,100,50);
		chatButton.setFont(new Font("verdana",Font.BOLD,20));
		chatButton.addActionListener(new ChatClicked(this));
		mainPanel.add(chatButton);

		nameLabel=new JLabel("Name : ");
		nameLabel.setFont(new Font("verdana",Font.BOLD,20));
		nameLabel.setBounds(50,200,100,50);
		//nameLabel.setBackground(Color.WHITE);
		mainPanel.add(nameLabel);

		namefield=new JTextField();
		namefield.setAlignmentX(CENTER_ALIGNMENT);
		namefield.setFont(new Font("verdana",Font.BOLD,20));
		namefield.setBounds(170,200,250,50);
		namefield.setBackground(Color.WHITE);
		mainPanel.add(namefield);

		add(mainPanel);
	}
}

