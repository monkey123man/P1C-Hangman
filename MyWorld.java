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
    public int health = 0;
    public int letterx = 675;
    public int lettery = 115;
    public ArrayList<String> allWords;
    ArrayList<String> letterarray = new ArrayList<String>();//This arraylist holds the entered letters
    public int max = 1000;
    public int min = 0;
    public int underx = 35;
    public int undery = 400;
    public int correctletterx = 35;
    public String randomword;
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
        int randomint = (int)Math.floor(Math.random()*(max-min+1)+min); //This creates a random number
        randomword = allWords.get(randomint); //Grabs a random word from the arraylist
        //Massive for-loop grabs each character in the word, converts it to a string, and adds it to the hashmap. If it already exists in the hashmap,
        //it bumps the value by 1 in the hashmap and it adds an underscore.
        //For characters that arent letters, it just puts whatever it is, ex. a hypen
        //Everything in the arraylist is a single word so no need to implement multiword stuff (we need to add multiline anyways for the super long words
        //such as "father-in-law"
        for (int i = 0; i < randomword.length(); i++){
            char cur = randomword.charAt(i);
            if (Character.isLetter(cur)){
                String stringcurs = String.valueOf(cur);
                if(letters.containsKey(stringcurs)){
                    int currentkeys = letters.get(stringcurs);
                    currentkeys++;
                    letters.put(stringcurs, currentkeys);
                }
                else{
                    letters.put(stringcurs, 1);
                }
                underx = 35 + i * 55;
                Label underline = new Label("_", 85);
                if (underx < 1000){
                   addObject(underline, underx, 400);
                }
            }
            else{
                String stringcurs = String.valueOf(cur);
                underx = 35 + i * 55;
                Label otherchar = new Label(stringcurs, 85);
                 if (underx < 1000){
                   addObject(otherchar, underx, 400);
                }
            }
        }
    }
    public void act(){
        //Runs the keypresses method
        keypresses();
        if (letters.isEmpty()){
            EndScreen endscreen = new EndScreen();
            Greenfoot.setWorld(endscreen);
        }
    }
    //Takes in keypresses and registers them if they are correct or not
    //Checks with letterarray (the arraylist that holds every letter that was entered)
    //If it isn't in letterarray, it just follows through and adds the letter
    public void keypresses(){
        if (Greenfoot.isKeyDown("A")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "A"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("a")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("A", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("a");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("a");
                        }
                        else{
                            letters.put("a", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("A", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("A");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("B")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "B"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("b")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("B", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("b");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("b");
                        }
                        else{
                            letters.put("b", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("B", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("B");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("C")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "C"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("c")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("C", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("c");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("c");
                        }
                        else{
                            letters.put("c", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("C", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("C");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("D")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "D"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("d")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("D", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("d");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("d");
                        }
                        else{
                            letters.put("d", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("D", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("D");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("E")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "E"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("e")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("E", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("e");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("e");
                        }
                        else{
                            letters.put("e", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("E", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("E");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("F")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "F"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("f")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("F", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("f");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("f");
                        }
                        else{
                            letters.put("f", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("F", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("F");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("G")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "G"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("g")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("G", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("g");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("g");
                        }
                        else{
                            letters.put("g", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("G", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("G");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("H")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "H"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("h")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("H", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("h");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("h");
                        }
                        else{
                            letters.put("h", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("H", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("H");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("I")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "I"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("i")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("I", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("i");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("i");
                        }
                        else{
                            letters.put("i", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("I", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("I");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("J")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "J"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("j")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("J", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("j");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("j");
                        }
                        else{
                            letters.put("j", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("J", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("J");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("K")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "K"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("k")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("K", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("k");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("k");
                        }
                        else{
                            letters.put("k", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("K", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("K");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("L")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "L"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("l")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("L", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("l");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("l");
                        }
                        else{
                            letters.put("l", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("L", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("L");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("M")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "M"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("m")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("M", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("m");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("m");
                        }
                        else{
                            letters.put("m", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("M", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("M");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("N")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "N"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("n")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("N", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("n");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("n");
                        }
                        else{
                            letters.put("n", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("N", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("N");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("O")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "O"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("o")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("O", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("o");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("o");
                        }
                        else{
                            letters.put("o", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("O", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("O");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("P")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "P"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("p")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("P", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("p");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("p");
                        }
                        else{
                            letters.put("p", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("P", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("P");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("Q")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "Q"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("q")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("Q", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("q");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("q");
                        }
                        else{
                            letters.put("q", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("Q", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("Q");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("R")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "R"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("r")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("R", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("r");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("r");
                        }
                        else{
                            letters.put("r", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("R", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("R");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("S")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "S"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("s")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("S", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("s");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("s");
                        }
                        else{
                            letters.put("s", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("S", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("S");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("T")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "T"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("t")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("T", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("t");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("t");
                        }
                        else{
                            letters.put("t", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("T", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("T");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("U")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "U"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("u")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("U", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("u");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("u");
                        }
                        else{
                            letters.put("u", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("U", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("U");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("V")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "V"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("v")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("V", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("v");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("v");
                        }
                        else{
                            letters.put("v", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("V", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("V");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("W")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "W"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("w")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("W", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("w");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("w");
                        }
                        else{
                            letters.put("w", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("W", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("W");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("X")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "X"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("x")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("X", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("x");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("x");
                        }
                        else{
                            letters.put("x", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("X", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("X");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("Y")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "Y"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("y")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("Y", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("y");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("y");
                        }
                        else{
                            letters.put("y", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("Y", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("Y");
                health++;
            }
        }
        if (Greenfoot.isKeyDown("Z")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "Z"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
                for(int h = 0; h < randomword.length(); h++){
                    char currentchar = randomword.charAt(h);
                    String currentstring = String.valueOf(currentchar);
                    if(currentstring.equals("z")){
                        correctletterx = 35 + h * 55;
                        Label correctguess = new Label("Z", 60);
                        addObject(correctguess, correctletterx, 400);
                        int currentkeys = letters.get("z");
                        currentkeys--;
                        if(currentkeys == 0){
                            letters.remove("z");
                        }
                        else{
                            letters.put("z", currentkeys);
                        }
                    }
                }
                Label newguess = new Label("Z", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("Z");
                health++;
            }
        }
        if(health == 6)
        {
            List objects = getObjects(null);
            removeObjects(objects);
            setBackground("images/bluebg.png");
            Label answer = new Label(randomword, 85);
            addObject(answer, 500, 200);
            Label end = new Label("Press space to restart", 85);
            addObject(end, 500, 400);
            if(Greenfoot.isKeyDown("space"))
            {
                TitleScreen titlescreen = new TitleScreen();
                Greenfoot.setWorld(titlescreen);
            }
        }
    }
}
