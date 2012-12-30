package hw3;

import java.util.ArrayList;


/**
 * models a hangman game
 * @author josephmalandruccolo
 *
 */
public class HangmanModel {

	//===============================================================================================
	//											GAME PROPERTIES
	//===============================================================================================
	
	private String strSecretWord; 					//the word to be guessed
	private int nRemainingGuesses;					//number of guesses left
	private int nLettersRemaining;					//number of letters the player needs to guess to solve the word
	private char[] cCurrentWordChars;				//holds the current word, as guessed by the user
	private ArrayList<Character> cLettersGuessed;	//linked list of characters
	
	
	
	//===============================================================================================
	//											GAME CONSTANTS
	//===============================================================================================
	
	private final int NUM_LEGAL_CHARS = 27;	//26 letters, each converted to uppercase and a '-' (hyphen) character
	private final int PADDING = 5;	//additional space in the array, for safety
	private final String ALREADY_GUESSED_ALERT = "You already tried that letter!";
	private final String SUCCESSFUL_GUESS_ALERT = "YES!";
	private final String FAILED_GUESS_ALERT = "nope";
	
	
	
	
	//===============================================================================================
	//											GAME CONSTRUCTOR
	//===============================================================================================
	public HangmanModel(String strSecretWord, int nGuesses){
		
		this.strSecretWord = strSecretWord.toUpperCase();
		this.nRemainingGuesses = nGuesses;
		this.nLettersRemaining = strSecretWord.length();
		this.cLettersGuessed = new ArrayList<Character>(NUM_LEGAL_CHARS + PADDING);
		this.cCurrentWordChars = new char[strSecretWord.length()];
		
		//set the current word to "_ _ _..."
		for (int nC= 0; nC < cCurrentWordChars.length; nC++) cCurrentWordChars[nC] = '_';
		
	}//end constructor
	
	
	
	//===============================================================================================
	//											GAME METHODS
	//===============================================================================================
	/**
	 * represents a player guessing a letter
	 * updates the state of the game based on the player's guess:
	 * 		number of guesses remaining
	 * 		number of letters remaining
	 * 		current word
	 * 		letters guessed
	 * 
	 * GAME LOGIC:
	 * 		if the letter guessed is not in the word AND has not already been guessed, decrement the number of guesses
	 * 		if the letter guessed is in the word AND has not already been guessed, update the game state and do NOT decrement the number of guesses
	 * 		no penalty for guessing the same letter multiple times
	 * @param cLetter - the character guessed by the user
	 * @return true if (the game is not over AND guessed letter was in the word) false otherwise
	 */
	public String makeGuess(char cLetter){
		
		String strMessage;
		
		//have we guessed this letter before?
		if(isLetterInWord(cLetter, this.cLettersGuessed)){
			//we have guessed the letter before
			strMessage = ALREADY_GUESSED_ALERT;
		}
		else{	//we have NOT guessed the letter before
			
			//the letter is in the secret word
			if(isLetterInWord(cLetter, this.strSecretWord)){
				updateCurrentWord(cLetter);
				updateLettersGuessed(cLetter);
				strMessage = SUCCESSFUL_GUESS_ALERT;
			}
			else{	//the letter is NOT in the secret word
				
				this.nRemainingGuesses--;
				updateLettersGuessed(cLetter);
				strMessage = FAILED_GUESS_ALERT;
			}//end inner if-else
		}//end outer if-else
		
		return strMessage;
		
	}//end makeGuess
	
	
	/**
	 * identifies whether the player has won the game
	 * @return true if there are no more letters to be guessed and the player has a positive number of guesses remaining
	 */
	public boolean isWin(){return this.nRemainingGuesses > 0 && this.nLettersRemaining <= 0;}
	
	
	/**
	 * identifies whether the player has lost the game
	 * @return true if there are no remaining guesses and more letters to guess
	 */
	public boolean isLoss(){return this.nRemainingGuesses <= 0 && this.nLettersRemaining > 0;}

	
	//===============================================================================================
	//											HELPER METHODS
	//===============================================================================================

	/**
	 * if the letter guessed has not already been stored, store it
	 * @param cLetter - letter guessed
	 */
	private void updateLettersGuessed(char cLetter) {
		if(!isLetterInWord(cLetter, this.cLettersGuessed)) this.cLettersGuessed.add(cLetter);
	}//end updateLettersGuessed



	/**
	 * update the current word to reflect the guess
	 * method also responsible for updating the number of letters remaining
	 * @param cLetter
	 */
	private void updateCurrentWord(char cLetter) {
		//loop through the secret word, if we encounter the guessed letter, update the current word array
		for (int nC = 0; nC < this.cCurrentWordChars.length; nC++){
			if(this.strSecretWord.charAt(nC) == cLetter){
				this.cCurrentWordChars[nC] = cLetter;
				this.nLettersRemaining--;
			}//end if
		}//end for
	}//end updateCurrentWord



	/**
	 * linear search algorithm to identify if a char key is in a char array, inefficient algorithm is fine
	 * as we expect the character array (word) to be short
	 * @param cLetter - the key
	 * @param cWord - the list
	 * @return true if found, false otherwise
	 */
	private boolean isLetterInWord(char cLetter, ArrayList<Character> cWord) {
		 
		for (int nC = 0; nC < cWord.size(); nC++) if(cWord.get(nC) == cLetter) return true;
		
		return false;
		
	}//end isLetterInWord
	
	
	/**
	 * 
	 * @param cLetter - the key
	 * @param strWord - the word
	 * @return true if found, false otherwise
	 */
	private boolean isLetterInWord(char cLetter, String strWord) {return strWord.indexOf(cLetter) >= 0;}
	
	

	//===============================================================================================
	//											GETTERS AND SETTERS
	//===============================================================================================
	
	/**
	 * @return the secret word
	 */
	public String getSecretWord(){return this.strSecretWord;}
	
	
	/**
	 * @return the number of guesses remaining
	 */
	public int getNumGuessesLeft(){return this.nRemainingGuesses;}	
	
	
	/**
	 * @return the current word, as a String
	 */
	public String getCurrentWord(){
		
		StringBuilder sbCurrentWordPublic = new StringBuilder();
		
		for(int nC = 0; nC < this.cCurrentWordChars.length; nC++) sbCurrentWordPublic.append(this.cCurrentWordChars[nC]);
		
		return sbCurrentWordPublic.toString();
		
	}//end getCurrentWord
	
	
	/**
	 * @return the number of letters that the player still needs to guess
	 */
	public int getNumLettersRemaining(){return this.nLettersRemaining;}
	

}//end HangmanModel
