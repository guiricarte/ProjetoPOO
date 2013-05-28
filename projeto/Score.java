import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;

/**
 * 
 * 
 * @author Joseph Lenton
 */
public class Score  extends Actor
{
    private static final Font FONT = Font.decode("ARIAL-18");
    private static final int X_PADDING = 10;
    private static final int Y_PADDING = 2;
    
    private static final String PREFIX = "Vidas: ";
    private int score;
    
    public Score()
    {
        this.score = 3;
    }
    
    @Override
    public void addedToWorld(World world)
    {
        updateImage();
    }
    
    private final void updateImage()
    {
        final Graphics2D g = getImage().getAwtImage().createGraphics();
        final String displayText = PREFIX + score;
        final Rectangle2D displayTextSize = g.getFontMetrics( FONT ).getStringBounds( displayText, g );
        final GreenfootImage img = new GreenfootImage(
                (int)displayTextSize.getWidth(),
                (int)displayTextSize.getHeight()
        );

        img.setColor( Color.WHITE );
        img.setFont( FONT );
        img.drawString( displayText, 0, (int)displayTextSize.getHeight() );
        
        setImage( img );
        setLocation( X_PADDING + img.getWidth()/2, Y_PADDING + img.getHeight()/2 );
    }
   
    public void decrement(int amount)
    {
        score -= amount;
        updateImage();
        if(score==0)
        Greenfoot.stop();
    }
}
