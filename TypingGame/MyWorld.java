import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.awt.Color;
/**
 * The main world where the players play the game.
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class MyWorld extends World
{
    Random r = new Random();
    final int randomSpawn = 120; //spawn rate of goombas
    int spawnLeftRight = 0;  //finds what side the enemy will spawn

    //Intializes instance of Actors
    Words words = new Words();
    Scoreboard score = new Scoreboard();
    Mario mario = new Mario();

    int count = 0; //Tracks the number of letters typed so far
    Label label1 = new Label("",50); //The word to be typed
    Label label2 = new Label("",50); //Displays what the player are typing
    Label label3 = new Label("Score: ",50); //Displays the score
    String key; //Tracks last key pressed
    String word1; //Tracks value of label1
    String word2; //Tracks value of label2
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {    
        super(800, 600, 1, false); //creates world 800 x 600 by 1 pixels
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //Adding Mario, the words, and the scoreboard to the world
        addObject(mario,400,545);
        addObject(words,-20,-20);
        addObject(label1,400,50);
        addObject(label2,400,250);
        addObject(label3,150,50);

        score.score = 0; //Resets the current score;
        words.randomWords(); //Queuing up all the words that the player will type
        label1.setValue(words.wordQueue.dequeue()); //Taking the first word from the queue
        label3.setValue("Score: " + score.score); //Sets score to 0

        //Changing the colour of the word the player has inputed
        label2.setLineColor(Color.BLUE);
        label2.setFillColor(Color.BLUE);
        //Changing the colour of the scoreboard
        label3.setLineColor(Color.GREEN);
        label3.setFillColor(Color.GREEN);
    }

    /**
     * This method checks for user input to see if they have typed in the correct letters and words.
     * Also runs the goomba spawn method.
     */
    public void act(){
        key = Greenfoot.getKey();//Checks the last key pressed

        //Gets the word you need to type and the word you have currently typed
        word1 = label1.getLabel();
        word2 = label2.getLabel();

        //Runs the correct word method after typing in the full word
        if(word2.equals(word1)){
            correct();
        }

        //Code to check if the letter you typed in is the correct letter
        if(key != null){
            if (key.equals(word1.substring(count,count+1))){
                label2.setValue(label2.getLabel() + key); //Updates the word the player has typed
                count++; //Updates the amount of letters typed so far
            }
            //Ensures that score is not deducted for moving Mario or when you restart the game
            else if (key.equals("enter") || key.equals("left") || key.equals("right") 
            || key.equals("up") || key.equals("down")){
            }
            else{
                score.score -= 1; //Deducts score for typing in the wrong letter
                label3.setValue("Score: " + score.score); //Updates score
            }
        }
        spawnGoombas();//Spawns Goombas
    }

    /**
     * Runs through a random number generator for a chance to spawn a goomba on the screen.
     */
    public void spawnGoombas(){
        int i = r.nextInt(randomSpawn);
        if (i == 1){
            spawnLeftRight = r.nextInt(2); //Randomizes which side the Goomba will spawn on
            if (spawnLeftRight == 0){ //Spawns goomba on the left
                enemy enemyName = new enemy(0);
                addObject(enemyName,-20,557);
            }else if (spawnLeftRight == 1){ //Spawns goomba on the right
                enemy enemyName = new enemy(800);
                addObject(enemyName,820,557);
            }
        }
    }

    /**
     * Goes through the procedure after typing in a correct word.
     */
    public void correct(){
        //Kills the nearest goomba
        if(mario.getNearestActor() != null){
            removeObject(mario.getNearestActor());
        }
        
        //Procedure to get a new word and updates score
        String oldWord = label1.getLabel();
        words.wordQueue.enqueue(oldWord); //Puts the word back into the queue
        score.score += score.worth(oldWord.length()); //Increasing the score
        label1.setValue(words.wordQueue.dequeue()); //Gets a new word
        label2.setValue(""); //Clears the user input
        label3.setValue(("Score: " + score.score)); //Updates score;
        count = 0;
    }
}
