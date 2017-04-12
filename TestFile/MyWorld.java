import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Label label1 = new Label("Hello",20);
    Label label2 = new Label("",20);
    Word word = new Word();
    int count = 0;
    Label label3 = new Label("Count: " + count,20);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(label1,300,50);
        addObject(label2,300,350);
        addObject(word,300,200);
        addObject(label3,100,350);
    }
}
