package hw3;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Panel;
import java.awt.Button;
import java.awt.Font;

/**
 * not yet used
 * to be implemented in later versions
 * this would allow the user to specify the number of guesses, which adjusts the difficulty of the game
 * @author josephmalandruccolo
 *
 */
public class HangmanInitialWindow {
	
	
	
	//===============================================================================================
	//											CONSTANTS
	//===============================================================================================
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	private static final int CHAR_CODE_E = 69;
	
	

	private JFrame frame;

	
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangmanInitialWindow window = new HangmanInitialWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	//===============================================================================================
	//											CONSTRUCTORS
	//===============================================================================================

	/**
	 * Create the application.
	 */
	public HangmanInitialWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel promptPanel = new JPanel();
		frame.getContentPane().add(promptPanel, BorderLayout.NORTH);
		promptPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblWelcomeToHangman = new JLabel("Welcome to Hangman by Joseph Malandruccolo");
		lblWelcomeToHangman.setFont(new Font("Yuppy SC", Font.BOLD, 17));
		lblWelcomeToHangman.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToHangman.setVerticalAlignment(SwingConstants.TOP);
		promptPanel.add(lblWelcomeToHangman);
		
		JLabel label = new JLabel("");
		promptPanel.add(label);
		
		JLabel lblNewLabel = new JLabel("Select the number of guesses you would like or EXIT to quit!");
		lblNewLabel.setFont(new Font("Yuppy SC", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		promptPanel.add(lblNewLabel);
		
		JPanel choosePanel = new JPanel();
		frame.getContentPane().add(choosePanel, BorderLayout.CENTER);
		
		final JComboBox comboBox = new JComboBox();
		choosePanel.add(comboBox);
		comboBox.addItem("7 - recommended");
		comboBox.addItem("EXIT");
		comboBox.addItem("1");
		comboBox.addItem("2");
		comboBox.addItem("3");
		comboBox.addItem("4 - hard");
		comboBox.addItem("5");
		comboBox.addItem("6");
		comboBox.addItem("7 - recommended");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12 - easy");
		comboBox.addItem("13");
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		Button button = new Button("Go!");
		button.setFont(new Font("Yuppy SC", Font.BOLD, 26));
		panel.add(button);
		
		
		frame.setVisible(true);
		
	}

}
