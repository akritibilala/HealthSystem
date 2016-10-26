package views;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.UserController;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		
		UserController controller = new UserController();
		recoMap = controller.getRecommendations(Main.currentUser);
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
//			JTable table = new JTable(rowData, columnNames);
//			this.add(new JScrollPane(table));
			table = new JTable(rowData,columnNames);
		}
		else
		{
			JLabel hsLabel = new JLabel("No health indicators found! :)");
			getContentPane().add(hsLabel);
		}
		
		scrollPane.setViewportView(table);
		
//		populateHealthIndicators();
	}
	
	Map<Observation,Recommendation> recoMap = new HashMap<Observation,Recommendation>();
	private JTable table;

	private void populateHealthIndicators() {
		UserController controller = new UserController();
		recoMap = controller.getRecommendations(Main.currentUser);
		
		DefaultTableModel model = new DefaultTableModel();
	}

}
