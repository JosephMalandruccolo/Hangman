package hw3;

import javax.swing.JOptionPane;

/**
 * controller in MVC architecture for a HangmanGame
 * @author josephmalandruccolo
 *
 */
public class HangmanController {
	
	
	//===============================================================================================
	//											CONSTANTS
	//===============================================================================================
	private final String INITIAL_STATUS = "click a letter to make a guess!";	//status displayed in the view before any guess has been made
	private final static String WINNING_HEADER = "Winner!";
	private final static String WINNING_MESSAGE = "Congratulations! You Won!\nPlay again?";
	private final static String LOSING_HEADER = "Mittens lost too!";
	private final static String LOSING_MESSAGE = "So sorry, you lost.\nPlay again?";
	
	
	
	//===============================================================================================
	//											PROPERTIES
	//===============================================================================================
	private static HangmanModel controlModel;
	private static HangmanView controlView;
	
	
	
	//===============================================================================================
	//											CONSTRUCTOR
	//===============================================================================================
	
	public HangmanController(HangmanModel model, HangmanView view){
		controlModel = model;
		controlView = view;
		
		
		//set the view's properties and turn it visible
		updateCurrentWord(model, view);
		updateNumGuesses(model, view);
		updateResultDisplay(INITIAL_STATUS, view);
		updateHangmanImage(model, view);
		
		view.getFrame().setVisible(true);
	}
	
	
	//===============================================================================================
	//											VIEW UPDATE METHODS
	//===============================================================================================
	
	//implement the make guess method
	//the method will necessarily update both the view and the model
	private static void updateCurrentWord(HangmanModel model, HangmanView view){
		
		String strWord = model.getCurrentWord();
		
		char[] cWordChars = strWord.toCharArray();
		char[] cDisplayChars = new char[cWordChars.length * 2 - 1];	//number of characters plus padding
		
		int nLetterCounter = 0;
		for(int nC = 0; nC < cDisplayChars.length; nC++){
			
			if(nC % 2 != 0) cDisplayChars[nC] = ' ';
			else{
				cDisplayChars[nC] = cWordChars[nLetterCounter];
				nLetterCounter++;
			}//end else
		}//end for
		
		view.setCurrentWord(new String(cDisplayChars));
		
	}//updateCurrentWord
	
	
	/**
	 * call the setter method
	 * @param strMessage - the string to display to the user
	 * @param view - the view
	 */
	private static void updateResultDisplay(String strMessage, HangmanView view){view.setStatusUpdate(strMessage);}

	
	
	/**
	 * get the number of guesses from the model and update the view
	 * @param model - hangman game model
	 * @param view - hangman game view
	 */
	private static void updateNumGuesses(HangmanModel model, HangmanView view){
		
		String strNumAsString = "";
		
		strNumAsString += model.getNumGuessesLeft();
		strNumAsString += " guesses left";
		
		view.setNumGuesses(strNumAsString);
		
	}//end updateNumGuesses
	
	
	/**
	 * 
	 * switch on the number of guesses left to determine the image icon
	 * 
	 * @param model - hangman model
	 * @param view - hangman view
	 */
	private static void updateHangmanImage(HangmanModel model, HangmanView view){
		
		if(model.getNumGuessesLeft() > 7){
			
			view.setImageIcon("/hw3/hang7.gif");
			
		}
		else{

			switch(model.getNumGuessesLeft()){
		
			case 7  :   view.setImageIcon("/hw3/hang7.gif");
				break;
			case 6  :   view.setImageIcon("/hw3/hang6.gif");
				break;
			case 5  :   view.setImageIcon("/hw3/hang5.gif");
				break;
			case 4  :   view.setImageIcon("/hw3/hang4.gif");
				break;
			case 3  :   view.setImageIcon("/hw3/hang3.gif");
				break;
			case 2  :   view.setImageIcon("/hw3/hang2.gif");
				break;
			case 1  :   view.setImageIcon("/hw3/hang1.gif");
				break;
			case 0  :   view.setImageIcon("/hw3/hang0.gif");
				break;
				default :   break;
		
			}//end switch
		}//end else
		
	}//end updateHangmanImg
	
	
	//===============================================================================================
	//											HANGMAN METHODS
	//===============================================================================================
	
	/**
	 * given a letter, make a guess
	 * pass the guess to the model
	 * update the view based on results from the model
	 * @param cLetter
	 */
	public static void makeGuess(char cLetter){
		
		//if the game is not a win or loss
		if(!controlModel.isWin() && !controlModel.isLoss()){
			String strResult = controlModel.makeGuess(cLetter);			
			
			updateResultDisplay(strResult, controlView);
			updateCurrentWord(controlModel, controlView);
			updateNumGuesses(controlModel, controlView);
			updateHangmanImage(controlModel, controlView);
	}//end if	
		
		
		//alert if game is win
		if(controlModel.isWin()){
			
			int nUserInput = JOptionPane.showConfirmDialog(null, WINNING_MESSAGE, WINNING_HEADER, JOptionPane.YES_NO_OPTION);
			if(nUserInput == JOptionPane.YES_OPTION){
				
				controlView.getFrame().dispose();
				HangmanMVC.main(null);
				
			}
			else{
				System.exit(0);
			}//end if-else
			
		}//end if
		
		//alert if game is loss
		if(controlModel.isLoss()){
			
			int nUserInput = JOptionPane.showConfirmDialog(null, LOSING_MESSAGE+"\n"+"Secret Word: "+controlModel.getSecretWord(), LOSING_HEADER, JOptionPane.YES_NO_OPTION);
			if(nUserInput == JOptionPane.YES_OPTION){
				
				controlView.getFrame().dispose();
				HangmanMVC.main(null);
				
			}
			else{
				System.exit(0);
			}//end if-else
			
		}//end if
		
		
		//repaint
		controlView.getFrame().repaint();
		
	}//end makeGuess
}//end HangmanController
