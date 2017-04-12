import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
    private int counter = 0; 
    private int speed = 0; 
    public int xValue;
    
    public enemy(int x){
        xValue = x; 
        if (xValue > 350){
         speed = - 1;
         getImage().mirrorHorizontally();
        }else{
            speed = 1;
        }
    }
    
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    

    public void move(){
        if (counter < 3){
            counter ++;
        }else{
            move(speed);
            counter = 0;
        }
   }

}
