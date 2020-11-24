import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PastryOrder extends JFrame{
	private JComboBox<String> types;
	private JComboBox<String> muffins;
	private JComboBox<String> cookies;
	private JComboBox<String> cheesecakeSlices;
	private JComboBox<String> danishs;
	private JComboBox<String> flavors;
	private JCheckBox heated;
	private JButton saveButton;
	private JButton cancelButton;
	private List<Item> items;
	private JPanel panel;
	/**
	 * 
	 * @param items set to pastry order items
	 * Creates components, sets title to Pastry Order, size, and default close operation for frame
	 */
	public PastryOrder(List<Item> items) {
		this.items = items;
		createComponents();
		
		this.setTitle("Pastry Order");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	/**
	 * Creates labels, buttons, and panel, and added to frame
	 */
	public void createComponents() {
		String[] type = {"Muffin", "Cookie", "Cheesecake", "Danish"};
		this.types = new JComboBox<String>(type);
		String[] muffin = {"Banana Nut", "Blueberry", "Chocolate Chip", "Coffee Cake"};
		this.muffins = new JComboBox<String>(muffin);
		String[] cookie = {"Oatmeal", "Whie Choco & Macadamias", "Chocolate Chip", "Double Fudge"};
		this.cookies = new JComboBox<String>(cookie);
		String[] cheesecakeSlice = {"Regular", "Cherry", "Blueberry"};
		this.cheesecakeSlices = new JComboBox<String>(cheesecakeSlice);
		String[] danish = {"Apple Cinnamon", "Strawberry & Cheese", "Double Cheese"};
		this.danishs = new JComboBox<String>(danish);
		this.flavors = new JComboBox<String>();
		heated = new JCheckBox("heated");
		this.cancelButton = new JButton("Cancel");
		ActionListener pastryListener = new PastryListener();
		this.types.addActionListener(pastryListener);
		ActionListener cancelListener = new CancelButtonListener();
		this.cancelButton.addActionListener(cancelListener);
		this.saveButton = new JButton("Save");
		ActionListener saveListener = new SaveButtonListener();
		this.saveButton.addActionListener(saveListener);
		this.panel = new JPanel();
		this.panel.add(this.types);
		panel.add(this.cancelButton);
		this.add(panel);

	}
	class PastryListener implements ActionListener {
		/**
		 * @param e is used to determine which flavor is set to, then added and repaints frame after
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Component select = (Component) e.getSource();
			String selectedItem = (String)types.getSelectedItem();
			panel.remove(flavors);
			panel.remove(heated);
			panel.remove(saveButton);
			
			if(selectedItem.equals("Muffin")) {
				flavors = muffins;
			}
			
			if(selectedItem.equals("Cookie")) {
				flavors = cookies;
			}
			if(selectedItem.equals("Cheesecake")) {
				flavors = cheesecakeSlices;
			}
			if(selectedItem.equals("Danish")) {
				flavors = danishs;
			}
			panel.add(flavors, 1);
			panel.add(heated,2);
			panel.add(saveButton, 3);
			panel.revalidate();
			panel.repaint();
		}
		
	}
	class SaveButtonListener implements ActionListener {
		/**
		 * @param click saves pastry order then added to NewOrder frame
		 */
		@Override
		public void actionPerformed(ActionEvent click) {
			Component button = (Component) click.getSource();
			JFrame frame = (JFrame) SwingUtilities.getRoot(button);
			String type = (String) types.getSelectedItem();
			String flavor = (String) flavors.getSelectedItem();
			boolean heat = false;
			if(heated.isSelected()) {
				heat = true;
			}
			PastryItem pastry = new PastryItem(type, flavor, heat);
			NewOrder order = new NewOrder();
			items.add(pastry);
			order.addItem(items);
			frame.setVisible(false);
		}
	}
	class CancelButtonListener implements ActionListener {
		/**
		 * @param click returns to frame and sets this frame to false
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
