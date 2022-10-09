/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import framework.GameObject;
import framework.ObjectId;
import framework.Texture;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import pkg2.jumptoyeda.Game;
import pkg2.jumptoyeda.Handler;

/**
 *
 * @author BooKy
 */
public class Rope extends GameObject{

    Texture tex = Game.getInstance();
    private int type;
    
    private Handler handler;
    
    public Rope(float x, float y,int type,ObjectId id,Handler handler) {
        super(x, y, id);
        this.type = type;
        this.handler = handler;
    }

  
    public void tick(LinkedList<GameObject> object) {
        Collision(object);
    }

  
    public void render(Graphics g) {
       
        g.setColor(Color.yellow);
        g.fillRect((int)x+4, (int) y,4,16);  
        g.drawRect((int)x+4, (int) y,4,16); 
           //g.drawImage(tex.block[type],(int)x,(int)y,null);
           
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.black);
            g2d.draw(getBounds());
          
    }

    
    public Rectangle getBounds() {
       return new Rectangle((int)x+4, (int) y,4,16); 
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
                   //handler.removeObject(this);
                 //  handler.object.remove(Bullet);
                }
            }
                if(tempObject.getId() == ObjectId.Player)
            {
                 if(getBounds().intersects(tempObject.getBounds()))
               {
                   //x = tempObject.getX() - width;
                   //velX = 0;
                  // handler.removeObject(this);
                 //  handler.object.remove(Bullet);
                   
                   tempObject.setJerrope(true);
                 
                  // tempObject.setFalling(false);
                  // tempObject.setJumping(false);

                  // System.out.println("helo");
                }
                 else 
                 {
                     
                     tempObject.setJerrope(false);
                 }
                 
            }
                if(tempObject.getId() == ObjectId.Player2)
                {
                    if(getBounds().intersects(tempObject.getBounds()))
               {
                   //x = tempObject.getX() - width;
                   //velX = 0;
                  // handler.removeObject(this);
                 //  handler.object.remove(Bullet);
                   
                   tempObject.setJerrope(true);
                 
                  // tempObject.setFalling(false);
                  // tempObject.setJumping(false);

                  // System.out.println("helo");
                }
                 else 
                 {
                     
                     tempObject.setJerrope(false);
                 }
                }
                
              
            }
        
        }
    
}
    
    

  
    
    
}
