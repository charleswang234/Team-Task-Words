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
    
     public void checkKey(){ //checking if key is down
        if (Greenfoot.isKeyDown("right")){
            direction = 3;
            moveRight();
        }
        if (Greenfoot.isKeyDown("left")){
            direction = -3;
            moveLeft();
        }
    }

    public void moveRight(){ //moving right
        setLocation(getX() + direction, getY());

    }
    
    public void moveLeft(){ // moving left
        setLocation(getX() + direction, getY());
    }
    
    public void remove(){ //if enemy touches mario, game ends, displays end screen
        Actor enemy;
        enemy = getOneObjectAtOffset(10, 10, enemy.class);
        if (enemy != null){
            World world;
            world = getWorld();
            world.removeObject(enemy);
            Greenfoot.setWorld(new EndScreen());
        }
    }
}
