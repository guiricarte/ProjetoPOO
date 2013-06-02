import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Magia extends Slayer
{

    public void act() 
    {
        move(1);
        if( hit()==true || isOnScreenEdge()==true){
            Explosao ex = new Explosao();
            getWorld().addObject(ex, getX(), getY());
            getWorld().removeObject(this);
       
        }
    /*  List de = getIntersectingObjects(Bat.class);
      if (de.size()==1){
       Mundo m = (Mundo)getWorld();
       m.addBats();
    }*/
    }
    protected boolean hit()
    {
        Bat b = (Bat) getOneIntersectingObject(Bat.class);
        if ( b!=null) {
            return true;
        } else {
            return false;
        }
    }


    public boolean isOnScreenEdge()
    {
        final int x = getX();
        final int y = getY();

        return x == 0 || x == Mundo.WIDTH-1 ||
        y == 0 || y == Mundo.HEIGHT-1 ;
    }

}
