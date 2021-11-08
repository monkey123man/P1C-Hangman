import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        Label start = new Label("Click anywhere or press <space> to begin!", 50);
        start.setLineColor(Color.BLUE);
        addObject(start, 500, 550);
        
        Label achieve = new Label("Press <A> to see unlocked Achievements!", 40);
        addObject(achieve, 500, 600);
        achieve.setLineColor(Color.RED);

        PlayButton begin = new PlayButton();
        addObject(begin, 500, 350);

    }
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            world.health = 0;
            Greenfoot.setWorld(world);
        }
        
        if(Greenfoot.isKeyDown("A"))
        {
            Greenfoot.setWorld(new AchievementZone());
        }
    }

}
