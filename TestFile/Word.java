import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Word here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Word extends Actor
{
    /**
     * Act - do whatever the Word wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        String key = Greenfoot.getKey();
        String word = ((MyWorld)getWorld()).label1.getLabel();
        String word2 = ((MyWorld)getWorld()).label2.getLabel();
        int count = ((MyWorld)getWorld()).count;
        if(word2.equals(word)){
            Greenfoot.stop();
        }
        if(key != null){
            if (key.equals(word.substring(count,count+1))){
                ((MyWorld)getWorld()).label2.setValue(((MyWorld)getWorld()).label2.getLabel() + key);
                ((MyWorld)getWorld()).count++;
                ((MyWorld)getWorld()).label3.setValue("Count: " + ((MyWorld)getWorld()).count);
            }
        }
    }    
}
