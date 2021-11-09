import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*;
/**
 * The main stage of the hangman game. This is where
 * the player will be guessing words, with the life
 * of the HangMan on the line. This class holds all 
 * the code which deals with placement of all the 
 * objects, reading the users inputs, and deciding
 * if the player won the game or lost the game.
 * 
 * Aninda, Conrad
 * Nov 9, 2021
 */
public class MyWorld extends World
{
    public static int health = 0; // The main health variable which updates the hangman and also limits the players guesses
    public int letterX = 675; //Variable for base x coordinate of guess
    public int letterY = 115; //Variable for base y coordinate for guess
    public ArrayList<String> allWords; //Arraylist to hold the words in the wordlist
    public ArrayList<String> alphabet = new ArrayList<String>(); //rraylist to hold the alphabet
    ArrayList<String> letterArray = new ArrayList<String>();//This arraylist holds the entered letters
    public int max = 2327; //Maximum word entry to find in the allWords arraylist (essentially the word count)
    public int min = 0; //Minium word entry to find in the allWords arraylist
    public int underx = 35; //Base x coordinates for underlines
    public int undery = 400; //Base y coordinate for underlines
    public int correctletterX = 35; //Base x coordinate for correct word placement
    public String randomWord; //String for random word
    
    HashMap<String, Integer> letters = new HashMap<String, Integer>(); //Generate a hashmap that has the letters as a key
    //and the number it appears as value
    public int numGuesses = 0; //Integer to hold the number of guesses done so far
    public int guessesHeight = 0; //Int to hold the the column number in guesses area so it doesnt overflow in one line
    
    public static boolean loss; // This boolean is true if the player loses and false if they win
    public static String wordToGuess =""; // A variable to access the word the player was guessing
    
    // Achievement variables
    public static boolean achievement1;
    public static int numWins = 0; // counts number of wins
    public static boolean achievement2;
    public static boolean a2Done; // Prevents achievement2's value from changing if it is already done
    public static int achievement2Count = 0; // Adds to this if the wins are consecutive
    public static boolean achievement3;
    public static boolean a3Done;// Prevents achievement3's value from changing if it is already done
    public static int healthCheck; // To save and allow access of the value of health at the end of the game
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        
        //Adds the alphabet to the arraylist
        alphabet.add("A"); 
        alphabet.add("B");
        alphabet.add("C");
        alphabet.add("D");
        alphabet.add("E");
        alphabet.add("F");
        alphabet.add("G");
        alphabet.add("H");
        alphabet.add("I");
        alphabet.add("J");
        alphabet.add("K");
        alphabet.add("L");
        alphabet.add("M");
        alphabet.add("N");
        alphabet.add("O");
        alphabet.add("P");
        alphabet.add("Q");
        alphabet.add("R");
        alphabet.add("S");
        alphabet.add("T");
        alphabet.add("U");
        alphabet.add("V");
        alphabet.add("W");
        alphabet.add("X");
        alphabet.add("Y");
        alphabet.add("Z");
        // Defines arraylist which contains all the words from the inserting url in Words class
        allWords = new ArrayList<String>();
        try
        {
            Words.readInto(allWords);
        }
        catch(Exception e)
        {

        }
        
