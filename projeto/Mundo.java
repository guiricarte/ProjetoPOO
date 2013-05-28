import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Mundo extends World
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    private Score score=new Score();
    /**
     * Constructor for objects of class Talisman.
     * 
     */
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
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
        addObject(new Slayer(), 300, 300);
        for(int i=0;i<8;i++){
           addObject(new Bat(), 90, 70);
        }
        if (getObjects(Bat.class).size() == 0){ addBats();  }
    }
    public void addBats(){
        addObject(new Bat(),90,70);
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
}
