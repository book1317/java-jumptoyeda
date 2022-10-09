/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import javafx.scene.media.AudioClip;
import objects.Bullet;
import pkg2.jumptoyeda.Game;
import pkg2.jumptoyeda.Handler;

/**
 *
 * @author BooKy
 */
public class KeyInput extends KeyAdapter {

    private boolean[] keyDown = new boolean[6];
    
    private int i = 0;
AudioClip plonkSound = new AudioClip(getClass().getResource("/res/jump.mp3").toString());
        AudioClip shoot = new AudioClip(getClass().getResource("/res/shoot.mp3").toString());
        
    Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
        keyDown[4] = false;
        keyDown[5] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
          
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ObjectId.Player) {

                if (key == KeyEvent.VK_D && !tempObject.shotRight && !tempObject.shotLeft) {
                    tempObject.setVelX(3);
                    tempObject.setFacingX(1);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_A && !tempObject.shotRight && !tempObject.shotLeft) {
                    tempObject.setVelX(-3);
                    tempObject.setFacingX(-1);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setFacingY(1);
                }
                if (key == KeyEvent.VK_W) {
                    
                    tempObject.setFacingY(-1);
                    keyDown[2] = true;
                         
                }
                 if (key == KeyEvent.VK_W && !tempObject.isJumping()) {
                    tempObject.setJumping(true);
                   
                    plonkSound.play(); 
                    tempObject.setVelY(-10);
                    keyDown[2] = true;
                   
                
                }
                if (key == KeyEvent.VK_SPACE) {
                    tempObject.numBullet++;
                     shoot.play(); 
                    System.out.println("num bullet1 : "+tempObject.numBullet);
                    if (tempObject.getFacingX() == 0) {
                        handler.addObject(new Bullet(tempObject.getX(), tempObject.getY() - 20, ObjectId.Bullet, tempObject.getFacingX() * 15, tempObject.getFacingY() * 15, handler));
                    }
                    if (tempObject.getFacingX() > 0) {
                        handler.addObject(new Bullet(tempObject.getX() + 60, tempObject.getY()+30, ObjectId.Bullet, tempObject.getFacingX() * 15, tempObject.getFacingY() * 15, handler));
                    }
                    if (tempObject.getFacingX() < 0) {
                        handler.addObject(new Bullet(tempObject.getX() - 30, tempObject.getY()+30, ObjectId.Bullet, tempObject.getFacingX() * 15, tempObject.getFacingY() * 15, handler));
                    }
                    
                }
                // if(key == KeyEvent.VK_SPACE & key == KeyEvent.VK_S){
                //  handler.addObject(new Bullet(tempObject.getX()+50,tempObject.getY(),ObjectId.Bullet,tempObject.getFacingX()*30,10,handler));

                //  }
            }

            // if(key == KeyEvent.VK_D)tempObject.setVelX(5);
            //if(key == KeyEvent.VK_D)tempObject.setVelX(5);
            if (tempObject.getId() == ObjectId.Player2) {

                if (key == KeyEvent.VK_RIGHT&& !tempObject.shotRight && !tempObject.shotLeft) {
                    tempObject.setVelX(3);
                    tempObject.setFacingX(1);
                    keyDown[3] = true;
                }
                if (key == KeyEvent.VK_LEFT&& !tempObject.shotRight && !tempObject.shotLeft) {
                    tempObject.setVelX(-3);
                    tempObject.setFacingX(-1);
                    keyDown[4] = true;
                }
                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setFacingY(1);
                }
                if (key == KeyEvent.VK_UP) {
                    tempObject.setFacingY(-1);
                    keyDown[5] = true;
                }
                if (key == KeyEvent.VK_UP && !tempObject.isJumping()) {
                    tempObject.setJumping(true);
                      plonkSound.play(); 
                    tempObject.setVelY(-10);
                    keyDown[5] = true;
                }
                if (key == KeyEvent.VK_NUMPAD0) {
                    tempObject.numBullet++;
                    shoot.play(); 
                    System.out.println("num bullet2:"+tempObject.numBullet);
                   
                        
                    
                        
                    
                    if (tempObject.getFacingX() == 0) {
                        handler.addObject(new Bullet(tempObject.getX(), tempObject.getY() - 20, ObjectId.Bullet, tempObject.getFacingX() * 15, tempObject.getFacingY() * 15, handler));
                    }
                    if (tempObject.getFacingX() > 0) {
                        handler.addObject(new Bullet(tempObject.getX() + 60, tempObject.getY()+30, ObjectId.Bullet, tempObject.getFacingX() * 15, tempObject.getFacingY() * 15, handler));
                    }
                    if (tempObject.getFacingX() < 0) {
                        handler.addObject(new Bullet(tempObject.getX() - 30, tempObject.getY()+30, ObjectId.Bullet, tempObject.getFacingX() * 15, tempObject.getFacingY() * 15, handler));
                    
                }
                   
                }
                // if(key == KeyEvent.VK_SPACE & key == KeyEvent.VK_S){
                //  handler.addObject(new Bullet(tempObject.getX()+50,tempObject.getY(),ObjectId.Bullet,tempObject.getFacingX()*30,10,handler));

                //  }
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ObjectId.Player) {

                if (key == KeyEvent.VK_D) {
                    keyDown[0] = false;
                }
                if (key == KeyEvent.VK_A) {
                    keyDown[1] = false;
                }
                if (key == KeyEvent.VK_W) {
                    tempObject.setFacingY(0);
                    keyDown[2] = false;
                }
                if (key == KeyEvent.VK_W && tempObject.isCliming()) {
                    tempObject.setVelY(0);

                }

                if (key == KeyEvent.VK_S) {
                    tempObject.setFacingY(0);
                }
                // if(key == KeyEvent.VK_D)tempObject.setVelX(5);
                //if(key == KeyEvent.VK_D)tempObject.setVelX(5);
                if (!keyDown[0] && !keyDown[1] && !keyDown[2]) {
                    tempObject.setVelX(0);
                }

            }
            if (tempObject.getId() == ObjectId.Player2) {

                if (key == KeyEvent.VK_RIGHT) {
                    keyDown[3] = false;
                }
                if (key == KeyEvent.VK_LEFT) {
                    keyDown[4] = false;
                }
                if (key == KeyEvent.VK_UP) {
                    tempObject.setFacingY(0);
                    keyDown[5] = false;
                }

                if (key == KeyEvent.VK_DOWN) {
                    tempObject.setFacingY(0);
                }
                // if(key == KeyEvent.VK_D)tempObject.setVelX(5);
                //if(key == KeyEvent.VK_D)tempObject.setVelX(5);
                if (!keyDown[3] && !keyDown[4] && !keyDown[5]) {
                    tempObject.setVelX(0);
                }

            }
        }

    }
}