        // Adds the hangman to the world in the upper left corner where the stage is
        HangMan guy = new HangMan();
        addObject(guy, 310, 190);
        // Below this label are where the player guesses will be
        Label guess = new Label("Guesses!", 85);
        addObject(guess, 820, 50);
        
        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min); //This creates a random number
        randomWord = allWords.get(randomInt); //Grabs a random word from the arraylist
        //  allWords.get(randomInt);
        // Massive for-loop grabs each character in the word, converts it to a string,
        // and adds it to the hashmap. If it already exists in the hashmap,
        // it bumps the value by 1 in the hashmap and it adds an underscore.
        // For characters that arent letters, it just puts whatever it is, ex. a hyphen
        // Everything in the arraylist is a single word so no need to implement multiword stuff 
        // (we need to add multiline anyways for the super long words such as "father-in-law"
        for (int i = 0; i < randomWord.length(); i++){
            char cur = randomWord.charAt(i); //Grabs each character
            if (Character.isLetter(cur)){
                String stringCurs = String.valueOf(cur); //Converts character to string
                if(letters.containsKey(stringCurs)){
                    int currentKeys = letters.get(stringCurs); //Increases the the value appeared by 1 if it has already appeared
                    currentKeys++;
                    letters.put(stringCurs, currentKeys);
                }
                else{
                    letters.put(stringCurs, 1); //If not appeared once, put it in the hashmap
                }
                underx = 35 + i * 55; //Place an underscore per character
                Label underline = new Label("_", 85);
                if (underx < 1000){
                    addObject(underline, underx, 400);
                }
            }
            else{
                //This else is if the character in the word isn't a letter (ex. a hyphen)
                String stringCurs = String.valueOf(cur);
                underx = 35 + i * 55;
                Label otherchar = new Label(stringCurs, 85);
                if (underx < 1000){
                    addObject(otherchar, underx, 400);
                }
            }
        }
        
    }
    public void act(){
        //Runs the keyPresses method
        keyPresses();
        if (letters.isEmpty()){
            loss = false;
            wordToGuess = randomWord;
            healthCheck = health;
            Greenfoot.setWorld(new EndScreen());
        }
    }
    //Takes in keyPresses and registers them if they are correct or not
    //Checks with letterArray (the arraylist that holds every letter that was entered)
    //If it isn't in letterArray, it just follows through and adds the letter
    public void keyPresses(){
        for(int i = 0; i < 26; i++){
            String currentLetter = alphabet.get(i); //Grabs the letters
            Boolean correctBool = false;
            String currentLowercaseLetter = currentLetter.toLowerCase(); //Makes a lowercase version because the wordlist uses lowercase
            if (Greenfoot.isKeyDown(currentLetter)){
                int counter = 0; //Counter variable checks if letter has been pressed already
                for (int j = 0; j < letterArray.size(); j ++){
                    //This for-loop checks with the letterarray (this array holds the letters pressed) and checks if it is pressed already
                    if (letterArray.get(j) == currentLetter){
                        counter = 1;
                    }
                }
                if (counter == 0 && health < 6){
                    //Only works if letter has not been pressed and health is less than 6
                    for(int h = 0; h < randomWord.length(); h++){
                        //Cycle throughs the words looking at each character
                        char currentChar = randomWord.charAt(h); //Grabs character from the word
                        String currentstring = String.valueOf(currentChar); //Converts char to string
                        if(currentstring.equals(currentLowercaseLetter)){
                            //If the character grabbed at the instance is equivalent to the lowercase letter that we are looping with (ex.a, b, c)
                            correctletterX = 35 + h * 55; //Grabs the position to place the corrrect letter in
                            Label correctGuess = new Label(currentLetter, 60); //Makes a new label
                            addObject(correctGuess, correctletterX, 400); //Adds the label
                            int currentKeys = letters.get(currentLowercaseLetter); //Grabs the value tied to the letter key in the hashmap
                            currentKeys--; //Subtracts the value by 1
                            if(currentKeys == 0){
                                letters.remove(currentLowercaseLetter);
                            }
                            else{
                                letters.put(currentLowercaseLetter, currentKeys);
                            }
                            correctBool = true; // is true if the guessed letter is in the word
                        }
                    }
                    Label newGuess = new Label(currentLetter, 60);
                    if(correctBool) // Correct guess
                    {
                        newGuess.setFillColor(Color.GREEN); // Sets the colour of the guess to green
                    }
                    else // Incorrect guess
                    {
                        newGuess.setFillColor(Color.RED); // Sets the colour of the guess to red
                    }

                    if (numGuesses > 5) // begins a new row once the number of guesses exceeds 5
                    {
                        guessesHeight++;
                        letterY = 115 + 50 * guessesHeight;
                        numGuesses = 0;
                    }
                    letterX = 675 + 50 * numGuesses;
                    addObject(newGuess, letterX, letterY);
                    letterArray.add(currentLetter);
                    numGuesses++;
                    if (!correctBool) // If the answer was wrong, add to health
                    {
                        health++;
                    }
                }
            }
        }
        if(health == 6) // When the health is 6
        {
            loss = true; // The player loses
            wordToGuess = randomWord; // Saves the word that the player was guessing
            healthCheck = health; // Saves the health
            Greenfoot.setWorld(new EndScreen()); // Switches the world to EndScreen
        }
    }
}
