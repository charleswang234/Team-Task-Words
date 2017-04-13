import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Endscreen world. Allows players to restart the game.
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class EndScreen extends World
{   
    /**
     * Constructor for objects of class EndScreen.
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label finalScore = new Label("Final Score: " + Scoreboard.finalScore, 50); //Holds the final score;
        addObject(finalScore,400,200); //Displays the user's final score
    }

    /**
     * Restarts the game.
     */
    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
