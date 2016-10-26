package views;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import model.HealthSupporter;
import model.HealthSystemUser;

import javax.swing.SwingConstants;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Signup() {
		setBounds(100, 100, 450, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setVerticalAlignment(SwingConstants.TOP);
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.WEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 1;
		contentPane.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.anchor = GridBagConstraints.WEST;
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.gridx = 3;
		gbc_txtId.gridy = 1;
		contentPane.add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		contentPane.add(lblName, gbc_lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.anchor = GridBagConstraints.WEST;
		gbc_txtName.insets = new Insets(0, 0, 5, 0);
		gbc_txtName.gridx = 3;
		gbc_txtName.gridy = 2;
		contentPane.add(txtName, gbc_txtName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setVerticalAlignment(SwingConstants.TOP);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.WEST;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 3;
		contentPane.add(passwordField, gbc_passwordField);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setVerticalAlignment(SwingConstants.TOP);
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 4;
		contentPane.add(lblAddress, gbc_lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.insets = new Insets(0, 0, 5, 0);
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.gridx = 3;
		gbc_txtAddress.gridy = 4;
		contentPane.add(txtAddress, gbc_txtAddress);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setVerticalAlignment(SwingConstants.TOP);
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.anchor = GridBagConstraints.WEST;
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridx = 1;
		gbc_lblDateOfBirth.gridy = 5;
		contentPane.add(lblDateOfBirth, gbc_lblDateOfBirth);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 5;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("(Enter Date in MM-dd-yyyy)");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JCheckBox chckbxPatient = new JCheckBox("Patient?");
		GridBagConstraints gbc_chckbxPatient = new GridBagConstraints();
		gbc_chckbxPatient.anchor = GridBagConstraints.WEST;
		gbc_chckbxPatient.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxPatient.gridx = 3;
		gbc_chckbxPatient.gridy = 7;
		contentPane.add(chckbxPatient, gbc_chckbxPatient);
		
		JCheckBox chckbxHealthsupporter = new JCheckBox("HealthSupporter?");
		GridBagConstraints gbc_chckbxHealthsupporter = new GridBagConstraints();
		gbc_chckbxHealthsupporter.anchor = GridBagConstraints.WEST;
		gbc_chckbxHealthsupporter.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxHealthsupporter.gridx = 3;
		gbc_chckbxHealthsupporter.gridy = 8;
		contentPane.add(chckbxHealthsupporter, gbc_chckbxHealthsupporter);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
		gbc_rdbtnMale.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnMale.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMale.gridx = 3;
		gbc_rdbtnMale.gridy = 9;
		contentPane.add(rdbtnMale, gbc_rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		GridBagConstraints gbc_rdbtnFemale = new GridBagConstraints();
		gbc_rdbtnFemale.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnFemale.anchor = GridBagConstraints.WEST;
		gbc_rdbtnFemale.gridx = 3;
		gbc_rdbtnFemale.gridy = 10;
		contentPane.add(rdbtnFemale, gbc_rdbtnFemale);
		
		 //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnMale);
	    group.add(rdbtnFemale);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String id = txtId.getText();
				String address = txtAddress.getText();
				String dateString  = textField.getText();
				String name = txtName.getText();
				String password = String.copyValueOf(passwordField.getPassword());
				SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		        Date parsed = format.parse(dateString);
		        java.sql.Date date = new java.sql.Date(parsed.getTime());
				String gender = rdbtnMale.isSelected()==true?"MALE":"FEMALE";
				String type = "";
				if(chckbxHealthsupporter.isSelected()&&chckbxPatient.isSelected())
					type = "Both";
				else if(chckbxHealthsupporter.isSelected())
				{
					type = "Health Supporter";
				}
				else if(chckbxPatient.isSelected())
				{
					type = "Patient";
				}
				else
					throw new Exception("Please select eith health supporter or patient or both!");
				if(validate(id,name,address,date,password,gender,type))
				{
					Main.currentUser = new HealthSystemUser(id, date, gender, address, name, type);
					UserController controller = new UserController();
					int count = controller.insertUser(id, name, address, gender, date, password,type);
					if(count == 1)
					{
						if(chckbxHealthsupporter.isSelected() && (Main.currentUser.getType().equals("Health Supporter") || Main.currentUser.getType().equals("Both")) )
		                {
							Main.currentUser = new HealthSupporter(Main.currentUser.getId(),Main.currentUser.getDateOfBirth(),Main.currentUser.getGender(),Main.currentUser.getAddress(),Main.currentUser.getName());
				        	//Login Health Supporter
		                	new HealthSupporterHome().setVisible(true);
		                	closeFrame();
		                }
				        else if(!chckbxHealthsupporter.isSelected() && (Main.currentUser.getType().equals("Patient") || Main.currentUser.getType().equals("Both")))
				        {
				        	//Login Patient
		                	new PatientHome().setVisible(true);
//		                    frame.dispose();
		                	closeFrame();
				        }
					}
				}
				} catch (ParseException e1) {
					e1.printStackTrace();
	               	JOptionPane.showMessageDialog(null, "Please check the date entered","Signup Failed!",
                            JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e2)
				{
					e2.printStackTrace();
                	JOptionPane.showMessageDialog(null, e2.getMessage(),"Signup Failed!",
                            JOptionPane.ERROR_MESSAGE);
				}
//				UserController controller = new UserController();
			}

			private boolean validate(String id, String name, String address, Date date, String password,String gender,String type) throws Exception {
				if(id==null||name==null||address==null||date==null||password==null||gender==null||type==null)
				throw new Exception("Invalid input");
				if(id.equals("")||name.equals("")||address.equals("")||password.equals("")||gender.equals("")||type.equals(""))
					throw new Exception("Invalid input");
				return true;
			}
		});
		GridBagConstraints gbc_btnSignup = new GridBagConstraints();
		gbc_btnSignup.insets = new Insets(0, 0, 0, 5);
		gbc_btnSignup.gridx = 2;
		gbc_btnSignup.gridy = 11;
		contentPane.add(btnSignup, gbc_btnSignup);
	}
	
	void closeFrame()
	{
		super.dispose();
	}

}
