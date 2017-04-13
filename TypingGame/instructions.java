import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The instructions for the game.
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class instructions extends World
{
    /**
     * Constructor for objects of class instructions.
     */
    public instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }

    /**
     * Clicking backspace sends players back to the main menu.
     */
    public void act(){
        if(Greenfoot.isKeyDown("backspace")){
            Greenfoot.setWorld(new startScreen());
        }
    }
}
