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
    int count = 0; //Number of letter typed so far
    Scoreboard score = new Scoreboard();
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
        super(1000, 700, 1);  //creates world 800 x 600 by 1 pixels
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        score.score = 0; //Resets the current score;
        
        Mario mario = new Mario();
        addObject(mario,475,638);

        Words words = new Words();
        addObject(words,0,0);

        enemy enemy = new enemy(0);
        addObject(enemy,2,652);

        addObject(label1,500,50);
        addObject(label2,500,350);
        addObject(label3,100,450);
        label1.setValue(words.randomWords());
        label3.setValue("Score: " + score.score); //Sets score to 0
    }

    public void act(){
        key = Greenfoot.getKey();
        word1 = label1.getLabel();
        word2 = label2.getLabel();
        if(word2.equals(word1)){
            label2.setValue("");
            score.score += 10;
            label3.setValue(("Score: " + score.score));
            count = 0;
        }
        if(key != null){
            if (key.equals(word1.substring(count,count+1))){
                label2.setValue(label2.getLabel() + key);
                count++;
            }
        }
    }

}
