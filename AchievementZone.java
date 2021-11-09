import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AchievementZone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AchievementZone extends World
{
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
        
        medal1 = new Medal();
        addObject(medal1, 250, 350);
        medal2 = new Medal();
        addObject(medal2, 500, 350);
        medal3 = new Medal();
        addObject(medal3, 750, 350);
        
        m1 = new Label("*EASY HIDDEN*", 30);
        m1.setFillColor(Color.YELLOW);
        m2 = new Label("*MED HIDDEN*", 30);
        m2.setFillColor(Color.ORANGE);
        m3 = new Label("*HARD HIDDEN*", 30);
        m3.setFillColor(Color.RED);
        
        addObject(m1, 250, 500);
        addObject(m2, 500, 550);
        addObject(m3, 750, 500);
        
        Label title = new Label("Press <T> to return to Title Screen!", 50);
        title.setLineColor(Color.BLUE);
        addObject(title, 500, 650);
    }
    public void act()
    {
        if(MyWorld.achievement1)
        {
            medal1.medalUpdate(1);
            m1.setValue("Guessed 5 Correct Words");
        }
        if(MyWorld.achievement2)
        {
            medal2.medalUpdate(2);
            m2.setValue("3 Consecutive Wins");
        }
        if(MyWorld.achievement3)
        {
            medal3.medalUpdate(3);
            m3.setValue("No Incorrect Guesses");
        }
        
        if(Greenfoot.isKeyDown("T"))
        {
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
