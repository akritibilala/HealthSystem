package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.UserController;
import model.HealthSupporter;
import model.HealthSystemUser;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main {

	private JFrame frame;
	private JTextField txtUsername;
	public static HealthSystemUser currentUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 268);
		
		JLabel lblUsername = new JLabel("Username");
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		JCheckBox chkHs = new JCheckBox("Health Supporter?");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserController userController = new UserController();
		        currentUser = userController.login(txtUsername.getText(), String.copyValueOf(passwordField.getPassword()));
//				Main.currentUser = new HealthSystemUser();
//				currentUser.setId("P2");
//				currentUser.setType("Both");
		        if(currentUser!=null)
		        {
		        	if(chkHs.isSelected() && (currentUser.getType().equals("Health Supporter") || currentUser.getType().equals("Both")) )
		        	{
		        		currentUser = new HealthSupporter(currentUser.getId(),currentUser.getDateOfBirth(),currentUser.getGender(),currentUser.getAddress(),currentUser.getName());
		        		//Login Health Supporter
		        		new HealthSupporterHome().setVisible(true);
		        		frame.dispose();
		        	}
		        	else if(!chkHs.isSelected() && (currentUser.getType().equals("Patient") || currentUser.getType().equals("Both")))
		        	{
		        		//Login Patient
		        		new PatientHome().setVisible(true);
		        		frame.dispose();
		        	}
		        }
                else
                {
                	JOptionPane.showMessageDialog(null, "Login failed!","Login",
                            JOptionPane.ERROR_MESSAGE);
                }	
			}
		});
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup().setVisible(true);
				frame.dispose();
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel lblWelcomeToHealth = new JLabel("HEALTH MANAGEMENT SYSTEM");
		
		JLabel lblIfAPatient = new JLabel("(If a patient is also a health-supporter, check this box to log in as Health Supporter)");
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(142)
					.addComponent(btnSignup, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
					.addGap(177))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblIfAPatient)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chkHs)
									.addGap(18)
									.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
									.addGap(76)))
							.addGap(32)))
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(separator, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(167)
					.addComponent(lblWelcomeToHealth, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(215))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addComponent(lblWelcomeToHealth)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chkHs)
						.addComponent(btnLogin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIfAPatient)
					.addGap(8)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSignup)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
