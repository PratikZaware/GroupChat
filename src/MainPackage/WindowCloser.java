package MainPackage;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class WindowCloser extends WindowAdapter implements ActionListener
{

	
	public WindowCloser() 
	{
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}