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
		frame.setBounds(100, 100, 486, 269);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblUsername = new JLabel("Username");
		frame.getContentPane().add(lblUsername, "4, 4");
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		frame.getContentPane().add(txtUsername, "8, 4, left, default");
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		frame.getContentPane().add(lblPassword, "4, 6");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		frame.getContentPane().add(passwordField, "8, 6, left, default");
		
		JCheckBox chkHs = new JCheckBox("Health Supporter?");
		frame.getContentPane().add(chkHs, "4, 8");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserController userController = new UserController();
		        currentUser = userController.login(txtUsername.getText(), String.copyValueOf(passwordField.getPassword()));
//				Main.currentUser = new HealthSystemUser();
//				currentUser.setId("P2");
//				currentUser.setType("Both");
		        if(currentUser!=null)
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
                else
                {
                	JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("sorry");
                }	
			}
		});
		

		
		JLabel lblOr = new JLabel("OR");
		frame.getContentPane().add(lblOr, "6, 12, center, default");
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup().setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnSignup, "6, 14");
		frame.getContentPane().add(btnLogin, "6, 10");
	}

}
