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
    Words words = new Words();
    Scoreboard score = new Scoreboard();
    Mario mario = new Mario();

    int count = 0; //Number of letter typed so far
    Label label1 = new Label("",50); //Word to be typed
    Label label2 = new Label("",50); //Displays what you are typing
    Label label3 = new Label("Score: ",50);
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
        addObject(mario,400,545);

        addObject(words,0,0);

        addObject(label1,500,50);
        addObject(label2,500,350);
        addObject(label3,100,450);

        score.score = 0; //Resets the current score;
        words.randomWords();
        label1.setValue(words.wordQueue.dequeue());
        label3.setValue(("Score: " + score.score));
        label3.setValue("Score: " + score.score); //Sets score to 0
    }

    public void act(){
        key = Greenfoot.getKey();
        word1 = label1.getLabel();
        word2 = label2.getLabel();
        if(word2.equals(word1)){
            correct();
        }
        if(key != null){
            if (key.equals(word1.substring(count,count+1))){
                label2.setValue(label2.getLabel() + key);
                count++;
            }
            else{
                score.score -= 1;
                label3.setValue(("Score: " + score.score));
            }
        }
        spawnGoombas();
    }

    public void spawnGoombas(){
        int i = r.nextInt(randomSpawn);
        if (i == 1){
            spawnLeftRight = r.nextInt(2);

            if (spawnLeftRight == 0){
                enemy enemyName = new enemy(0);
                addObject(enemyName,-20,557);
            }else if (spawnLeftRight == 1){
                enemy enemyName = new enemy(800);
                addObject(enemyName,820,557);
            }
        }
    }

    public void correct(){
        String oldWord = label1.getLabel();
        if(mario.getNearestActor() != null){
            removeObject(mario.getNearestActor());
        }
        score.score += score.worth(oldWord.length());
        label2.setValue("");
        label1.setValue(words.wordQueue.dequeue());
        words.wordQueue.enqueue(oldWord);
        label3.setValue(("Score: " + score.score));
        count = 0;
    }
}
