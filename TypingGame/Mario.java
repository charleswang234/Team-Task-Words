import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.List;
/**
 * Main character/protagonist of the game
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
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
        enemy = getOneObjectAtOffset(0,0, enemy.class);
        if (enemy != null){
            World world;
            world = getWorld();
            world.removeObject(enemy);
            Greenfoot.setWorld(new EndScreen());
        }
    }

    public double getDistance(Actor actor){
        return Math.hypot(actor.getX() - getX(), actor.getY() - getY());
    }

    public Actor getNearestActor(){
        List<enemy> nearestActors = getObjectsInRange(1000, enemy.class); //here you can use the radius you want and maybe another class;
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
