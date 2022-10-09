/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import framework.GameObject;
import framework.ObjectId;
import static framework.ObjectId.Bullet;
import framework.Texture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import pkg2.jumptoyeda.BufferedImageLoader;
import pkg2.jumptoyeda.Game;
import pkg2.jumptoyeda.Handler;

/**
 *
 * @author BooKy
 */

public class Bullet extends GameObject{
    


  
    private float width = 12 , height = 12;
    
    private Handler handler;
    
    Texture tex = Game.getInstance();
    //private BufferedImageLoader bullet = null
    
    //private float gravity = 0.5f;
    
    public Bullet(float x, float y, ObjectId id,int velX,int velY,Handler handler) {
        super(x, y, id);
        this.velX = velX;
        this.velY = velY;
        this.handler = handler;
        
       // BufferedImageLoader loader = new BufferedImageLoader();
         //bullet = loader.loadImage("/level.png");
    }

  
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;
       Collision(object);
    }

  
    public void render(Graphics g) {
    //    g.setColor(Color.black);
    //    g.fillRect((int)x,(int)y,(int)width,(int)height);
       
        Graphics2D g2d = (Graphics2D) g;
         g.drawImage(tex.bullet,(int)x,(int)y,null);
     g.setColor(Color.white);
    
       
    //   g2d.draw(getBoundsRight());
    //  g2d.draw(getBoundsLeft());
     //  g2d.draw(getBounds());
      
    }

    
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int) y,(int)width, (int) ((int)height-height/4));
    }
    
       private void Collision(LinkedList<GameObject>object){
           
           for(int i = 0 ;i<handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);
            {
                if(tempObject.getId() == ObjectId.Wall)
            {
                 if(getBounds().intersects(tempObject.getBounds()))
               {
                   //x = tempObject.getX() - width;
                   //velX = 0;
                  
                   
                   handler.removeObject(this);
                 //  handler.object.remove(Bullet);
                }
            }
                if(tempObject.getId() == ObjectId.BlockReset)
            {
                 if(getBounds().intersects(tempObject.getBounds()))
               {
                   //x = tempObject.getX() - width;
                   //velX = 0;
                  
                   
                   handler.removeObject(this);
                 //  handler.object.remove(Bullet);
                }
            }
                if(tempObject.getId() == ObjectId.Player ||tempObject.getId() == ObjectId.Player2)
            {
                 if(getBounds().intersects(tempObject.getBounds()))
               {
                
                   
                   //x = tempObject.getX() - width;
                   //velX = 0;
                  // handler.removeObject(this);
                 //  handler.object.remove(Bullet);
                }
            }
                
              
            }
        
        }
    
}
       
         public Rectangle getBoundsRight() {
       return new Rectangle((int) ((int)x+width-5),(int)y+5,(int)5,(int)height-10);
    }
      public Rectangle getBoundsLeft() {
       return new Rectangle((int)x,(int)y+5,(int)5,(int)height-10);
    }
}
