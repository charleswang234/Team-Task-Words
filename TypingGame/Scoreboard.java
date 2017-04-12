import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
/**
 * Write a description of class Scoreboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scoreboard extends Actor
{
    public int score = 0;
    private HashMap<Integer, Integer> wordScore = new HashMap<Integer, Integer>(); 
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
    public int worth(int length){
        return wordScore.get(length);
    }
}
