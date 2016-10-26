package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ObservationController;
import controller.UserController;
import model.Authorization;
import model.HealthSupporter;
import model.Observation;

import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.ScrollPane;
import java.util.List;
import java.awt.Label;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox cmbxHs = new JComboBox();
		
		
		
		
		JButton btnViewDetails = new JButton("View Details");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(cmbxHs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(35)
							.addComponent(btnViewDetails))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
					.addGap(63))
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
					.addGap(48))
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
		
		table = new JTable(rowData, columnNames);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
