import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Title screen of the HangMan game. From here, the
 * user can choose to begin playing the game, or go check
 * the achievements they have unlocked.
 * 
 * Aninda, Conrad, Johnson
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
        start.setLineColor(Color.BLUE); // set the color.
        addObject(start, 500, 550); // add the object.

        Label achieve = new Label("Press <A> to see unlocked Achievements!", 40);
        addObject(achieve, 500, 600); // add the object.
        achieve.setLineColor(Color.RED); // set the color.

        Label help = new Label("Press <I> to see Instructions!", 45);
        addObject(help, 500, 640); // add the object.
        help.setLineColor(Color.GREEN); // set the color.
        help.setFillColor(Color.LIGHT_GRAY); // set the color.

        PlayButton begin = new PlayButton();
        addObject(begin, 500, 350); // add the object.

    }

    public void act()
    {
        MyWorld.health = 0; // Sets health to zero to prevent conflict from previous plays
        if(Greenfoot.isKeyDown("space")) // Lets the player begin playing
        {

            Greenfoot.setWorld(new MyWorld());
        }

        if(Greenfoot.isKeyDown("A")) // Lets player go see their achievements
        {
            Greenfoot.setWorld(new AchievementZone());
        }

        if(Greenfoot.isKeyDown("I")) // Lets the player see the instructions
        {
            Greenfoot.setWorld(new InstructionWorld());
        }
    }

}
