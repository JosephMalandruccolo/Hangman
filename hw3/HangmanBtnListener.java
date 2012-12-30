package hw3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * class that listens for one the A-Z buttons to be pressed in the HangmanView
 * changes the background color of the button to black
 * passes the value pressed to the makeGuess method of the controller
 * @author josephmalandruccolo
 *
 */
public class HangmanBtnListener implements ActionListener {


	@Override
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		JButton btnPressed = (JButton) e.getSource();
		
		Color clrPressed = new Color(0, 0, 0);
		btnPressed.setBackground(clrPressed);
		btnPressed.setForeground(clrPressed);
		btnPressed.repaint();
		
		String strBtnLbl = btnPressed.getText();
		
		HangmanController.makeGuess(strBtnLbl.charAt(0));
		
	}//end actionPerformed
}//end HangmanBtnListnener
