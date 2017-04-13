import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.List;
/**
 * Main character/protagonist of the game.
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class Mario extends Actor
{
    private int direction = 1; // 1 = right and -1 = left
    private boolean flipHorizontally = false; //check whether to flip the image horizontally 
    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();
        remove();
    }    

    /**
     * Checks what movement is down and flips Mario to the right orientation.
     */
    public void checkKey(){
        if (Greenfoot.isKeyDown("right")){
            direction = 3;
            moveRight();
            if (flipHorizontally){
                flipHorizontally = false;
                getImage().mirrorHorizontally();
            }
        }
        if (Greenfoot.isKeyDown("left")){
            direction = -3;
            moveLeft();
            if (!flipHorizontally){
                flipHorizontally = true;
                getImage().mirrorHorizontally();
            }
        }
    }

    public void moveRight(){ //moving right
        setLocation(getX() + direction, getY());
    }

    public void moveLeft(){ // moving left
        setLocation(getX() + direction, getY());
    }

    /**
     * Checks for if Mario collides with a goomba or not. Will send player to end screen if so.
     */
    public void remove(){
        Actor enemy;
        enemy = getOneObjectAtOffset(0,0, enemy.class);
        if (enemy != null){
            World world;
            world = getWorld();
            world.removeObject(enemy);
            Scoreboard.finalScore = ((MyWorld)getWorld()).score.score; //Tracks the final score
            Greenfoot.setWorld(new EndScreen());
        }
    }

    /**
     * Calculates the distance between a goomba and Mario.
     */
    public double getDistance(Actor actor){
        return Math.hypot(actor.getX() - getX(), actor.getY() - getY());
    }

    /**
     * Checks and returns the closest goomba to Mario.
     */
    public Actor getNearestActor(){
        List<enemy> nearestActors = getObjectsInRange(1000, enemy.class); //Puts all the goombas in a 1000pixel radius into a list.
        
        //If the list is not empty, finds the nearest goomba.
        if(!nearestActors.isEmpty()){
            enemy nearestActor = null;
            double nearestDistance = getDistance(nearestActors.get(0));
            nearestActor = nearestActors.get(0);
            double distance;
            for (int i = 0; i < nearestActors.size(); i++) {
                distance = getDistance(nearestActors.get(i));
                if (distance < nearestDistance) {
                    nearestActor = nearestActors.get(i);
                    nearestDistance = distance;
                }
            }
            return nearestActor;
        }
        return null;
    }
}
