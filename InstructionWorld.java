import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends World
{

    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        super(1000, 700, 1); 
        
        Label title = new Label("Press <T> to return to Title Screen!", 50);
        title.setLineColor(Color.GRAY);
        title.setFillColor(Color.BLUE);
        addObject(title, 500, 650);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("T")) // Goes to title screen if the player presses <T>
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
