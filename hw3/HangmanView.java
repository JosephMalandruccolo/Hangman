package hw3;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;

/**
 * GUI for a Hangman Game
 * @author josephmalandruccolo
 *
 */
public class HangmanView {

	
	
	
	
	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================
	
	private static JFrame frame;			//the JFrame
	private static int nScreenWidth;		//user's screen width
	private static int nScreenHeight;		//user's screen height
	private static int nFrameWidth;			//application width
	private static int nFrameHeight;		//application height
	private static JPanel panImg;			//JPanel holding the image
	private static JLabel lblToHoldCurrent;	//placeholder of the current word
	private static JLabel lblNumguesses;	//number of guesses remaining
	private static JLabel lblStatusUpdate;	//last status
	private static JLabel lblImage;			//image icon
	
	
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================
	/**
	 * default constructor
	 */
	public HangmanView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//===============================================================================================
		//											FRAME
		//===============================================================================================
		
		setFrame(new JFrame());
		getFrame().setTitle("Hangman by Joseph Malandruccolo");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		nScreenWidth = screenSize.width;
		nScreenHeight = screenSize.height;
		nFrameWidth = nScreenWidth / 2;	//set the frame to half the width
		nFrameHeight = 3 * nScreenHeight / 4;	//set the frame to 3/4 the height
		getFrame().setSize(nFrameWidth, nFrameHeight);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//===============================================================================================
		//											NORTH JPANEL - HOLDS CURRENT WORD
		//===============================================================================================
		
		JPanel panCurrentWord = new JPanel();
		getFrame().getContentPane().add(panCurrentWord, BorderLayout.NORTH);
		
		lblToHoldCurrent = new JLabel("To hold current word");
		lblToHoldCurrent.setFont(new Font("American Typewriter", Font.BOLD, 42));
		panCurrentWord.add(lblToHoldCurrent);
		
		
		//===============================================================================================
		//											CENTER JPANEL - HOLDS HANGMAN IMAGE
		//===============================================================================================
		
