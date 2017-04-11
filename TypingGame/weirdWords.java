import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class weirdWords here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class weirdWords extends Actor
{
    private GreenfootImage me;
    private int number;

    public weirdWords(){
        me = new GreenfootImage(50,50);    
        drawBlankImage();
        number=0;
    }

    public void act() 
    {
        checkKey();
    }

    private void checkKey(){
        if (Greenfoot.isKeyDown("space")){
            number=setRandom();
            drawBlankImage();
            drawRandomNumber();
        }
    }

    private int setRandom(){
        return Greenfoot.getRandomNumber(99)+1;
    }

    private void drawRandomNumber(){
        me.setColor(Color.RED);
        me.drawString(" "+number,10,10);
        setImage(me);
    }

    private void drawBlankImage(){
        me.setColor(Color.BLACK);
        me.fill();
        setImage(me);
    }
}
