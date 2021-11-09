import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MusicStarter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicStarter extends World
{
    static GreenfootSound bgm;
    /**
     * Constructor for objects of class MusicStarter.
     * 
     */
    public MusicStarter()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(200, 200, 1); 
        bgm = new GreenfootSound("sounds/bensound-funnysong.mp3");
    }
    public void act()
    {
        bgm.setVolume(20);
        bgm.playLoop();
        MyWorld.achievement1 = false;
        MyWorld.achievement2 = false;
        MyWorld.achievement3 = false;
        MyWorld.a2Done = false;
        MyWorld.a3Done = false;
        Greenfoot.setWorld(new TitleScreen());
    }
}
