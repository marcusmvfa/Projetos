package exemploLivro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class mouseTracker {
	private static JTextField textField;
	public static void main(String[] args){
		MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame();
		mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseTrackerFrame.setSize(500,500);
		
		mouseTrackerFrame.setVisible(true);
	}
}
