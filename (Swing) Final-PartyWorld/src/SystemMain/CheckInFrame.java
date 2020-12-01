package SystemMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;





public class CheckInFrame extends JFrame{
	
	private JButton cancelButton = new JButton("Cancel");
	private JButton checkInButton = new JButton("Check-In");
	private JPanel panel;
	private JList<String> guests;
	private JLabel instructions;
	
	private static final int FRAMEWIDTH = 850;
	private static final int FRAMEHEIGHT = 400;
	
	private ArrayList<Guest> checkIn;
	private ArrayList<Guest> checkOut;
	
	public CheckInFrame(ArrayList<Guest> checkIn, ArrayList<Guest> checkOut) {
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.createComponents();
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setTitle("Check-In");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void createComponents() {
		
		instructions = new JLabel("Check-In Guests");
		String checkInGuest[] = new String[checkIn.size()];
		System.out.println(checkIn.size());
		for (int i = 0; i < checkIn.size(); i++) {
			
			checkInGuest[i] = checkIn.get(i).getName();
		}
		
		guests = new JList<String>(checkInGuest);
		
		ActionListener cancelListener = new CancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		
		ActionListener checkInListener = new CheckInButtonListener();
	    checkInButton.addActionListener(checkInListener);
		
		panel = new JPanel();
		panel.add(instructions);
		panel.add(guests);
		panel.add(checkInButton);
		panel.add(cancelButton);
		
		this.add(panel);
	}
	
	 /**
		 * a class that implements action listener on the cancel button listener
		 * **/
	    class CancelButtonListener implements ActionListener {
			
	    	/**
			 *checks to see if the cancel button was clicked on the GUI
			 *@param click- an action event that checks if the button was clicked
			 * **/
			public void actionPerformed(ActionEvent click) {
				
				setVisible(false);
				
			}
		}
	    class CheckInButtonListener implements ActionListener {
	    	
	    	public void actionPerformed(ActionEvent click) {
	    		
	    		
	    		int index = guests.getSelectedIndex();
	    		checkOut.add(checkIn.get(index));
	    		checkIn.remove(index);
	    		
	    		setVisible(false);
	    		
	    	}
	    }
	    

}