import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{
    GreenfootImage lose;
    GreenfootImage win;
    Label answer;
    Label start;
    int a1Check = 0;
    int a2Check = 0;
    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 700, 1); 

        lose = new GreenfootImage("LoseScreen.png");
        win = new GreenfootImage("WinScreen.png");

        PlayButton restart = new PlayButton();
        addObject(restart, 500, 350);

        Label title = new Label("Press <T> to return to Title Screen!" , 50);
        addObject(title, 500, 500);

        start = new Label("Click anywhere to play again!", 80);
        start.setLineColor(Color.CYAN);
        addObject(start, 500, 400);

        setPaintOrder(PlayButton.class, Label.class);
        a1Check = MyWorld.numWins;
        a2Check = MyWorld.achievement2Count;
    }

    public void act()
    {
        MyWorld game = new MyWorld();

        if(game.loss)
        {
            setBackground(lose);
            answer = new Label("The word was: " + game.wordToGuess + "!", 70);
            addObject(answer, 500, 320);
            if(!game.a2Done)
            {
                MyWorld.achievement2Count = 0;
            }
        }
        else
        {
            setBackground(win);
            answer = new Label("You guessed " + game.wordToGuess + " correctly!", 60);
            addObject(answer, 500, 320);
            MyWorld.numWins = a1Check + 1;
            if(!game.a2Done)
            {
                MyWorld.achievement2Count = a2Check + 1;
            }
        }

        game.health = 0;

        if(game.numWins >= 5)
        {
            game.achievement1 = true;
        }
        if(game.healthCheck == 0 && !game.a3Done)
        {
            game.achievement3 = true;
            game.a3Done = true;
        }
        if(game.achievement2Count >= 3)
        { 
            game.achievement2 = true;
            game.a2Done = true;
        }

        if(Greenfoot.isKeyDown("T"))
        {

            Greenfoot.setWorld(new TitleScreen());
        }

    }
}
