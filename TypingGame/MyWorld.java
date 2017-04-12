import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Typing Game computer science
 * 
 * @author Charles and Victor
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    final int randomSpawn = 400; //spawn rate of goombas
    Random r = new Random();
    int spawnLeftRight = 0;  //find what side enemy will spawn
    int numberOfEnemies = 0; //counts the number of enemies
    String enemyName = ""; 

    int count = 0; //Number of letter typed so far
    Label label1 = new Label("Hello",50); //Word to be typed
    Label label2 = new Label("",50); //Displays what you are typing
    String key; //Tracks last key pressed
    String word1; //Tracks value of label1
    String word2; //Tracks value of label2
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(800, 600, 1, false);  //creates world 800 x 600 by 1 pixels
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Mario mario = new Mario();
        addObject(mario,400,545);

        Words words = new Words();
        addObject(words,0,0);

        addObject(label1,500,50);
        addObject(label2,500,350);
    }

    public void act(){
        key = Greenfoot.getKey();
        word1 = label1.getLabel();
        word2 = label2.getLabel();
        if(word2.equals(word1)){
            label2.setValue("");
            count = 0;
        }
        if(key != null){
            if (key.equals(word1.substring(count,count+1))){
                label2.setValue(label2.getLabel() + key);
                count++;
            }
        }
        spawnGoombas();
    }

    public void spawnGoombas(){
        int i = r.nextInt(randomSpawn);
        if (i == 1){
            numberOfEnemies++;
            spawnLeftRight = r.nextInt(2);
            enemyName = "goomba" + Integer.toString(numberOfEnemies);

            if (spawnLeftRight == 0){
                enemy enemyName = new enemy(0);
                addObject(enemyName,-20,557);
            }else if (spawnLeftRight == 1){
                enemy enemyName = new enemy(800);
                addObject(enemyName,820,557);
            }
        }
    }
}

    
    
