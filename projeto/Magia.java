import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
