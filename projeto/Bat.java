import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zumbi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Inimigo
{

 public void act()
    {
        turnAtEdge();
        randomTurn();
        move(1);
        if(hitEnemy()==true){
        getWorld().removeObject(this);
    }
    }

    /**
     * Check whether we are at the edge of the world. If we are, turn a bit.
     * If not, do nothing.
     */
    public void turnAtEdge()
    {
        if ( atWorldEdge() ) 
        {
            turn(17);
        }
    }
    protected boolean hitEnemy()
    {
        Magia m = (Magia) getOneIntersectingObject( Magia.class );
        Explosao exp = (Explosao) getOneIntersectingObject(Explosao.class);
        if ( m != null || exp != null ) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Randomly decide to turn from the current direction, or not. If we turn
     * turn a bit left or right by a random degree.
     */
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) {
            turn(Greenfoot.getRandomNumber(90)-45);
            setImage("images/bat2.png");
        }
            else{
            setImage("images/bat.png");
        }
    }


}
