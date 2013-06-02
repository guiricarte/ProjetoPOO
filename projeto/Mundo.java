import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mundo extends World
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private Score score=new Score();
    public Kills kill = new Kills();
    /**
     * Constructor for objects of class Talisman.
     * 
     */
    public Mundo()
    {    
        super(800, 600, 1);
        prepare();
    }

    private final void removeAll()
    {
        removeObjects( getObjects(null) );
    }
    private void prepare()
    {
        addObject( score, 0, 0 );
        addObject( kill, 0, 0);
        addObject(new Slayer(), 300, 300);
        for(int i=0;i<8;i++){
           addObject(new Bat(), 90, 70);
        }


    }
    public void addBats(){
        Bat bat = new Bat();
        addObject(bat, 90, 70);
        //addObject(bat, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));  
    }
    public final void startGame()
    {
        removeAll();
        prepare();
    }
        public void decrementScore(int amount)
    {
        if ( score != null ) {
            score.decrement( amount );
        }
    }
     public void incrementKill(int amount)
    {
        if ( kill != null ) {
            kill.increment(amount);
        }
    }
}
