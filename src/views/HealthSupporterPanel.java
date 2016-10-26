package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import model.Authorization;
import model.HealthSystemUser;
import javax.swing.DefaultComboBoxModel;

public class HealthSupporterPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthSupporterPanel frame = new HealthSupporterPanel();
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
	public HealthSupporterPanel() {
		setBounds(100, 100, 633, 369);
		populateHealthSupporters();	
	}
	
	private void populateHealthSupporters() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox cmbxHs = new JComboBox();
		
		
		
		
		JButton btnViewDetails = new JButton("View Details");
		
		
		JComboBox cmbxUsers = new JComboBox();
		
		JButton btnAddDetails = new JButton("Add HealthSupporter");
	
		
		JLabel lblUserIs = new JLabel("If the\u206D user is not visible in the drop-down you can sign him up below!");
		
		JButton btnSignup = new JButton("Signup");
		
		JComboBox cmbxType = new JComboBox();
		cmbxType.setModel(new DefaultComboBoxModel(new String[] {"PRIMARY", "SECONDARY"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUserIs, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(cmbxType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(57)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbxHs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cmbxUsers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnViewDetails, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
								.addComponent(btnAddDetails, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(260)
							.addComponent(btnSignup, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnViewDetails)
						.addComponent(cmbxHs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddDetails)
						.addComponent(cmbxUsers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUserIs)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSignup)
					.addContainerGap())
		);
		
		UserController controller = new UserController();
		List<Authorization> authList = controller.getHealthSupportersAuthorizations(Main.currentUser);
		Object columnNames[] = { "HealthSupporter Id", "HealthSupporter Name", "Authorization Date", "Type"};
		Object rowData[][] = new Object[authList.size()][];
		int i = 0;
		for(Authorization auth: authList)
		{
			rowData[i] = new Object[columnNames.length];
			rowData[i][0] = auth.getHealthSupporter().getId();
			rowData[i][1] = auth.getHealthSupporter().getName();
			rowData[i][2] = auth.getAuthorizationDate();
			rowData[i][3] = auth.getHealthSupporterType();
			i++;
			cmbxHs.addItem(auth.getHealthSupporter().getId());
		}	
		
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = cmbxHs.getSelectedIndex();
				HealthSystemUser healthSupporter = authList.get(index).getHealthSupporter();
				new ProfilePanel(healthSupporter).setVisible(true);
			}
		});
		
		List<HealthSystemUser> userList = controller.getAllUsers();
		for(HealthSystemUser user : userList)
		{
			cmbxUsers.addItem(user.getId());
		}
		
		btnAddDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HealthSystemUser user= userList.get(cmbxUsers.getSelectedIndex());
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				String type = cmbxType.getSelectedItem().toString();
				try
				{
					int count = controller.addExistingUserAsHealthSupporter(Main.currentUser, user, type, date);
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "HealthSupporter added successfully!","Add HealthSupporter",JOptionPane.INFORMATION_MESSAGE);
						refreshPanel();
					}
					else
						JOptionPane.showMessageDialog(null, "Error in adding healthsupporter!","Add HealthSupporter",JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Add HealthSupporter",JOptionPane.ERROR_MESSAGE);
				}
			}

			
		});
		
		table = new JTable(rowData, columnNames);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

	private void refreshPanel() {
		getContentPane().removeAll();
		populateHealthSupporters();
		getContentPane().invalidate();
		getContentPane().repaint();
	}
}
