import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A simple actor to show the funktion of the full screen mode.
 * Controll the wombat with the arrow keys.
 * 
 * @author Gevater_Tod4711
 * @version 1.1
 */
public class Wombat extends Actor
{
    int speed = 2;
    
    public void act() {
        if (getX() > getWorld().getWidth() - 20 || getX() < 20 || getY() > getWorld().getHeight() - 20 || getY() < 20) {
            speed = -speed;
        }
        if (FullScreenWindow.isKeyDown("left")) {
            turn(-5);
        }
        if (FullScreenWindow.isKeyDown("right")) {
            turn(5);
        }
        //you can also try to make the wombat follow your mouse cursor;
        /*FullScreenMouseInfo mouse = FullScreenWindow.getFullScreenMouseInfo();
        if (mouse != null) {
            turnTowards(mouse.getX(), mouse.getY());
        }*/
        move(speed);
    }
    
    public void move(double distance) throws NullPointerException {
        double angle = Math.toRadians(getRotation());
        int x = (int) Math.round(getX() + Math.cos(angle) * distance);
        int y = (int) Math.round(getY() + Math.sin(angle) * distance);
        setLocation(x, y);
    }
}