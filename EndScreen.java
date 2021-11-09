import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The EndScreen class is the world where the game goes
 * once the game is complete. In this class, it shows the
 * player whether they won or lost, updates/checks the
 * achievements, and lets the player play again or
 * go back to the title screen.
 * 
 * Aninda
 * Nov 9, 2021
 */
public class EndScreen extends World
{
    //Create two images to be used as backgrounds based on win/loss
    GreenfootImage lose;
    GreenfootImage win;
    
    Label answer; // Shows the correct answer
    Label start;
    // Variables to check authenticity/completion of the first and second achievements
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
        // Initialize the images
        lose = new GreenfootImage("LoseScreen.png");
        win = new GreenfootImage("WinScreen.png");

        PlayButton restart = new PlayButton();
        addObject(restart, 500, 350);

        Label title = new Label("Press <T> to return to Title Screen!" , 50);
        addObject(title, 500, 500);

        start = new Label("Click anywhere to play again!", 80);
        start.setLineColor(Color.CYAN);
        addObject(start, 500, 400);
        // Set the fullscreen button to be above the labels so clicking anywhere executes the code
        setPaintOrder(PlayButton.class, Label.class);
        
        a1Check = MyWorld.numWins; // Set a1Check to the numWins variable for later use
        a2Check = MyWorld.achievement2Count; // Set a2Check to achievement2Count for later use
    }

    public void act()
    {
        MyWorld game = new MyWorld(); // Create an instance of MyWorld to get values from

        if(game.loss)// If the loss boolean is true, then the player lost the game
        {
            setBackground(lose); // Sets background to loss screen
            answer = new Label("The word was: " + game.wordToGuess + "!", 70); // Changes answer label to show correct ans
            addObject(answer, 500, 320); // Adds label
            if(!game.a2Done) // If the second achievement is NOT done
            {
                MyWorld.achievement2Count = 0; // Sets count of wins for a2 to 0, as it requires consecutive wins
            }
        }
        else // If the player won
        {
            setBackground(win);
            answer = new Label("You guessed " + game.wordToGuess + " correctly!", 60);
            addObject(answer, 500, 320);
            MyWorld.numWins = a1Check + 1; // Doing this prevents the numWins variable from infinitely adding as run executes
            if(!game.a2Done) // if the second achievement is incomplete
            {
                MyWorld.achievement2Count = a2Check + 1; // Doing this lets achievement2Count only increase by one
            }
        }

        game.health = 0; // Reset the health value so the player can play again

        if(game.numWins >= 5) // Finishes achievement 1
        {
            game.achievement1 = true;
        }
        if(game.healthCheck == 0 && !game.a3Done) // If the 3rd achievement isnt done and the health value is 0
        {
            game.achievement3 = true; // completes the third achievement
            game.a3Done = true; // prevents the value from being changed
        }
        if(game.achievement2Count >= 3 && !game.a2Done) // if the second achievement's count is 3
        { 
            game.achievement2 = true; // Finishes second achievement
            game.a2Done = true; // Prevents the value from being altered
        }

        if(Greenfoot.isKeyDown("T")) // Goes to title screen if the player presses <T>
        {
            Greenfoot.setWorld(new TitleScreen());
        }

    }
}
