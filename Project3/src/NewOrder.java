import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class NewOrder extends JFrame{
	private JLabel instructions;
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JButton doneButton;
	private JPanel panel;
	private JTextArea area;
	private List<Item> items;
	private JScrollPane scrollPane;
	/**
	 * Creates New Order frame, calls createComponents to create components, sets title to New Order, size, and default close operation to hide
	 */
	public NewOrder() {
		// call private helper method to create and add components
		createComponents();
		
		// set the frame properties
		this.setTitle("New Order");
		this.setSize(500, 300);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	/**
	 * Initializes items list, creates labels, buttons, and added to panel then to frame
	 */
	private void createComponents() {
		// instantiate the components
		this.items = new ArrayList<Item>();
		this.instructions = new JLabel("Select an item to purchase: ");
		this.coffeeButton = new JButton("Coffee");
		this.teaButton = new JButton("Tea");
		this.pastryButton = new JButton("Pastry");
		this.doneButton = new JButton("Done");

		ActionListener coffeeListener = new CoffeeButtonListener();
		this.coffeeButton.addActionListener(coffeeListener);
		ActionListener teaListener = new TeaButtonListener();
		this.teaButton.addActionListener(teaListener);
		ActionListener pastryListener = new PastryButtonListener();
		this.pastryButton.addActionListener(pastryListener);
		ActionListener doneListener = new DoneListener();
		this.doneButton.addActionListener(doneListener);
		// create panel and add components
		this.panel = new JPanel();
		panel.add(this.instructions);
		panel.add(this.coffeeButton);
		panel.add(this.teaButton);
		panel.add(this.pastryButton);

		// add the panel 
		this.add(panel);
	}
	/**
	 * 
	 * @param items sets list items to use for listing, then calls updateData if it is not empty, then sets this frame to true
	 */
	void addItem(List<Item> items) {
		this.items = items;
		if(!items.isEmpty()) {
			updateData();
		}
		panel.add(this.doneButton);
		this.setVisible(true);
	}
	/**
	 * removes the components in the panel, calculates total cost, and updates the frame
	 */
	void updateData() {
		panel.removeAll();
		double sum = 0;

		String ItemList = "";
		for(Item item : items) {
			ItemList += item.toString() + "\n";
			sum += item.calculateCost();
		}

		double tax = sum * 0.10;
		double total = sum + tax;
		this.area = new JTextArea(20, 40);
		this.instructions = new JLabel("Select an item to purchase: ");
		this.coffeeButton = new JButton("Coffee");
		this.teaButton = new JButton("Tea");
		this.pastryButton = new JButton("Pastry");
		//this.doneButton = new JButton("Done");
		
		ActionListener coffeeListener = new CoffeeButtonListener();
		this.coffeeButton.addActionListener(coffeeListener);
		ActionListener teaListener = new TeaButtonListener();
		this.teaButton.addActionListener(teaListener);
		ActionListener pastryListener = new PastryButtonListener();
		this.pastryButton.addActionListener(pastryListener);

		
		this.setSize(500, 500);
		this.area.setText("	~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~\n" + ItemList + String.format("\n	Subtotal:		$%.2f", sum) + String.format("\n	Tax:		$%.2f", tax) + String.format("\n	Grand Total:		$%.2f", total));
		this.scrollPane = new JScrollPane(this.area);
		panel.add(this.instructions);
		panel.add(this.coffeeButton);
		panel.add(this.teaButton);
		panel.add(this.pastryButton);
		panel.add(this.scrollPane);

	}
	class CoffeeButtonListener implements ActionListener {
		/**
		 * @param click creates CoffeeOrder frame with this items list as its parameter, then sets it to true, and this frame to false
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method 
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			CoffeeOrder coffee = new CoffeeOrder(items);
			coffee.setVisible(true);
			frame.setVisible(false);

		}
	}
	class TeaButtonListener implements ActionListener {
		/**
		 * @param click creates TeaOrder frame with this items list as its parameter, and sets it visibility to true and frame to false
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method 
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			TeaOrder tea = new TeaOrder(items);
			tea.setVisible(true);
			frame.setVisible(false);
		}
	}
	class PastryButtonListener implements ActionListener {
		/**
		 * @param click creates PastryOrder frame with this items list as its parameter, and sets it visibility to true and frame to false
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method 
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			PastryOrder pastry = new PastryOrder(items);
			pastry.setVisible(true);
			frame.setVisible(false);
		}
	}
	class DoneListener implements ActionListener {
		/**
		 * @param click creates FinalizeOrder frame with this items list as its parameter, and sets it visibility to true and frame to false
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method stub
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			FinalizeOrder finalize = new FinalizeOrder(items);
			finalize.setVisible(true);
			frame.setVisible(false);
		}
	}
	
}
