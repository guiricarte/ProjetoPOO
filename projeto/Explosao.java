import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Explosao extends Slayer
{
    private int life=20;
    public void act() 
    {
        life--;
        if(life==0)
        getWorld().removeObject(this);
        
    }    
    

}
