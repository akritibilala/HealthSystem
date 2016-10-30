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
import model.HealthSupporter;
import model.HealthSystemUser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

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
		setBounds(100, 100, 633, 428);
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
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Signup().setVisible(true);
			}
		});
		
		JComboBox cmbxType = new JComboBox();
		cmbxType.setModel(new DefaultComboBoxModel(new String[] {"PRIMARY", "SECONDARY"}));
		
		JComboBox comboBox = new JComboBox();
		
		JButton btnNewButton = new JButton("Delete Health Supporter");
		
		JLabel lblDeleteHealthSupporter = new JLabel("Delete Health Supporter:");
		
		JLabel lblViewHealthSupporter = new JLabel("View Health Supporter Details:");
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		
		JLabel lblAddHealthSupporter = new JLabel("Add Existing User as Health Supporter:");
		
		JSeparator separator_2 = new JSeparator();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(23)
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(27)
											.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGap(57))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblDeleteHealthSupporter)
											.addGap(132)
											.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(0)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(cmbxHs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(42)
											.addComponent(btnViewDetails, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblViewHealthSupporter)
											.addGap(81))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddHealthSupporter)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(cmbxType, 0, 277, Short.MAX_VALUE)
									.addGap(31)
									.addComponent(cmbxUsers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(43)
									.addComponent(btnAddDetails, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSignup, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addComponent(lblUserIs, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDeleteHealthSupporter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblViewHealthSupporter, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton)
							.addComponent(cmbxHs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnViewDetails))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 2, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblAddHealthSupporter)
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbxType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddDetails)
							.addComponent(cmbxUsers, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUserIs)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSignup)
					.addGap(34))
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
			comboBox.addItem(auth.getHealthSupporter().getId());
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cmbxHs.getSelectedIndex();
				HealthSupporter healthSupporter = authList.get(index).getHealthSupporter();
				try
				{
					int count = controller.deleteHealthSupporter(Main.currentUser, healthSupporter);
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "HealthSupporter deleted successfully!","Delete HealthSupporter",JOptionPane.INFORMATION_MESSAGE);
						refreshPanel();
					}
					else
						JOptionPane.showMessageDialog(null, "Error in deleting healthsupporter!","Delete HealthSupporter",JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage(),"Delete HealthSupporter",JOptionPane.ERROR_MESSAGE);
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
