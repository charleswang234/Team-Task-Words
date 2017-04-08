import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Words for Word Game
 * 
 * @author Charles and Victor
 * @version April 2017
 */
public class Words extends Actor
{

    public void addWord(){

    }

    private GreenfootImage me;
    private int number;

    public Words(){
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
