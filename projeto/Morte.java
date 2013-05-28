import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Morte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Morte extends Actor
{
    /**
     * Act - do whatever the Morte wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
           if(Greenfoot.isKeyDown("enter")){
            final Mundo game = (Mundo) getWorld();
            game.startGame();
            game.decrementScore(1);
    }
    }

}
