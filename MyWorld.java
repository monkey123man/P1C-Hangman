import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.*;
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int health = 0;
    public int letterX = 675;
    public int letterY = 115;
    public ArrayList<String> allWords;
    ArrayList<String> letterArray = new ArrayList<String>();//This arraylist holds the entered letters
    public int max = 1000;
    public int min = 0;
    public int underx = 35;
    public int undery = 400;
    public int correctletterX = 35;
    public String randomWord;
    public static boolean loss;
    public static String wordToGuess ="";
    HashMap<String, Integer> letters = new HashMap<String, Integer>();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
        allWords = new ArrayList<String>();
        try
        {
            Words.readInto(allWords);
        }
        catch(Exception e)
        {
            
        }
        HangMan guy = new HangMan();
        addObject(guy, 310, 190);
        Label guess = new Label("Guesses!", 85);
        addObject(guess, 820, 50);
        int randomInt = (int)Math.floor(Math.random()*(max-min+1)+min); //This creates a random number
        randomWord = allWords.get(randomInt); //Grabs a random word from the arraylist
        //Massive for-loop grabs each character in the word, converts it to a string, and adds it to the hashmap. If it already exists in the hashmap,
        //it bumps the value by 1 in the hashmap and it adds an underscore.
        //For characters that arent letters, it just puts whatever it is, ex. a hypen
        //Everything in the arraylist is a single word so no need to implement multiword stuff (we need to add multiline anyways for the super long words
        //such as "father-in-law"
        for (int i = 0; i < randomWord.length(); i++){
            char cur = randomWord.charAt(i);
            if (Character.isLetter(cur)){
                String stringCurs = String.valueOf(cur);
                if(letters.containsKey(stringCurs)){
                    int currentKeys = letters.get(stringCurs);
                    currentKeys++;
                    letters.put(stringCurs, currentKeys);
                }
                else{
                    letters.put(stringCurs, 1);
                }
                underx = 35 + i * 55;
                Label underline = new Label("_", 85);
                if (underx < 1000){
                   addObject(underline, underx, 400);
                }
            }
            else{
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
            TitleScreen titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen);
        }
    }
    //Takes in keyPresses and registers them if they are correct or not
    //Checks with letterArray (the arraylist that holds every letter that was entered)
    //If it isn't in letterArray, it just follows through and adds the letter
    public void keyPresses(){
        if (Greenfoot.isKeyDown("A")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "A"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("a")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("A", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("a");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("a");
                        }
                        else{
                            letters.put("a", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("A", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("A");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("B")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "B"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("b")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("B", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("b");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("b");
                        }
                        else{
                            letters.put("b", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("B", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("B");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("C")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "C"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("c")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("C", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("c");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("c");
                        }
                        else{
                            letters.put("c", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("C", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("C");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("D")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "D"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("d")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("D", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("d");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("d");
                        }
                        else{
                            letters.put("d", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("D", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("D");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("E")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "E"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("e")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("E", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("e");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("e");
                        }
                        else{
                            letters.put("e", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("E", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("E");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("F")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "F"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("f")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("F", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("f");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("f");
                        }
                        else{
                            letters.put("f", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("F", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("F");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("G")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "G"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("g")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("G", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("g");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("g");
                        }
                        else{
                            letters.put("g", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("G", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("G");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("H")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "H"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("h")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("H", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("h");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("h");
                        }
                        else{
                            letters.put("h", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("H", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("H");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("I")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "I"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("i")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("I", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("i");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("i");
                        }
                        else{
                            letters.put("i", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("I", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("I");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("J")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "J"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("j")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("J", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("j");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("j");
                        }
                        else{
                            letters.put("j", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("J", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("J");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("K")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "K"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("k")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("K", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("k");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("k");
                        }
                        else{
                            letters.put("k", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("K", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("K");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("L")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "L"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("l")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("L", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("l");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("l");
                        }
                        else{
                            letters.put("l", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("L", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("L");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("M")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "M"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("m")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("M", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("m");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("m");
                        }
                        else{
                            letters.put("m", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("M", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("M");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("N")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "N"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("n")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("N", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("n");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("n");
                        }
                        else{
                            letters.put("n", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("N", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("N");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("O")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "O"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("o")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("O", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("o");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("o");
                        }
                        else{
                            letters.put("o", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("O", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("O");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("P")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "P"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("p")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("P", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("p");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("p");
                        }
                        else{
                            letters.put("p", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("P", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("P");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("Q")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "Q"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("q")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("Q", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("q");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("q");
                        }
                        else{
                            letters.put("q", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("Q", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("Q");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("R")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "R"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("r")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("R", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("r");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("r");
                        }
                        else{
                            letters.put("r", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("R", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("R");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("S")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "S"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("s")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("S", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("s");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("s");
                        }
                        else{
                            letters.put("s", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("S", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("S");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("T")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "T"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("t")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("T", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("t");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("t");
                        }
                        else{
                            letters.put("t", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("T", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("T");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("U")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "U"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("u")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("U", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("u");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("u");
                        }
                        else{
                            letters.put("u", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("U", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("U");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("V")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "V"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("v")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("V", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("v");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("v");
                        }
                        else{
                            letters.put("v", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("V", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("V");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("W")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "W"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("w")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("W", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("w");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("w");
                        }
                        else{
                            letters.put("w", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("W", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("W");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("X")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "X"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("x")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("X", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("x");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("x");
                        }
                        else{
                            letters.put("x", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("X", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("X");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("Y")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "Y"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("y")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("Y", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("y");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("y");
                        }
                        else{
                            letters.put("y", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("Y", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("Y");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("Z")){
            int counter = 0;
            for (int i = 0; i < letterArray.size(); i ++){
                if (letterArray.get(i) == "Z"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomWord.length(); h++){
                    char currentChar = randomWord.charAt(h);
                    String currentstring = String.valueOf(currentChar);
                    if(currentstring.equals("z")){
                        correctletterX = 35 + h * 55;
                        Label correctGuess = new Label("Z", 60);
                        addObject(correctGuess, correctletterX, 400);
                        int currentKeys = letters.get("z");
                        currentKeys--;
                        if(currentKeys == 0){
                            letters.remove("z");
                        }
                        else{
                            letters.put("z", currentKeys);
                        }
                    }
                }
                Label newGuess = new Label("Z", 60);
                letterX = 675 + 50 * health;
                addObject(newGuess, letterX, letterY);
                letterArray.add("Z");
                health++;
            }
        }
        // if(health == 6)
        // {
            // List objects = getObjects(null);
            // removeObjects(objects);
            // setBackground("images/bluebg.png");
            // Label answer = new Label(randomWord, 85);
            // addObject(answer, 500, 200);
             // Label end = new Label("Press space to restart", 85);
            // addObject(end, 500, 400);
            // if(Greenfoot.isKeyDown("space"))
            // {
                // TitleScreen titlescreen = new TitleScreen();
                // Greenfoot.setWorld(titlescreen);
            // }
        // }
        
        if(health == 6)
        {
            loss = true;
            wordToGuess = randomWord;
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
