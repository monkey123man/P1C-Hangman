import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{
    GreenfootImage[] personLives = new GreenfootImage[7];

    public Person()
    {
        for(int i = 0; i <=6; i++)
        {
            personLives[i] = new GreenfootImage("images/person" + i);
        }
    }
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        move(1);
        
        MyWorld world = new MyWorld();
        setImage(personLives[world.health]);
    }
}
