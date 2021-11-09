import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Title screen of the HangMan game. From here, the
 * user can choose to begin playing the game, or go check
 * the achievements they have unlocked.
 * 
 * Aninda, Conrad
 * Nov 9, 2021
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 1000x700 cells with a cell size of 1x1 pixels.
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
        if(Greenfoot.isKeyDown("space")) // Lets the player begin playing
        {
            MyWorld world = new MyWorld();
            world.health = 0; // Sets the health variable to 0 to prevent conflict from previous runs
            Greenfoot.setWorld(world);
        }
        
        if(Greenfoot.isKeyDown("A")) // Lets player go see their achievements
        {
            Greenfoot.setWorld(new AchievementZone());
        }
    }

}
