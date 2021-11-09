import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class with the sole purpose of starting music. 
 * By playing a loop and resetting the achievement 
 * boolean values, the game gets a soft reset of 
 * sorts. This class is the first starter class,
 * yet it cannot be accessed without resetting the 
 * game to prevent multiple music loops playing.
 * 
 * Aninda 
 * Nov 8, 2021
 */
public class MusicStarter extends World
{
    static GreenfootSound bgm; // Define the background music
    /**
     * Constructor for objects of class MusicStarter.
     * 
     */
    public MusicStarter()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(200, 200, 1); 
        bgm = new GreenfootSound("sounds/bensound-funnysong.mp3"); // Add the bgm
    }
    public void act()
    {
        // Lower the volume and play a loop of the in-game music
        bgm.setVolume(20);
        bgm.playLoop();
        // Reset all variables corresponding to achievements
        MyWorld.achievement1 = false;
        MyWorld.achievement2 = false;
        MyWorld.achievement3 = false;
        MyWorld.a2Done = false;
        MyWorld.a3Done = false;
        
        // Set the world to titlescreen immediately after
        Greenfoot.setWorld(new TitleScreen());
    }
}
