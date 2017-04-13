import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
/**
 * Scoreboard class keeps track of the player's score and how much each word is worth.
 * 
 * @author Charles Wang and Victor Huang
 * @version April 12, 2017
 */
public class Scoreboard extends Actor
{
    public int score = 0; //Holds the score
    public static int finalScore = 0; //Holds the final score when players lose the game
    //intializing Hashmap that holds <word length, word worth>
    private HashMap<Integer, Integer> wordScore = new HashMap<Integer, Integer>();
    
    /**
     * Gives worth to all words according to a specified length range when instantiating the scoreboard.
     */
    public Scoreboard(){
        for (int i = 0; i < 20; i++){
            if (i < 7){
                wordScore.put(i,8);
            }
            else if(i < 11){
                wordScore.put(i,15);
            }
            else if(i < 15){
                wordScore.put(i,26);
            }
            else{
                wordScore.put(i,60);
            }
        }
    }
    
    /**
     * Checks the length of the correct word that was typed and gives the value associated with that length.
     */
    public int worth(int length){
        return wordScore.get(length);
    }
}
