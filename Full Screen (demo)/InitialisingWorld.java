import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * This world is only used to initialise the scenario.
 * 
 * @author Gevater_Tod4711
 * @version 1.1
 */
public class InitialisingWorld extends World
{
    
    public InitialisingWorld() {
        super(700, 750, 1);
        GreenfootImage desktop = new GreenfootImage("desktop.png");
        GreenfootImage title = new GreenfootImage("Greenfoot\nFull Screen\nDemo", 55, Color.red, new Color(0, 0, 0, 0));
        GreenfootImage text = new GreenfootImage("This demo shows a Full Screen Mode for greenfoot projects.\n\nUsing this demo every greenfoot project can very\neasily be turned into " +
            "a fullscreen project.\n\nTo switch back from the fullscreenwindow you\ncan use the keyboard shortcut Alt + Tab.\n\nTo start a simple demo of a fullscreen\ngame please click " +
            "on the screen abouve.\n\nFor more information about how to use this demo\nplease see the discription abouve.", 30, Color.black, new Color(0, 0, 0, 0));
        getBackground().drawImage(desktop, getWidth()/2 - desktop.getWidth()/2, 25);
        getBackground().drawImage(title, getWidth()/2 - title.getWidth()/2, 40);
        getBackground().drawImage(text, getWidth()/2 - text.getWidth()/2, 325);
        Greenfoot.start();
    }
    
    public void act() {
        /*here I used Greenfoot.mouseClicked (...) because this world is no fullscreen world.
        In your scenario you should use FullScreenWindow.mouseClicked (except in non-fullscreen starting worlds like this one)*/
        if (Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse.getX() > 260 && mouse.getX() < 540 && mouse.getY() > 20 && mouse.getY() < 320) {
                Greenfoot.setWorld(new ExampleWorld());
            }
            //System.out.println(mouse.getX() + " " + mouse.getY());
        }
    }
}