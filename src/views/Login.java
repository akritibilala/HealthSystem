package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UserController;
import model.HealthSystemUser;
import net.miginfocom.swing.MigLayout;

public class Login {
	JFrame frame = new JFrame();
	JLabel nameLabel = new JLabel("Username");
	JLabel passwordLabel = new JLabel("Password");
	JTextField userField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton button = new JButton("Login");
	UserController userController = new UserController();

	public void loginLayout() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300, 400);
		
		button.addActionListener(new LoginAuthentication());
		
		JPanel panel = new JPanel(new MigLayout());
		frame.add(panel);
		
		panel.add(nameLabel);
		panel.add(userField, "wrap, grow, width 150:250");
		panel.add(passwordLabel);
		panel.add(passwordField, "wrap, grow, width 150:250");
		panel.add(button);
		
		frame.getRootPane().setDefaultButton(button);
		button.requestFocus();
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		Login login = new Login();
		login.loginLayout();
	}
	
	class LoginAuthentication implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            if(ae.getSource()==button)
            {
                char[] temp_pwd=passwordField.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:"+userField.getText()+","+pwd);
 
                HealthSystemUser user = userController.login(userField.getText(), pwd);
                if(user!=null)
                {
                	PatientHomepage patientHomepage = new PatientHomepage(user);
                	patientHomepage.patientLayout();
                    System.out.println("yay");
                    frame.dispose();
                }
                else
                {
                	JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("sorry");
                }
            }
        }
 
    }
}
