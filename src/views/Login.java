package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Login {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300, 400);
		
		JLabel nameLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");
		JTextField userField = new JTextField();
		JTextField passwordField = new JTextField();
		JButton button = new JButton("Login");
		
		JPanel panel = new JPanel(new MigLayout());
		frame.add(panel);
		
		panel.add(nameLabel);
		panel.add(userField, "wrap, grow, width 150:250");
		panel.add(passwordLabel);
		panel.add(passwordField, "wrap, grow, width 150:250");
		panel.add(button);
		
		frame.pack();
		frame.setVisible(true);
		
	}
}
