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
import controller.DiseaseController;
import controller.UserController;
import model.Alert;
import model.Authorization;
import model.Disease;
import model.HealthSupporter;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class AlertPatientHealthSupporterPanel extends JFrame {

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
					AlertPatientHealthSupporterPanel frame = new AlertPatientHealthSupporterPanel();
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
	public AlertPatientHealthSupporterPanel() {
		setBounds(100, 100, 623, 324);
		contentPane = new JPanel();
		populateAlerts();
	}
	
	void populateAlerts()
	{
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		btnAddObservation = new JButton("Add Observation");
		btnAddObservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HealthIndicatorPanel().setVisible(true);
			}
		});
		
		JButton btnGenerateAlerts = new JButton("Generate Alerts");
		btnGenerateAlerts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlertController ac = new AlertController();
				List<Alert> alerts = ac.generateAlertForHealthSupporter(Main.currentUser);
				for(Alert alert : alerts)
				{
					ac.insertAlert(alert);
				}
				refreshPanel();
			}
		});
		
		AlertController controller = new AlertController();
		List<Alert> alertList = controller.getAllAlertsForHealthSupporter(Main.currentUser);
		Object columnNames[] = { "Alert Id", "Patient", "Alert Type", "Alert Message", "Alert Date","Observation"};
		Object rowData[][] = new Object[alertList.size()][];
		int i = 0;
		for(Alert auth: alertList)
		{
			rowData[i] = new Object[columnNames.length];
			rowData[i][0] = auth.getId();
			rowData[i][1] = auth.getPatient().getId();
			rowData[i][2] = auth.getType();
			rowData[i][3] = auth.getAlertMessage();
			rowData[i][4] = auth.getDate();
			rowData[i][5] = auth.getObsType().getType();
			i++;
		}	
		
		JComboBox cmbxAlerts = new JComboBox();
	    for(Alert alert: alertList)
	    {
	    	cmbxAlerts.addItem(alert.getId());
	    }
		
		JButton btnClearAlerts = new JButton("Clear Alerts");
		btnClearAlerts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = cmbxAlerts.getSelectedIndex();
				Alert alert = alertList.get(index);
				controller.clearAlert(alert);
				refreshPanel();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnGenerateAlerts)
							.addGap(59)
							.addComponent(cmbxAlerts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnClearAlerts)
							.addPreferredGap(ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
							.addComponent(btnAddObservation)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddObservation)
						.addComponent(btnGenerateAlerts)
						.addComponent(cmbxAlerts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClearAlerts))
					.addGap(23))
		);
		
		
		
		table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
	    
	}
	
	void refreshPanel()
	{
		getContentPane().removeAll();
		populateAlerts();
		getContentPane().invalidate();
		getContentPane().repaint();
	}
}
