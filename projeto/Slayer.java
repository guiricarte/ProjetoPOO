import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Slayer extends Actor 
{
    public int hp=150;
    //private int contador=1;
    public void act()
    {
        moveAndTurn();
        tiro();
        //vida();
        if(morte()==true){
        Morte morreu = new Morte();
        getWorld().addObject(morreu,this.getX(),this.getY());
        getWorld().removeObject(this);
        }
    }

    public void moveAndTurn(){

        if(Greenfoot.isKeyDown("left")){
            setImage("images/slayerLeft.png");
            setRotation(180);
            move(1);
        }
        if(Greenfoot.isKeyDown("right")){
            setImage("images/slayerRight.png");
            setRotation(360);
            move(1);
        }

        if(Greenfoot.isKeyDown("up")){
            setImage("images/slayerUp.png");
            setRotation(270);
            move(1);
        }
        if(Greenfoot.isKeyDown("down")){
            setImage("images/slayerDown.png");
            setRotation(90);
            move(1);
        }
    }

    public void tiro(){

        if("space".equals(Greenfoot.getKey())){
            Greenfoot.playSound("Sakura_Hadouken.mp3");
            Magia magia = new Magia();
            getWorld().addObject(magia,this.getX(),this.getY());
            magia.setRotation(getRotation());
        }

    }

    public void remove(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) 
        {
            getWorld().removeObject(actor);
            if (getWorld() == null) return;
        }
    }
    protected boolean morte()
    {
        Bat b = (Bat) getOneIntersectingObject(Bat.class );
       
        if ( b != null){
            hp--;
            if (Greenfoot.getRandomNumber(100) > 40)
            setImage("images/slayerDamage.png");

        }  
        if(hp==0)
            return true;
        
         else {
            return false;
        }
    }
}