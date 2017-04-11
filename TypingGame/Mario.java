import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main character/protagonist of the game
 * 
 * @author Charles Wang and Victor Huang
 * @version April 2017
 */
public class Mario extends Actor
{
    private int direction = 1; // 1 = right and -1 = left
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();
        remove();
    }    
    
     public void checkKey(){
        if (Greenfoot.isKeyDown("right")){
            direction = 2;
            moveRight();
        }
        if (Greenfoot.isKeyDown("left")){
            direction = -2;
            moveLeft();
        }
    }

    public void moveRight(){
        setLocation(getX() + direction, getY());

    }
    
    public void moveLeft(){
        setLocation(getX() + direction, getY());
    }
    
    public void remove(){
        Actor enemy;
        enemy = getOneObjectAtOffset(10, 10, enemy.class);
        if (enemy != null){
            World world;
            world = getWorld();
            world.removeObject(enemy);
        }
    }
}
