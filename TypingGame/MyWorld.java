import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Typing Game computer science
 * 
 * @author Charles and Victor
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    final int randomSpawn = 400; //spawn rate of goombas
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1000, 700, 1);  //creates world 800 x 600 by 1 pixels
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Mario mario = new Mario();
        addObject(mario,475,638);

        Words words = new Words();
        addObject(words,0,0);

        enemy enemy = new enemy(0);
        addObject(enemy,2,652);
    }
    
     public void act(){
    }
    
}
