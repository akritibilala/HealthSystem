package views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DiseaseController;
import model.Disease;
import java.awt.GridLayout;

public class DiagnosisPanel extends JFrame {

	private JPanel contentPane;
	List<Disease> currentDiseaseList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiagnosisPanel frame = new DiagnosisPanel();
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
	public DiagnosisPanel() {
		setBounds(100, 100, 450, 300);
		populateDiagnosis();
		
	}
	
	private void populateDiagnosis() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10,22,0,0));
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel diseasesLabel = new JLabel("Diseases:");
		diseasesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.add(diseasesLabel);
		
		DiseaseController controller = new DiseaseController();
		currentDiseaseList = controller.getDiagnoses(Main.currentUser);
		if(currentDiseaseList .size() > 0)
		{
			for(Disease disease : currentDiseaseList)
			{
				JLabel diseaseLabel = new JLabel(disease.getName());
				diseasesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
				diseaseLabel.setBorder(BorderFactory.createEmptyBorder(0,40,0,0));
				contentPane.add(diseaseLabel);
			}	
		}
		else
		{
			JLabel diseaseLabel = new JLabel("No diseases! :)");
			contentPane.add(diseaseLabel);
		}
		
		//Add a Diagnosis
		JComponent horizontalPanel1 = new JPanel();
		horizontalPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		horizontalPanel1.setAlignmentX(Component.LEFT_ALIGNMENT);
		addDiagnoses(horizontalPanel1);
		contentPane.add(horizontalPanel1);
		
		
		//Delete a Diagnosis
		JComponent horizontalPanel2 = new JPanel();
		horizontalPanel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		horizontalPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
		deleteDiagnoses(horizontalPanel2);
		contentPane.add(horizontalPanel2);
		
		JLabel label = new JLabel("");
		contentPane.add(label);
	}
	
	void refreshPanel()
	{
		getContentPane().removeAll();
//		setContentPane(contentPane);
		populateDiagnosis();
		getContentPane().invalidate();
		getContentPane().repaint();
	}

	private void deleteDiagnoses(JComponent diagnosesPanel) {
		JLabel addDiagnosisLabel = new JLabel("Remove diagnosis:");
		diagnosesPanel.add(addDiagnosisLabel);
	    JComboBox<String> diagnosesCombobox = new JComboBox<String>();
	    for(Disease disease: currentDiseaseList)
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
	                Disease diseaseToAdd = currentDiseaseList.get(index);
	                DiseaseController controller = new DiseaseController();
	                try {
						int count = controller.deleteDiagnoses(Main.currentUser, diseaseToAdd);
						if(count == 1)
							JOptionPane.showMessageDialog(null, "Diagnosis removed successfully!","Remove Diagnosis",JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null, "Error in removing diagnosis!","Remove Diagnosis",JOptionPane.ERROR_MESSAGE);
							refreshPanel();
					} catch (Exception e) {
						e.printStackTrace();
		               	JOptionPane.showMessageDialog(null, e.getMessage(),"Remove Diagnosis",JOptionPane.ERROR_MESSAGE);
					}
	            }
			}
		});
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
						int count = controller.setDiagnoses(Main.currentUser, diseaseToAdd, date);
						if(count == 1)
							JOptionPane.showMessageDialog(null, "Diagnosis added successfully!","Add Diagnosis",JOptionPane.INFORMATION_MESSAGE);
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
