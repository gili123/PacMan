
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sprite {
	 
    private static final int SIZE = 20; // default sprite's dimensions
    protected int image_w, image_h;    // image dimensions
    protected BufferedImage bImage;
    
    protected int locX, locY, dx, dy;

	
    public Sprite(int x, int y, int dx, int dy) 
    {
        locX = x;
        locY = y;
        this.dx = dx;
        this.dy = dy;
       // bImage = img;    
    }
   
    
    public void setImageDimensions()
    {
       
    }
    
    public void setLocX(int locX) {
		this.locX = locX;
	}


	public void setLocY(int locY) {
		this.locY = locY;
	}


	public Rectangle getBoundingBox()
    {
        return new Rectangle(getLocX(), getLocY(), image_w, image_h);
    }

    public int getLocX() {
        return locX;
    }
    
    public int getLocY() {
        return locY;
    }
    
    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
    

    public void updateSprite()
    {
        locX += dx;
        locY += dy;
    }
    
    public void drawSprite(Graphics g)
    {
        //g.fillRect(locX, locY, image_w, image_h);
    	g.drawImage(bImage, locX, locY, image_w, image_h, null);
    }
}

