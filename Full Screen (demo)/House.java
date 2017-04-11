import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A simple actor to show the funktion of the full screen mode.
 * This actor will reakt on mousePressed and mouseClicked events.
 * 
 * @author Gevater_Tod4711
 * @version 1.1
 */
public class House extends Actor
{
    
    public void act() {
        if (FullScreenWindow.mousePressed(null)) {
            setImage(new GreenfootImage("Mouse Pressed", 30, Color.red, new Color(0, 0, 0, 0)));
        }
        else {
            setImage(new GreenfootImage("house-05.png"));
        }
        if (FullScreenWindow.mouseClicked(this)) {
            getWorld().addObject(new Wombat(), 100, 100);
        }
    }
}