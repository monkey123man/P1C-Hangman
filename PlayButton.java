import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The PlayButton is a button which is a 1000x700
 * pixel png. The entire image is transparent, so
 * that when the user clicks anywhere, the world 
 * switches to MyWorld.
 * 
 * Aninda, Conrad
 * Oct 27, 2021
 */
public class PlayButton extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mousePressed(this)) // Checks for click in the world area
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }    
}
