package views;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.AlertController;
import model.Alert;
import model.Authorization;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlertPatientPanel extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAddObservation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlertPatientPanel frame = new AlertPatientPanel();
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
	public AlertPatientPanel() {
		setBounds(100, 100, 623, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAddObservation = new JButton("Add Observation");
		btnAddObservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HealthIndicatorPanel().setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
						.addComponent(btnAddObservation))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnAddObservation)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		AlertController controller = new AlertController();
		List<Alert> alertList = controller.getAllAlerts(Main.currentUser);
		Object columnNames[] = { "Alert Id", "Alert Type", "Alert Message", "Alert Date","Observation"};
		Object rowData[][] = new Object[alertList.size()][];
		int i = 0;
		for(Alert auth: alertList)
		{
			rowData[i] = new Object[columnNames.length];
			rowData[i][0] = auth.getId();
			rowData[i][1] = auth.getType();
			rowData[i][2] = auth.getAlertMessage();
			rowData[i][3] = auth.getDate();
			rowData[i][4] = auth.getObsType().getType();
			i++;
		}	
		
		table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}

}
