package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.AlertController;
import controller.RecordController;
import controller.UserController;
import model.AlertPatientInfo;
import model.HealthSystemUser;
import model.Observation;
import model.Recommendation;

public class HealthIndicatorPanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthIndicatorPanel frame = new HealthIndicatorPanel();
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
	public HealthIndicatorPanel() {
		setBounds(100, 100, 783, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox cmbxObs = new JComboBox();
		UserController controller = new UserController();
		List<Observation> observationList = new ArrayList<Observation>();
		recoMap = controller.getRecommendations(Main.currentUser);
//		if(recoMap.size() > 0)
//		{
			Object columnNames[] = { "Observation", "Upper Limit", "Lower Limit", "Text", "Frequency","Alert Percenatge Threshold", "Alert Observation Threshold", "Alert Frequency Threshold" };
			Object rowData[][] = new Object[recoMap.size()][];
//			Object columnNames[] = { "Column One", "Column Two", "Column Three" };
//			Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
//			            { "Row2-Column1", "Row2-Column2", "Row2-Column3" } }; 
			AlertController alertController = new AlertController();
			Map<Integer,AlertPatientInfo> obsAlertMap = alertController.getAlertPatientInfoMap(Main.currentUser);
			int i = 0;
			for(Map.Entry<Observation, Recommendation> entry: recoMap.entrySet())
			{
				rowData[i] = new Object[columnNames.length];
				rowData[i][0] = entry.getKey().getType();
				Double upperLimit = entry.getValue().getUpperLimit();
				rowData[i][1] = upperLimit == null ? "N/A": upperLimit.toString();
				Double lowerLimit = entry.getValue().getLowerLimit();
				rowData[i][2] = lowerLimit == null ? "N/A": lowerLimit.toString();
				String text = entry.getValue().getText();
				rowData[i][3] = text == null ? "N/A": text.toString();
				Integer frequency = entry.getValue().getFrequency();
				rowData[i][4] = frequency == null ? "N/A": frequency.toString();
				if(obsAlertMap.get(entry.getKey().getId())!=null)
				{
				AlertPatientInfo info = obsAlertMap.get(entry.getKey().getId());
				Integer alertPercentageThreshold = info.getAlertPercentageThreshold();
				rowData[i][5] = alertPercentageThreshold.toString();
				Integer alertObservationThreshold = info.getAlertObservationThreshold();
				rowData[i][6] = alertObservationThreshold.toString();
				Integer alertFrequencyThreshold = info.getAlertFrequencyThreshold();
				rowData[i][7] = alertFrequencyThreshold.toString();
				}
				else
				{
				rowData[i][5] = "N/A";
				rowData[i][6] = "N/A";
				rowData[i][7] = "N/A";
				}
				i++;
				observationList.add(entry.getKey());
				cmbxObs.addItem(entry.getKey().getType());
			}	
//			JTable table = new JTable(rowData, columnNames);
//			this.add(new JScrollPane(table));
//			table = new JTable(rowData,columnNames);
//		}
//		else
		{
			JLabel hsLabel = new JLabel("No health indicators found! :)");
			getContentPane().add(hsLabel);
		}
		
		JLabel lblAddObservation = new JLabel("Add Observation:");
		lblAddObservation.setVerticalAlignment(SwingConstants.TOP);
		lblAddObservation.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtEnterDate = new JTextField();
		txtEnterDate.setText("Enter Date of Observation");
		txtEnterDate.setColumns(10);
		
		txtEnterValue = new JTextField();
		txtEnterValue.setText("Enter Value");
		txtEnterValue.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index = cmbxObs.getSelectedIndex();
				Observation observation = observationList.get(index);
				String value = txtEnterValue.getText();
				String date = txtEnterDate.getText();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date temp = null;
				try {
					temp=sdf.parse(date);
				
				java.sql.Date recordingTime = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	        	java.sql.Date sql_temp = new java.sql.Date(temp.getTime());
	        	RecordController record = new RecordController();
	        	Main.currentUser = new HealthSystemUser();
	        	Main.currentUser.setId("P1");
				int count = record.insertRecord(Main.currentUser,observation, value, sql_temp,recordingTime);
				if(count == 1)
						JOptionPane.showMessageDialog(null, "Observation Record added successfully!","Add Record",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Error in adding observation record!","Add Record",JOptionPane.ERROR_MESSAGE);
				} catch (ParseException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error in adding observation record!","Add Record",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		lblEnterDateIn = new JLabel("(Enter Date in yyyy-MM-dd hh:mm:ss)");
		
//		scrollPane.setViewportView(table);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(cmbxObs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddObservation))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtEnterDate, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEnterValue, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnAdd))
								.addComponent(lblEnterDateIn))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddObservation)
						.addComponent(lblEnterDateIn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEnterDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbxObs, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEnterValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdd))
					.addGap(21))
		);
		
		table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		
//		populateHealthIndicators();
	}
	
	Map<Observation,Recommendation> recoMap = new HashMap<Observation,Recommendation>();
	private JTable table;
	private JTextField txtEnterDate;
	private JTextField txtEnterValue;
	private JLabel lblEnterDateIn;
//	private JTable table;

	private void populateHealthIndicators() {
		UserController controller = new UserController();
		recoMap = controller.getRecommendations(Main.currentUser);
		
		DefaultTableModel model = new DefaultTableModel();
	}
}
