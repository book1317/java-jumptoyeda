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

/**
 *
 * @author BooKy
 */
public class Wall extends GameObject{

    Texture tex = Game.getInstance();
    private int type;
    
    public Wall(float x, float y,int type,ObjectId id) {
        super(x, y, id);
        this.type = type;
    }

  
    public void tick(LinkedList<GameObject> object) {
        
    }

  
    public void render(Graphics g) {
     //   g.setColor(Color.white);
    //    g.fillRect((int)x, (int) y,16,16);  
    //    g.drawRect((int)x, (int) y,16,16);  
          // g.drawImage(tex.block[type],(int)x,(int)y,null);
       Graphics2D g2d = (Graphics2D) g;
       g.setColor(Color.yellow);
       //     g2d.draw(getBounds());
          
    }

    
    public Rectangle getBounds() {
       return new Rectangle((int)x, (int) y,16,16); 
    }

  
    
    
}
