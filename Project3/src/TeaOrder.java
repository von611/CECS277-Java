import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TeaOrder extends NewOrder {
	private JLabel instructions;
	private JComboBox flavors;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sugar;
	private JComboBox<String> baseOptions;
	private JComboBox<String> types;
	private JCheckBox boba;
	private JCheckBox popping;
	private JCheckBox grassJelly;
	private JCheckBox lycheeJelly;
	private JCheckBox coconutJelly;
	private JCheckBox miniMochi;
	private JButton save;
	private JButton cancel;
	private JTextField specialinstructions;
	private JTextArea area;
	private JFrame orderFrame;
	private List<Item> items;
	private TeaItem tea;
	/**
	 * 
	 * @param items set to this TeaOrder's items list
	 * calls createComponents to create the components, set title to New Tea Order, size, and default close operation
	 */
	public TeaOrder(List<Item> items) {
		// create components
		this.items = items;
		createComponents();
		// set frame properties
		this.setTitle("New Tea Order");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	/**
	 * Creates labels, buttons, check boxes, text field and added to a panel, then added to frame
	 */
	private void createComponents() {
		// instantiate the components
		this.instructions = new JLabel("Specify the tea order: ");
		String[] flavors = { "green tea", "black tea", "jasmine green tea", "rose tea", "oolong tea"};
		this.flavors = new JComboBox<String>(flavors);
		
		String[] sizes = { "S", "M", "L" };
		this.sizeOptions = new JComboBox<String>(sizes);

		String[] tsp = { "full", "3/4 sweet", "1/2 sweet", "1/4 sweet", "unsweetned"};
		this.sugar = new JComboBox<String>(tsp);

		String[] bases = { "whole milk", "half-and-half", "no milk" };
		this.baseOptions = new JComboBox<String>(bases);

		this.boba = new JCheckBox("boba");
		this.popping = new JCheckBox("popping boba");
		this.grassJelly = new JCheckBox("grass jelly");
		this.lycheeJelly = new JCheckBox("lychee jelly");
		this.coconutJelly = new JCheckBox("coconut jelly");
		this.miniMochi = new JCheckBox("mini mochi");
		
		this.specialinstructions = new JTextField(45);
		this.save = new JButton("Save");
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
		panel.add(this.flavors);
		panel.add(new JLabel("sizes: "));
		panel.add(this.sizeOptions);
		panel.add(new JLabel("sweetness: "));
		panel.add(this.sugar);
		panel.add(new JLabel("milk: "));
		panel.add(this.baseOptions);
		panel.add(this.save);
		panel.add(this.cancel);
		panel.add(this.boba);
		panel.add(this.popping);
		panel.add(this.grassJelly);
		panel.add(this.lycheeJelly);
		panel.add(this.coconutJelly);
		panel.add(this.miniMochi);
		
		this.add(panel);

	}

	private class SaveButtonListener implements ActionListener {
		/**
		 * @param click gets the selected items to create a Tea Item object and added to New Order frame
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
			String instructions = specialinstructions.getText().toString();
			tea = new TeaItem(sizeValue, flavor, sugarValue, milkValue);
			if(boba.isSelected()) {
				tea.addTopping("boba");
			}
			if(popping.isSelected()) {
				tea.addTopping("popping");
			}
			if(grassJelly.isSelected()) {
				tea.addTopping("grass jelly");
			}
			if(lycheeJelly.isSelected()) {
				tea.addTopping("lychee jelly");
			}
			if(coconutJelly.isSelected()) {
				tea.addTopping("coconut jelly");
			}
			if(miniMochi.isSelected()) {
				tea.addTopping("mini mochi");
			}
			items.add(tea);
			order.addItem(items);
			frame.setVisible(false);

		}
	}

	class CancelButtonListener implements ActionListener {
		/**
		 * @param click returns to NewOrder frame
		 */
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
