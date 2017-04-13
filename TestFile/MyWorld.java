import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    int count = 0;
    Label label1 = new Label("Hello",20);
    Label label2 = new Label("",20);
    Label label3 = new Label("Count: " + count,20);
    String key;
    String word1;
    String word2;
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
        addObject(label3,100,350);
    }

    public void act(){
        key = Greenfoot.getKey();
        word1 = label1.getLabel();
        word2 = label2.getLabel();
        if(word2.equals(word1)){
            Greenfoot.stop();
        }
        if(key != null){
            if (key.equals(word1.substring(count,count+1))){
                label2.setValue(label2.getLabel() + key);
                count++;
                label3.setValue("Count: " + count);
            }
        }
    }
}
