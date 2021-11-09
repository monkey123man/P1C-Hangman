import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medal extends Actor
{
    /**
     * Act - do whatever the Medal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void medalUpdate(int num)
    {
        if(num == 1)
        {
            setImage("images/medalE.png");
        }
        if(num == 2)
        {
            setImage("images/medalM.png");
        }
        if(num == 3)
        {
            setImage("images/medalH.png");
        }
    }
}