		panImg = new JPanel();
		getFrame().getContentPane().add(panImg, BorderLayout.CENTER);
		panImg.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblImage = new JLabel();
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon(HangmanView.class.getResource("/hw3/hang7.gif")));
		panImg.add(lblImage);
		
		

		
		//===============================================================================================
		//											SOUTH JPANEL - HOLDS USER INPUTS
		//===============================================================================================
		
		JPanel panInputs = new JPanel();
		getFrame().getContentPane().add(panInputs, BorderLayout.SOUTH);
		Dimension panInputsDimension = new Dimension(nFrameWidth, nFrameHeight / 3);
		panInputs.setPreferredSize(panInputsDimension);
		
		Dimension btnDimension = new Dimension(nFrameWidth / 11, nFrameWidth / 11);
		panInputs.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnA.setPreferredSize(btnDimension);
		btnA.addActionListener(new HangmanBtnListener());
		panInputs.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnB.setPreferredSize(btnDimension);
		btnB.addActionListener(new HangmanBtnListener());
		panInputs.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnC.setPreferredSize(btnDimension);
		btnC.addActionListener(new HangmanBtnListener());
		panInputs.add(btnC);
		
		JButton btnD = new JButton("D");
		btnD.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnD.setPreferredSize(btnDimension);
		btnD.addActionListener(new HangmanBtnListener());
		panInputs.add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnE.setPreferredSize(btnDimension);
		btnE.addActionListener(new HangmanBtnListener());
		panInputs.add(btnE);
		
		JButton btnF = new JButton("F");
		btnF.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnF.setPreferredSize(btnDimension);
		btnF.addActionListener(new HangmanBtnListener());
		panInputs.add(btnF);
		
		JButton btnG = new JButton("G");
		btnG.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnG.setPreferredSize(btnDimension);
		btnG.addActionListener(new HangmanBtnListener());
		panInputs.add(btnG);
		
		JButton btnH = new JButton("H");
		btnH.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnH.setPreferredSize(btnDimension);
		btnH.addActionListener(new HangmanBtnListener());
		panInputs.add(btnH);
		
		JButton btnI = new JButton("I");
		btnI.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnI.setPreferredSize(btnDimension);
		btnI.addActionListener(new HangmanBtnListener());
		panInputs.add(btnI);
		
		JButton btnJ = new JButton("J");
		btnJ.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnJ.setPreferredSize(btnDimension);
		btnJ.addActionListener(new HangmanBtnListener());
		panInputs.add(btnJ);
		
		JButton btnK = new JButton("K");
		btnK.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnK.setPreferredSize(btnDimension);
		btnK.addActionListener(new HangmanBtnListener());
		panInputs.add(btnK);
		
		JButton btnL = new JButton("L");
		btnL.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnL.setPreferredSize(btnDimension);
		btnL.addActionListener(new HangmanBtnListener());
		panInputs.add(btnL);
		
		JButton btnM = new JButton("M");
		btnM.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnM.setPreferredSize(btnDimension);
		btnM.addActionListener(new HangmanBtnListener());
		panInputs.add(btnM);
		
		JButton btnN = new JButton("N");
		btnN.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnN.setPreferredSize(btnDimension);
		btnN.addActionListener(new HangmanBtnListener());
		panInputs.add(btnN);
		
		JButton btnO = new JButton("O");
		btnO.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnO.setPreferredSize(btnDimension);
		btnO.addActionListener(new HangmanBtnListener());
		panInputs.add(btnO);
		
		JButton btnP = new JButton("P");
		btnP.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnP.setPreferredSize(btnDimension);
		btnP.addActionListener(new HangmanBtnListener());
		panInputs.add(btnP);
		
		JButton btnQ = new JButton("Q");
		btnQ.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnQ.setPreferredSize(btnDimension);
		btnQ.addActionListener(new HangmanBtnListener());
		panInputs.add(btnQ);
		
		JButton btnR = new JButton("R");
		btnR.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnR.setPreferredSize(btnDimension);
		btnR.addActionListener(new HangmanBtnListener());
		panInputs.add(btnR);
		
		JButton btnS = new JButton("S");
		btnS.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnS.setPreferredSize(btnDimension);
		btnS.addActionListener(new HangmanBtnListener());
		panInputs.add(btnS);
		
		JButton btnT = new JButton("T");
		btnT.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnT.setPreferredSize(btnDimension);
		btnT.addActionListener(new HangmanBtnListener());
		panInputs.add(btnT);
		
		JButton btnU = new JButton("U");
		btnU.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnU.setPreferredSize(btnDimension);
		btnU.addActionListener(new HangmanBtnListener());
		panInputs.add(btnU);
		
		JButton btnV = new JButton("V");
		btnV.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnV.setPreferredSize(btnDimension);
		btnV.addActionListener(new HangmanBtnListener());
		panInputs.add(btnV);
		
		JButton btnW = new JButton("W");
		btnW.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnW.setPreferredSize(btnDimension);
		btnW.addActionListener(new HangmanBtnListener());
		panInputs.add(btnW);
		
		JButton btnX = new JButton("X");
		btnX.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnX.setPreferredSize(btnDimension);
		btnX.addActionListener(new HangmanBtnListener());
		panInputs.add(btnX);
		
		JButton btnY = new JButton("Y");
		btnY.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnY.setPreferredSize(btnDimension);
		btnY.addActionListener(new HangmanBtnListener());
		panInputs.add(btnY);
		
		JButton btnZ = new JButton("Z");
		btnZ.setFont(new Font("Handwriting - Dakota", Font.BOLD, 24));
		btnZ.setPreferredSize(btnDimension);
		btnZ.addActionListener(new HangmanBtnListener());
		panInputs.add(btnZ);
		
		JPanel panStatus = new JPanel();
		frame.getContentPane().add(panStatus, BorderLayout.EAST);
		panStatus.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNumguesses = new JLabel("numGuesses");
		lblNumguesses.setFont(new Font("Lucida Console", Font.PLAIN, 18));
		panStatus.add(lblNumguesses);
		
		lblStatusUpdate = new JLabel("status update");
		panStatus.add(lblStatusUpdate);
		
		
	}//end initialize

	
	//===============================================================================================
	//											GETTERS AND SETTERS
	//===============================================================================================
	
	public JFrame getFrame() {return frame;}

	public void setFrame(JFrame newFrame) {frame = newFrame;}
	
	
	/**
	 * updates the current word at the top of the GUI
	 * @param word
	 */
	public void setCurrentWord(String word){lblToHoldCurrent.setText(word);}
	
	/**
	 * update the number of guesses on the right side of the GUI
	 * @param str
	 */
	public void setNumGuesses(String str){lblNumguesses.setText(str);}
	
	/**
	 * updates the message on the right side of the GUI
	 * @param str - message
	 */
	public void setStatusUpdate(String str){lblStatusUpdate.setText(str);}
	
	/**
	 * updates the icon image in the CENTER panel
	 * @param strFileName - relative path to the new file
	 */
	public void setImageIcon(String strFileName){
		lblImage.setIcon(new ImageIcon(HangmanView.class.getResource(strFileName)));
		frame.repaint();
	}//end setImageIcon

}//end HangmanView
