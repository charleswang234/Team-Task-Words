import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The instructions of game
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class instructions extends World
{

    /**
     * Constructor for objects of class instructions.
     * 
     */
    public instructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }

    public void act(){ //press backspace to go back to startscreen
        if(Greenfoot.isKeyDown("backspace")){
            Greenfoot.setWorld(new startScreen());
        }
    }

}
