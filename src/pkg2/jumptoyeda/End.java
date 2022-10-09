/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.jumptoyeda;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import pkg2.jumptoyeda.Game.STATE;




/**
 *
 * @author BooKy
 */
public class End extends KeyAdapter {

    private Game game;
    private Handler handler ;
    
   public End(Game game,Handler handler){
       this.game = game;
       this.handler = handler;
   }
   public void tick() {
     
    }
   public End(Handler handler){
        this.handler = handler;
    }
   public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
       // System.out.println("hello");
   if(key == KeyEvent.VK_ENTER){System.out.println("state");handler.clearLevel();game.gameState = STATE.Menu;}
   }
   public void keyReleased(KeyEvent e){}

   public void render(Graphics g) {
       
       /*
       Font fn1 = new Font("arial",1,100);
       
       g.setColor(Color.black);
       g.setFont(fn1);
       g.drawRect(100, 200, 100, 200);
       g.drawString("Jump To Yeda",200,300);
            */
    }
}
