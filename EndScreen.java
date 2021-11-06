import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    Label end = new Label("The End", 50);
    Label continuelabel = new Label("Press space to continue", 50);
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1);
    }
    public void act(){
        addObject(end, 500, 100);
        addObject(continuelabel, 500, 300);
        if(Greenfoot.isKeyDown("space"))
        {
            TitleScreen titlescreen = new TitleScreen();
            Greenfoot.setWorld(titlescreen);
        }
    }
}
