import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CoffeeOrder extends NewOrder {
	private JLabel instructions;
	private JComboBox flavors;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sugar;
	private JComboBox<String> baseOptions;
	private JComboBox<String> types;
	private JButton save;
	private JButton cancel;
	private JTextField specialinstructions;
	private CoffeeItem coffee;
	private JTextArea area;
	private JFrame orderFrame;
	private List<Item> items;
	/**
	 * 
	 * @param items set to this items list, calls the createComponents, sets title, size, and default close operation
	 */
	public CoffeeOrder(List<Item> items) {
		// create components
		this.items = items;
		createComponents();
		// set frame properties
		this.setTitle("New Coffee Order");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	/**
	 * Creates the components; labels, combo box, text field, and added to panel, then added to the frame
	 */
	private void createComponents() {
		this.instructions = new JLabel("Specify the coffee order: ");
		String[] flavors = { "Regular", "Mocha", "Hazelnut", "Vanilla" };
		this.flavors = new JComboBox<String>(flavors);
		
		String[] sizes = { "S", "M", "L" };
		this.sizeOptions = new JComboBox<String>(sizes);

		String[] tsp = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		this.sugar = new JComboBox<String>(tsp);

		String[] bases = { "whole milk", "half-and-half", "no milk" };
		this.baseOptions = new JComboBox<String>(bases);

		String[] types = { "Hot", "Iced", "Blended" };
		this.types = new JComboBox<String>(types);

		this.specialinstructions = new JTextField(45);
		this.save = new JButton("Save Order");
		this.cancel = new JButton("Cancel");
		// creating the savelistener
		ActionListener saveListener = new SaveButtonListener();
		ActionListener cancelListener = new CancelButtonListener();
		// saving the savelistener
		this.save.addActionListener(saveListener);
		this.cancel.addActionListener(cancelListener);
		// Create the panel and add components
		JPanel panel = new JPanel();
		panel.add(this.instructions);
		panel.add(new JLabel("flavors: "));
		panel.add(this.flavors);
		panel.add(new JLabel("sizes: "));
		panel.add(this.sizeOptions);
		panel.add(new JLabel("sugars: "));
		panel.add(this.sugar);
		panel.add(new JLabel("milk: "));
		panel.add(this.baseOptions);
		panel.add(new JLabel("types"));
		panel.add(this.types);
		panel.add(new JLabel("special instructions: "));
		panel.add(this.specialinstructions);
		panel.add(this.save);
		panel.add(this.cancel);

		this.add(panel);

	}

	private class SaveButtonListener implements ActionListener {
		/**
		 * @param click gets the selected items and creates a CoffeeItem then added to the NewOrder frame
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method stub
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			NewOrder order = new NewOrder();
			String flavor = flavors.getSelectedItem().toString();
			String sizeValue = sizeOptions.getSelectedItem().toString();
			String sugarValue = sugar.getSelectedItem().toString();
			String milkValue = baseOptions.getSelectedItem().toString();
			String typeValue = types.getSelectedItem().toString();
			String instructions = specialinstructions.getText().toString();
			coffee = new CoffeeItem(sizeValue, flavor, sugarValue, milkValue, typeValue, instructions);
			items.add(coffee);		
			order.addItem(items);
			
			frame.setVisible(false);

		}
	}

	class CancelButtonListener implements ActionListener {
		/**
		 * @param click returns back to NewOrder frame
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method stub
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			NewOrder order = new NewOrder();
			order.addItem(items);
			frame.setVisible(false);
		}

	}
}
