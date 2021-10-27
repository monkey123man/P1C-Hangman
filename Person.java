import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        if (Greenfoot.isKeyDown("D")){
        setLocation (x + 5, y);
        }
        if (Greenfoot.isKeyDown("S")){
        setLocation (x, y + 5);
        }
        if (Greenfoot.isKeyDown("A")){
        setLocation (x - 5, y);
        }
        if (Greenfoot.isKeyDown("W")){
        setLocation (x, y - 5);
        }
    }
}
