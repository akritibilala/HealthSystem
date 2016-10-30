package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.HealthSystemUser;

public class ProfilePanel extends JFrame {

	private JPanel contentPane;
	private HealthSystemUser user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePanel frame = new ProfilePanel(Main.currentUser);
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
	public ProfilePanel(HealthSystemUser user) {
		setBounds(100, 100, 450, 300);
		this.user = user;
		populateProfile();
	}

	public void populateProfile() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUid = new JLabel("UID");
		lblUid.setBounds(10, 11, 77, 14);
		contentPane.add(lblUid);

		JLabel lblNewLabel = new JLabel(user.getId());
		lblNewLabel.setBounds(112, 11, 126, 14);
		contentPane.add(lblNewLabel);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 36, 77, 14);
		contentPane.add(lblName);

		JLabel lblNewLabel_1 = new JLabel(user.getName());
		lblNewLabel_1.setBounds(112, 36, 126, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 61, 77, 14);
		contentPane.add(lblAddress);

		JLabel lblNewLabel_2 = new JLabel(user.getAddress());
		lblNewLabel_2.setBounds(112, 50, 290, 36);
		contentPane.add(lblNewLabel_2);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 86, 77, 14);
		contentPane.add(lblGender);

		JLabel lblNewLabel_3 = new JLabel(user.getGender());
		lblNewLabel_3.setBounds(112, 89, 126, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setBounds(10, 111, 92, 14);
		contentPane.add(lblDateOfBirth);

		JLabel lblNewLabel_4 = new JLabel(user.getDateOfBirth().toString());
		lblNewLabel_4.setBounds(112, 114, 126, 14);
		contentPane.add(lblNewLabel_4);
		
		/*JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 136, 77, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewLabel_5 = new JLabel(user.getPassword());
		lblNewLabel_5.setBounds(112, 139, 115, 14);
		contentPane.add(lblNewLabel_5);*/

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditProfile(user).setVisible(true);
			}
		});
		btnEdit.setBounds(13, 181, 89, 23);
		contentPane.add(btnEdit);
		
	}

}
