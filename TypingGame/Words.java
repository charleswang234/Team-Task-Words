import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;

/**
 * Words for Word Game
 * 
 * @author Charles and Victor
 * @version April 2017
 */
public class Words extends Actor
{
    private ArrayList<String> nounsAdjVerbs = new ArrayList<String>();//Arraylist for holding all words
    private final int queueSize = 2000;
    private int number = 0;
    public Queue<String> wordQueue = new Queue<String>();
    public String oldWord = "";
    /**
     * Constructor class of Words
     */
    public Words(){
        Reader read = new Reader();
        Scanner r = read.getScanner("nouns.txt");
        String str = "";
        while (r.hasNext()){    //puts all nouns into hashMap
            str = r.nextLine();
            nounsAdjVerbs.add(str);
        }       

        r = read.getScanner("adjectives.txt");
        while (r.hasNext()){   //puts all adjectives into hashMap
            str = r.nextLine();
            nounsAdjVerbs.add(str);
        }   

        r = read.getScanner("verbs.txt");   
        while (r.hasNextLine()){   //puts all verbs into hashMap
            str = r.nextLine();
            nounsAdjVerbs.add(str);
        }   
    }

    /**
     * Act - do whatever the Mario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }

    public void randomWords(){
        Random r = new Random();
        for(int i = 0; i < queueSize; i++){
            number = r.nextInt(nounsAdjVerbs.size()); 
            wordQueue.enqueue(nounsAdjVerbs.get(number)); 
        }
    }
}
