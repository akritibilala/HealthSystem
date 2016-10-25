package views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.UserController;
import model.HealthSystemUser;
import model.Observation;
import model.Recommendation;

public class HealthIndicatorsPanel extends JPanel {

	private HealthSystemUser user;
	private Map<Observation,Recommendation> recoMap;
	public HealthIndicatorsPanel(HealthSystemUser user) {
		this.user = user;
		populateHealthIndicators();
		recoMap = new HashMap<Observation,Recommendation>();
	}
	
	public void populateHealthIndicators() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10,22,0,0));
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel healthSupportersLabel = new JLabel("Health Indicators:");
		healthSupportersLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(healthSupportersLabel);
		
		UserController controller = new UserController();
		recoMap = controller.getRecommendations(user);
		if(recoMap.size() > 0)
		{
			Object columnNames[] = { "Observation", "Upper Limit", "Lower Limit", "Text", "Frequency" };
			Object rowData[][] = new Object[recoMap.size()][];
//			Object columnNames[] = { "Column One", "Column Two", "Column Three" };
//			Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
//			            { "Row2-Column1", "Row2-Column2", "Row2-Column3" } }; 
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
				i++;
			}	
			JTable table = new JTable(rowData, columnNames);
			this.add(new JScrollPane(table));
		}
		else
		{
			JLabel hsLabel = new JLabel("No health indicators found! :)");
			this.add(hsLabel);
		}
		
		//Add an Observation
//		JComponent horizontalPanel1 = new JPanel();
//		horizontalPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
//		horizontalPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel addObservationLabel = new JLabel("Add Observation:");
		healthSupportersLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(addObservationLabel);
		
		{
			JComponent horizontalPanel1 = new JPanel();
			JLabel addObsType= new JLabel("Observation Type:");
			healthSupportersLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
			Set<Observation> observations = recoMap.keySet();
			
			JComboBox<String> addObsCombobox = new JComboBox<String>();
		    for(Observation observation : observations)
		    {
		    	addObsCombobox.addItem(observation.getType());
		    }
		    horizontalPanel1.add(addObsCombobox);
			horizontalPanel1.add(addObsType);
			
			this.add(horizontalPanel1);
		}
		
		{
			JComponent horizontalPanel1 = new JPanel();
			JLabel addObsType= new JLabel("Observation Type:");
			healthSupportersLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
			Set<Observation> observations = recoMap.keySet();
			
			JComboBox<String> addObsCombobox = new JComboBox<String>();
		    for(Observation observation : observations)
		    {
		    	addObsCombobox.addItem(observation.getType());
		    }
		    horizontalPanel1.add(addObsCombobox);
			horizontalPanel1.add(addObsType);
			
			this.add(horizontalPanel1);
		}
		
//		horizontalPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
//		horizontalPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
//		addObservation(horizontalPanel1);
		
		
//		//Delete a HealthSupporter
//		JComponent horizontalPanel2 = new JPanel();
//		horizontalPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
//		horizontalPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
//		deleteDiagnoses(horizontalPanel2);
//		this.add(horizontalPanel2);
	}

	
	void refreshPanel()
	{
		this.removeAll();
		this.populateHealthIndicators();
		this.repaint();
	}

	private void addObservation(JComponent diagnosesPanel) {
		JLabel addObservationLabel = new JLabel("Add an Observation:");
		diagnosesPanel.add(addObservationLabel);
	    JComboBox<String> diagnosesCombobox = new JComboBox<String>();
	    Set<Observation> observations = recoMap.keySet();
	    for(Observation observation : observations)
	    {
	    	diagnosesCombobox.addItem(observation.getType());
	    }
	    diagnosesPanel.add(diagnosesCombobox);
	    JButton addObservationButton = new JButton("Add Observation");
	    diagnosesPanel.add(addObservationButton);
	    addObservationButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	            {
//	                int index = diagnosesCombobox.getSelectedIndex();
//	                Disease diseaseToAdd = diseaseList.get(index);
//	                DiseaseController controller = new DiseaseController();
//	                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//	                try {
//						int count = controller.setDiagnoses(user, diseaseToAdd, date);
//						if(count == 1)
//							JOptionPane.showMessageDialog(null, "Diagnosis added successfully!","Add Diagnosis",JOptionPane.ERROR_MESSAGE);
//						refreshPanel();
//					} catch (Exception e) {
//						e.printStackTrace();
//		               	JOptionPane.showMessageDialog(null, e.getMessage(),"Add Diagnosis",JOptionPane.ERROR_MESSAGE);
//					}
	            }
			}
		});
	}
}
