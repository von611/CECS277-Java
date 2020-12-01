package SystemMain;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import Rooms.Room;

public class FinalFrame extends JFrame{
	private Reservation reserve;
	Border raisedbevel = BorderFactory.createRaisedBevelBorder(); 
 	Border loweredbevel = BorderFactory.createLoweredBevelBorder();
	public FinalFrame(Reservation reserve) {
		this.reserve = reserve;
		this.setTitle("Final Frame");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //makes window screen size
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponents();
		this.setVisible(true);
	}
	public void createComponents() {
		 JPanel panel = new JPanel();
		 JTextArea desc = new JTextArea(15, 15);
		 JLabel type = new JLabel("INFORMATION");

		 desc.append(reserve.toString());
		 desc.setEditable(false);
		 desc.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
		 desc.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		 type.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		 type.setFont(new Font(Font.SERIF, Font.BOLD, 20));

		 panel.add(type);
		 panel.add(desc);

		 this.add(panel);
	}
}
