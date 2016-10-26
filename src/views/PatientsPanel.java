package views;

import java.awt.EventQueue;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.UserController;
import model.Authorization;
import model.HealthSupporter;
import model.Observation;
import model.Recommendation;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PatientsPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox cmbxPatients;
	private JButton btnViewDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientsPanel frame = new PatientsPanel();
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
	public PatientsPanel() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		cmbxPatients = new JComboBox();
		
		btnViewDetails = new JButton("View Details");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(253, Short.MAX_VALUE)
							.addComponent(cmbxPatients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btnViewDetails, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbxPatients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewDetails))
					.addGap(39))
		);
		
		UserController controller = new UserController();
		List<Authorization> authList = controller.getPatientsUnderHealthSupporter((HealthSupporter)Main.currentUser);
		{
			Object columnNames[] = { "Patient Id", "Patient Name", "Authorization Date", "Type"};
			Object rowData[][] = new Object[authList.size()][];
			int i = 0;
			for(Authorization auth: authList)
			{
				rowData[i] = new Object[columnNames.length];
				rowData[i][0] = auth.getPatient().getId();
				rowData[i][1] = auth.getPatient().getName();
				rowData[i][2] = auth.getAuthorizationDate();
				rowData[i][3] = auth.getHealthSupporterType();
				i++;
				cmbxPatients.addItem(auth.getPatient().getId());
			}	
			
			table = new JTable(rowData, columnNames);
			scrollPane.setViewportView(table);
		}
		
		contentPane.setLayout(gl_contentPane);
		
		
		
//		table = new JTable(rowd);
//		table.setBounds(30, 149, 252, -93);
	}
}
