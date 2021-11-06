import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HangMan extends Actor
{
    GreenfootImage[] lives;
    public HangMan()
    {
        lives  = new GreenfootImage[7];
        for(int i = 0; i <=6; i++)
        {
            lives[i] = new GreenfootImage("images/person" + i + ".png");
        }
    }
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MyWorld world = new MyWorld();
        setImage(lives[world.health]);
    }
}
