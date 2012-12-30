package hw3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * class with the main method of the Hangman game
 * @author josephmalandruccolo
 *
 */
public class HangmanMVC {
	
	
	//===============================================================================================
	//											CONSTANTS
	//===============================================================================================
		
	private static final int UNICODE_CAPITAL_LETTER_LOWER_BOUND = 65;
	private static final int UNICODE_CAPITAL_LETTER_UPPER_BOUND = 90;
	private static final int UNICODE_LOWERCASE_LETTER_LOWER_BOUND = 97;
	private static final int UNICODE_LOWERCASE_LETTER_UPPER_BOUND = 122;
	private static final int DEFAULT_NUM_GUESSES = 7;
		
	


	//===============================================================================================
	//											MAIN METHOD
	//===============================================================================================

	/**
	 * set the look and feel to cross platform
	 * get a random secret word
	 * instantiate the Hangman MVC
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//allows the input buttons to be colored
		getCrossPFLookAndFeel();

		
		//HangmanInitialWindow startUp = new HangmanInitialWindow();
		
		
		String strSecretWord = getSecretWord();
		
		//instantiate the MVC	
		HangmanModel model = new HangmanModel(strSecretWord, DEFAULT_NUM_GUESSES);
		HangmanView view = new HangmanView();
		HangmanController controller = new HangmanController(model, view);
		
	}//end main
	
	
	//===============================================================================================
	//											HELPER METHODS
	//===============================================================================================
	
	
	/**
	 * reads a random word from http://randomword.setgetgo.com/get.php
	 * capitalizes the random word
	 * @return a capitalized random word
	 * program will terminate if the Internet connection is down
	 */
	private static String getSecretWord(){
		
		StringBuilder sbWord = new StringBuilder();
		
		try {
			//reads the word from the page, will include extraneous characters that are not part of the word
			URL urlWordSite = new URL("http://randomword.setgetgo.com/get.php");
			BufferedReader brWord = new BufferedReader(new InputStreamReader(urlWordSite.openStream()));
			String strWord = brWord.readLine();
			
			for (int nC = 0; nC < strWord.length(); nC++) {
				
				//copy only characters that are letters, letters may be upper case or lower case
				if((strWord.charAt(nC) >= UNICODE_CAPITAL_LETTER_LOWER_BOUND && strWord.charAt(nC) <= UNICODE_CAPITAL_LETTER_UPPER_BOUND) || 
						(strWord.charAt(nC) >= UNICODE_LOWERCASE_LETTER_LOWER_BOUND && strWord.charAt(nC) <= UNICODE_LOWERCASE_LETTER_UPPER_BOUND)){
				sbWord.append(strWord.charAt(nC));
				}//end if
			}//end for
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unable to reach 'http://randomword.setgetgo.com/get.php'\nPlease check your Internet connection");
			System.exit(0);
			
		}//end try-catch
		
		return sbWord.toString().toUpperCase();
		
	}//end getSecretWord
	
	
	
	
	/**
	 * code to set the UIManager to a cross platform look and feel
	 * Mac prevents buttons from being colored
	 */
	private static void getCrossPFLookAndFeel(){
		
		
		  try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	System.exit(0);
	    }
	    catch (ClassNotFoundException e) {
	    	System.exit(0);
	    }
	    catch (InstantiationException e) {
	    	System.exit(0);
	    }
	    catch (IllegalAccessException e) {
	    	System.exit(0);
	    }
		
	}//end getLookAndFeel
}//end HangmanMVC
