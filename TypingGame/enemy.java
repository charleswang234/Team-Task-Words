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
    private int speed = -1; 
    private int what = 0;
    /**
     * Act - do whatever the enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        mirror();

    }    

    public void move(){
        if (counter < 3){
            counter ++;
        }else{
            move(speed);
            counter = 0;
        }
    }
    
    private void mirror(){ 
        if (speed < 0 && what == 0){
            getImage().mirrorHorizontally();
            what ++;
        }
    }

}
