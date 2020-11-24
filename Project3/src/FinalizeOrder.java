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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class FinalizeOrder extends JFrame{
	private JButton payButton;
	private JButton exitButton;
	private JLabel amountDue;
	private JPanel panel;
	private JTextArea area;
	private List<Item> items;
	private JScrollPane scrollPane;
	private JTextField paymentText;
	private JLabel remainder;
	private JLabel payment;
	private double total;
	private double amount;
	private double sum;
	private double tax;
	private double due;
	private String ItemList;
	/**
	 * 
	 * @param items set to items list, calculates cost and calls the createComponents, and set title, size, and default close operation
	 */
	public FinalizeOrder(List<Item> items) {
		this.items = items;
		sum = 0;
		ItemList = "";
		for(Item item : items) {
			ItemList += item.toString() + "\n";
			sum += item.calculateCost();
		}

		tax = sum * 0.10;
		total = sum + tax;
		due = total;
		// call private helper method to create and add components
		createComponents();
		
		// set the frame properties
		this.setTitle("Finalize Order");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	/**
	 * Creates the components; text area, scroll pane, text field, buttons, and added to panel then to frame
	 */
	private void createComponents() {
		// instantiate the components
		this.panel = new JPanel();
		// create panel and add components
		this.exitButton = new JButton("Exit");
		ActionListener exitListener = new ExitButtonListener();
		this.exitButton.addActionListener(exitListener);
		this.area = new JTextArea(20, 40);
		this.setSize(500, 500);
		this.area.setText("	~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~\n" + ItemList + String.format("\n	Subtotal:		$%.2f", sum) + String.format("\n	Tax:		$%.2f", tax) + String.format("\n	Grand Total:		$%.2f", total));
		this.scrollPane = new JScrollPane(this.area);
		this.payButton = new JButton("Pay");
		this.paymentText = new JTextField(20);
		ActionListener payListener = new PayButtonListener();
		this.payButton.addActionListener(payListener);
		this.amountDue = new JLabel(String.format("Amount Due: $%.2f", total));
		this.remainder = new JLabel(String.format("Insufficient payment! Amount still due: $%.2f" ,total));
		this.payment = new JLabel("Payment: $");
		if(this.items.isEmpty()) {
			remainder = new JLabel("Thank you!");
			panel.add(this.remainder);			
			panel.add(exitButton);
		} else {
			panel.add(this.amountDue);
			panel.add(this.scrollPane);
			panel.add(payment);
			panel.add(this.paymentText);
			panel.add(this.payButton);
		}
		// add the panel 
		this.add(panel);
	}

	class PayButtonListener implements ActionListener {
		/**
		 * @param click gets text from text field to be calculated for the final pay then updates the frame
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method stub
			amount = Double.parseDouble(paymentText.getText());
			panel.remove(remainder);
			panel.remove(amountDue);
			due -= amount;

			if(due > 0) {
				remainder = new JLabel(String.format("Insufficient payment! Amount still due: $%.2f" ,due));
			}
			if(due <= 0) {
				double change = 0.00;
				if(due < 0) {
					change = due * (-1);
				}
				remainder = new JLabel("Thank you!");
				area.setText("	~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~\n" + ItemList + String.format("\n	Subtotal:		$%.2f", sum) + String.format("\n	Tax:		$%.2f", tax) + String.format("\n	Grand Total:		$%.2f", total) + String.format("\n	Payment:		$%.2f", amount)  + String.format("\n	Change Due:		$%.2f", change) + "\n	~~~~~~~~~~~~~~~THANK YOU!~~~~~~~~~~~~~~~");
				scrollPane = new JScrollPane(area);
				panel.add(scrollPane);
				panel.add(exitButton);
				panel.remove(paymentText);
				panel.remove(payButton);
				panel.remove(payment);
			}
			panel.add(remainder, 0);
			panel.revalidate();
			panel.repaint();

		}
	}
	class ExitButtonListener implements ActionListener {
		/**
		 * @param click closes the frame
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			// TODO Auto-generated method stub
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			frame.setVisible(false);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
	}
	
}
