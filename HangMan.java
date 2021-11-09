import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The HangMan class features the protagonist of our
 * game. At first the image set is only a noose, but
 * as the player keeps making mistakes, the picture
 * updates, setting his body parts to gradually show
 * up. First his head, then body, then two arms, then
 * the legs. Once he is complete, the game is lost.
 * 
 * Aninda, Conrad 
 * Oct 25, 2021
 */
public class HangMan extends Actor
{
    GreenfootImage[] lives; // Creates an array of images for the HangMan
    public HangMan()
    {
        lives  = new GreenfootImage[7]; // sets size of the array to seven
        for(int i = 0; i <=6; i++) // a for loop going from 0 to 6, inclusive, which adds pictures
        {
            lives[i] = new GreenfootImage("images/person" + i + ".png"); // Based on the i value from the loop, the pictures added have numbers
        }
    }
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        MyWorld world = new MyWorld(); // Creates instance of MyWorld, from which the static health variable can be read
        setImage(lives[world.health]); // Sets the picture of the hangman corresponding to the health of the player
    }
}
