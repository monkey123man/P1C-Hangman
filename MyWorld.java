import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    ArrayList<String> letterarray = new ArrayList<String>();
    public int max = 1000;
    public int min = 0;
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
    }
    public void act(){
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        keypresses();
    }
    public void keypresses(){
        if (Greenfoot.isKeyDown("A")){
            int counter = 0;
            for (int i = 0; i < letterarray.size(); i ++){
                if (letterarray.get(i) == "A"){
                    counter = 1;
                }
            }
            if (counter == 0 && health < 6){
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
                Label newguess = new Label("Z", 60);
                letterx = 675 + 50 * health;
                addObject(newguess, letterx, lettery);
                letterarray.add("Z");
                health++;   
            }
        }
        if(health > 6)
        {
            
        }
    }
}
