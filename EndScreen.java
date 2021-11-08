import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    GreenfootImage lose;
    GreenfootImage win;
    Label answer;
    Label start;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 

        lose = new GreenfootImage("LoseScreen.png");
        win = new GreenfootImage("WinScreen.png");

        PlayButton restart = new PlayButton();
        addObject(restart, 500, 350);
        
        Label title = new Label("Press <T> to return to Title Screen!" , 50);
        addObject(title, 500, 500);
        
        start = new Label("Click anywhere to begin!", 80);
        start.setLineColor(Color.CYAN);
        addObject(start, 500, 400);
        
        setPaintOrder(PlayButton.class, Label.class);
    }

    public void act()
    {
        MyWorld game = new MyWorld();
        if(game.loss)
        {
            setBackground(lose);
            answer = new Label("The word was: " + game.wordToGuess + "!", 70);
            addObject(answer, 500, 320);
        }
        else
        {
            setBackground(win);
            answer = new Label("You guessed " + game.wordToGuess + " correctly!", 60);
            addObject(answer, 500, 320);
        }
        
        game.health = 0;
        if(Greenfoot.isKeyDown("T"))
        {
            
            Greenfoot.setWorld(new TitleScreen());
        }
        
    }
}
