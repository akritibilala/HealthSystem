package views;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;

import controller.DiseaseController;
import model.Disease;
import model.HealthSystemUser;

public class DiagnosesPanel extends JPanel {

	private HealthSystemUser user;
	public DiagnosesPanel(HealthSystemUser user) {
		this.user = user;
		populateDiagnoses();
	}
	
	public void populateDiagnoses() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createEmptyBorder(10,22,0,0));
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel diseasesLabel = new JLabel("Diseases:");
		diseasesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(diseasesLabel);
		
		DiseaseController controller = new DiseaseController();
		List<Disease> diseases = controller.getDiagnoses(user);
		if(diseases.size() > 0)
		{
			for(Disease disease : diseases)
			{
				JLabel diseaseLabel = new JLabel(disease.getName());
				diseasesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
				diseaseLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
				this.add(diseaseLabel);
			}	
		}
		else
		{
			JLabel diseaseLabel = new JLabel("No diseases! :)");
			this.add(diseaseLabel);
		}
//		
		//Add a Diagnosis
		JComponent horizontalPanel1 = new JPanel();
		horizontalPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		horizontalPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		addDiagnoses(horizontalPanel1);
		this.add(horizontalPanel1);
		
		
		//Delete a Diagnosis
		JComponent horizontalPanel2 = new JPanel();
		horizontalPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		horizontalPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		deleteDiagnoses(horizontalPanel2);
		this.add(horizontalPanel2);
	}

	private void deleteDiagnoses(JComponent diagnosesPanel) {
		JLabel addDiagnosisLabel = new JLabel("Remove diagnosis:");
		diagnosesPanel.add(addDiagnosisLabel);
	    JComboBox<String> diagnosesCombobox = new JComboBox<String>();
	    DiseaseController userController = new DiseaseController();
	    List<Disease> diseaseList = userController.getDiagnoses(user);
	    for(Disease disease: diseaseList)
	    {
	    	diagnosesCombobox.addItem(disease.getName());
	    }
	    diagnosesPanel.add(diagnosesCombobox);
	    JButton removeDiagnosisButton = new JButton("Remove Diagnosis");
	    diagnosesPanel.add(removeDiagnosisButton);
	    removeDiagnosisButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	            {
	                int index = diagnosesCombobox.getSelectedIndex();
	                Disease diseaseToAdd = diseaseList.get(index);
	                DiseaseController controller = new DiseaseController();
	                try {
						int count = controller.deleteDiagnoses(user, diseaseToAdd);
						if(count == 1)
							JOptionPane.showMessageDialog(null, "Diagnosis removed successfully!","Remove Diagnosis",JOptionPane.ERROR_MESSAGE);
						refreshPanel();
					} catch (Exception e) {
						e.printStackTrace();
		               	JOptionPane.showMessageDialog(null, e.getMessage(),"Remove Diagnosis",JOptionPane.ERROR_MESSAGE);
					}
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
