package views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.DiseaseController;
import controller.UserController;
import model.Authorization;
import model.Disease;
import model.HealthSupporter;
import model.HealthSystemUser;

public class HealthSupportersPanel extends JPanel {

	private HealthSystemUser user;
	private List<Authorization> healthSupporterAuths;
	public HealthSupportersPanel(HealthSystemUser user) {
		this.user = user;
		populateDiagnoses();
		healthSupporterAuths = new ArrayList<Authorization>();
	}
	
	public void populateDiagnoses() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10,22,0,0));
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel healthSupportersLabel = new JLabel("Health Supporters:");
		healthSupportersLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(healthSupportersLabel);
		
		UserController controller = new UserController();
		healthSupporterAuths = controller.getHealthSupportersAuthorizations(user);
		if(healthSupporterAuths.size() > 0)
		{
			for(Authorization healthSupporterAuth : healthSupporterAuths)
			{
				JPanel panel = new JPanel();
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel.setAlignmentX(Component.LEFT_ALIGNMENT);
				JLabel healthSupporterIdLabel = new JLabel(healthSupporterAuth.getHealthSupporter().getId());
				healthSupporterIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
				healthSupporterIdLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
				JLabel healthSupporterNameLabel = new JLabel(healthSupporterAuth.getHealthSupporter().getName());
				healthSupporterNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
				healthSupporterNameLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
				panel.add(healthSupporterIdLabel);
				panel.add(healthSupporterNameLabel);
				this.add(panel);
			}	
		}
		else
		{
			JLabel hsLabel = new JLabel("No health supporters! :)");
			this.add(hsLabel);
		}
		
		//Add a Diagnosis
//		JComponent horizontalPanel1 = new JPanel();
//		horizontalPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
//		horizontalPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
//		addDiagnoses(horizontalPanel1);
//		this.add(horizontalPanel1);
		
		
		//Delete a HealthSupporter
		JComponent horizontalPanel2 = new JPanel();
		horizontalPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		horizontalPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		deleteDiagnoses(horizontalPanel2);
		this.add(horizontalPanel2);
	}

	private void deleteDiagnoses(JComponent hsPanel) {
		JLabel removeHsLabel = new JLabel("Remove Health Suppporter:");
		hsPanel.add(removeHsLabel);
	    JComboBox<String> hsCombobox = new JComboBox<String>();
	    for(Authorization auth : healthSupporterAuths)
	    {
	    	hsCombobox.addItem(auth.getHealthSupporter().getId());
	    }
	    hsPanel.add(hsCombobox);
	    JButton removeHsButton = new JButton("Remove HealthSupporter");
	    hsPanel.add(removeHsButton);
	    removeHsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	            {
//	                int index = hsCombobox.getSelectedIndex();
//	                Disease diseaseToAdd = hsCombobox.getSelectedIndex(index);
//	                DiseaseController controller = new DiseaseController();
//	                try {
//						int count = controller.deleteDiagnoses(user, diseaseToAdd);
//						if(count == 1)
//							JOptionPane.showMessageDialog(null, "Diagnosis removed successfully!","Remove Diagnosis",JOptionPane.ERROR_MESSAGE);
//						refreshPanel();
//					} catch (Exception e) {
//						e.printStackTrace();
//		               	JOptionPane.showMessageDialog(null, e.getMessage(),"Remove Diagnosis",JOptionPane.ERROR_MESSAGE);
//					}
	            }
			}
		});
	}
	
	void refreshPanel()
	{
		this.removeAll();
		this.populateDiagnoses();
		this.repaint();
	}

	private void addDiagnoses(JComponent diagnosesPanel) {
		JLabel addDiagnosisLabel = new JLabel("Add a diagnosis:");
		diagnosesPanel.add(addDiagnosisLabel);
	    JComboBox<String> diagnosesCombobox = new JComboBox<String>();
	    DiseaseController diseaseController = new DiseaseController();
	    List<Disease> diseaseList = diseaseController.getDiseaseList();
	    for(Disease disease: diseaseList)
	    {
	    	diagnosesCombobox.addItem(disease.getName());
	    }
	    diagnosesPanel.add(diagnosesCombobox);
	    JButton addDiagnosisButton = new JButton("Add Diagnosis");
	    diagnosesPanel.add(addDiagnosisButton);
	    addDiagnosisButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	            {
	                int index = diagnosesCombobox.getSelectedIndex();
	                Disease diseaseToAdd = diseaseList.get(index);
	                DiseaseController controller = new DiseaseController();
	                java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
	                try {
						int count = controller.setDiagnoses(user, diseaseToAdd, date);
						if(count == 1)
							JOptionPane.showMessageDialog(null, "Diagnosis added successfully!","Add Diagnosis",JOptionPane.ERROR_MESSAGE);
						refreshPanel();
					} catch (Exception e) {
						e.printStackTrace();
		               	JOptionPane.showMessageDialog(null, e.getMessage(),"Add Diagnosis",JOptionPane.ERROR_MESSAGE);
					}
	            }
			}
		});
	}
}
