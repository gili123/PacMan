
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shay Tavor
 */
public class Sprite {
    private static final int SIZE = 20; // default sprite's dimensions
    private BufferedImage bImage;
    protected int imageWidth, imageHeight; // image dimensions
    
    protected int locX, locY, dx, dy;
    protected int pWidth, pHeight;  // panel's dimensions
    public static final int win_width = 1050;
	public static final int win_height = 800;
    public Sprite(int x, int y, int dx, int dy, BufferedImage img) 
    {
        locX = x;
        locY = y;
        this.dx = dx;
        this.dy = dy;
        pWidth = win_width;
        pHeight = win_height;
        bImage = img;
        if(bImage != null)
        {
            imageWidth = bImage.getWidth(null);
            imageHeight = bImage.getHeight(null);
        }
        else
            setImageDimensions();     
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
        return new Rectangle(getLocX(), getLocY(), imageWidth, imageHeight);
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
    
    public int getImageWidth() { 
        return imageWidth;
    }
    
    public int getImageHeight()
    {
        return imageHeight;
    }
    public void updateSprite()
    {
        locX += dx;
        locY += dy;
    }
    
    public void drawSprite(Graphics g)
    {
        g.fillRect(locX, locY, imageWidth, imageHeight);
    	g.drawImage(bImage, locX, locY, null);
    }
}

