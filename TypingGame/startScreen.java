import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Startscreen
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class startScreen extends World
{

    /**
     * Constructor for objects of class startScreen.
     * 
     */
    public startScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("enter")){ //press enter to start game
            Greenfoot.setWorld(new MyWorld());
        }
        if(Greenfoot.isKeyDown("space")){ //press space to view instructions
            Greenfoot.setWorld(new instructions());
        }
    }
}
