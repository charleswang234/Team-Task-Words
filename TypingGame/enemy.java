import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Goomba class that deals with the movements of the goomba.
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class enemy extends Actor
{
    private int speed = 0; //speed of goomba
    public int xValue; //x location of goomba

    public enemy(int x){ //constructor for goomba
        xValue = x; 
        if (xValue > 350){ //if start location is on right, goomba moves left
            speed = - 1;
            getImage().mirrorHorizontally();
        }else{ //if start location is on left, goomba moves right
            speed = 1;
        }
    }

    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() //goomba moving 
    {
        move(speed);
    }    

}
