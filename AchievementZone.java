import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The esteemed achievement room, in which the player
 * can see the achievements they have completed. By
 * default, the achievements are hidden, and only show
 * themselves once the player has managed to obtain them.
 * 
 * Aninda 
 * Nov 9, 2021
 */
public class AchievementZone extends World
{
    // Make Medals and corresponding Labels for each achievement
    public Medal medal1;
    public Medal medal2;
    public Medal medal3;
    Label m1;
    Label m2;
    Label m3;
    /**
     * Constructor for objects of class AchievementZone.
     * 
     */
    public AchievementZone()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 
        
        // Create Medals and add them spaced out evenly across the 1000 pixels
        medal1 = new Medal();
        addObject(medal1, 250, 350);
        medal2 = new Medal();
        addObject(medal2, 500, 350);
        medal3 = new Medal();
        addObject(medal3, 750, 350);
        
        // Set the labels to be hidden by default
        m1 = new Label("*EASY HIDDEN*", 30);
        m1.setFillColor(Color.YELLOW);
        m2 = new Label("*MED HIDDEN*", 30);
        m2.setFillColor(Color.ORANGE);
        m3 = new Label("*HARD HIDDEN*", 30);
        m3.setFillColor(Color.RED);
        
        // add the objects with different colors.
        addObject(m1, 250, 500);
        addObject(m2, 500, 550);
        addObject(m3, 750, 500);
        
        // Show the user how to return to the title screen
        Label title = new Label("Press <T> to return to Title Screen!", 50);
        title.setLineColor(Color.BLUE);
        addObject(title, 500, 650);
    }
    public void act()
    {
        if(MyWorld.achievement1) // If the boolean for the first achievement is true, update the medal
        {
            medal1.medalUpdate(1);
            m1.setValue("Guessed 5 Correct Words"); // Change label to show achievement
        }
        if(MyWorld.achievement2) // Same as previous, but checks second achievement bool
        {
            medal2.medalUpdate(2);
            m2.setValue("3 Consecutive Wins");
        }
        if(MyWorld.achievement3) // same but third
        {
            medal3.medalUpdate(3);
            m3.setValue("No Incorrect Guesses");
        }
        
        if(Greenfoot.isKeyDown("T")) // Checks for user input <T> then goes back to title screen
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
