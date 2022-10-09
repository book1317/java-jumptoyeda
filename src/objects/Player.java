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
import java.io.File;
import java.util.LinkedList;
import java.util.logging.Level;
import javafx.scene.media.AudioClip;
import pkg2.jumptoyeda.Animation;
import pkg2.jumptoyeda.Game;
import pkg2.jumptoyeda.Handler;

/**
 *
 * @author BooKy
 */
public class Player extends GameObject {

    AudioClip shot = new AudioClip(getClass().getResource("/res/shot.mp3").toString());
    
    private float width = 55, height = 75;
    //private float xx = 55, yy = 75;

    protected boolean setFace = false;
    //private boolean falling = true;
    private float gravity = 0.5f;
    private float force = 0.3f;
    private float MAX_SPEED = 10;
    final int shotx  = 5;
    final int shoty = 8;
    

    private Handler handler;

    Texture tex = Game.getInstance();
    
   private Animation playerWalk,playerWalkLeft;
    private Animation player2Walk,player2WalkLeft;

    public Player(float x, float y, Handler handler, ObjectId id) {
        super(x, y, id);
        this.handler = handler;
        
        playerWalk = new Animation(5,tex.player[7],tex.player[8],tex.player[9]);
        playerWalkLeft = new Animation(5,tex.player[1],tex.player[2],tex.player[3]);
   
        player2Walk = new Animation(5,tex.player2[4],tex.player2[5],tex.player2[6]);
        player2WalkLeft = new Animation(5,tex.player2[0],tex.player2[1],tex.player2[2]);
    }

    public void tick(LinkedList<GameObject> object) {
        x += velX;
        y += velY;

        /*  
        if (velX < 0) {
            facingX = -1;
        } else if (velX > 0) {
            facingX = 1;
        }*/
 /* if(shotRight)
            velX = -5;
        if(shotRight)
            velX = 5;*/
       // System.out.println("falling: ");
        if (falling || jumping) {
            velY += gravity;
            if (velY > MAX_SPEED) {
                velY = MAX_SPEED;
            }
        }
        Collision(object);
        
        playerWalk.runAnimation();
        playerWalkLeft.runAnimation();
        
         player2Walk.runAnimation();
        player2WalkLeft.runAnimation();
    }

    private void Collision(LinkedList<GameObject> object) {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ObjectId.Rope) {
                
            }
            if (tempObject.getId() == ObjectId.Block) {
              
                if (getBoundsDown().intersects(tempObject.getBounds()) && velY >= 0) {

                    y = tempObject.getY() - height;
                    velY = 0;
                    falling = false;
                    jumping = false;
                    climing = false;
                    if (shotRight || shotLeft) {
                        velX = 0;
                        shotRight = false;
                        shotLeft = false;
                    }

                } else {
                   falling = true;
                }

                if (getBoundsRight().intersects(tempObject.getBounds())) {
                    // x = tempObject.getX() - width - 2;

                }
                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                    //   x = tempObject.getX() + 35;
                }
            }

            if (tempObject.getId() == ObjectId.Wall) {
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    y = tempObject.getY() + 16;
                    velY = 0;
                }
               
                if (getBoundsDown().intersects(tempObject.getBounds())) {

                    y = tempObject.getY() - height;
                    velY = 0;
   
                    falling = false;
                    
                    jumping = false;
                    if (shotRight || shotLeft) {
                        velX = 0;        
                        shotRight = false;
                        shotLeft = false;  
                    }

                } else {
                    falling = true;
                    
                }

                if (getBoundsRight().intersects(tempObject.getBounds())) {
                    x = tempObject.getX() - width ;

                }
                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                    x = tempObject.getX() + 14;
                }
            }
            if (tempObject.getId() == ObjectId.Bullet) {
                if (getBoundsRight().intersects(tempObject.getBounds())) {
                      tempObject.setX(0);
                      tempObject.setY(0);
                      handler.object.remove(tempObject);
                      shot.play(); 
                    
                    shotRight = true;
                     jumping = true;
                    velX = -shotx;
                    //  if(velY==0)
                    velY = -shoty;
                    

                }
                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                     tempObject.setX(0);
                      tempObject.setY(0);
                       handler.object.remove(tempObject);
                      shot.play(); 
                    shotLeft = true;
                     jumping = true;
                    velX = shotx;
                    //  if(velY==0)
                    velY = -shoty;
                   
                }
            }
            if (tempObject.getId() == ObjectId.Flag) {
                if (getBoundsAll().intersects(tempObject.getBounds())) {
                   // handler.clearLevel();
                   handler.switchLevel();
                }
            }
               if (tempObject.getId() == ObjectId.BlockReset) {
                if (getBoundsAll().intersects(tempObject.getBounds())) {
                   
                   x=-1000;
                   y=-1000;
                   handler.removeObject(this);
               
                  if(Game.LEVEL == 1)
                   handler.addObject(new Player(50,550,handler,id));
                  if(Game.LEVEL == 2)
                   handler.addObject(new Player(50,50,handler,id));
                }
            }
        }
    }

    public void render(Graphics g) {

        if (getId() == ObjectId.Player) {
            if(jumping)
            {
                if(facingX==1)
                    g.drawImage(tex.player[6],(int)x,(int)y,(int)51,(int)76,null);
                    else
                    g.drawImage(tex.player[5],(int)x,(int)y,(int)51,(int)76,null);
                   
            }
            else if(velX != 0)
            {
                if(facingX==1)
                    playerWalk.drawAnimation(g,(int)x,(int)y,(int)51,(int)76);
                  else
                playerWalkLeft.drawAnimation(g,(int)x,(int)y,(int)51,(int)76);
            }
                
             else
                if(facingX==1)
          g.drawImage(tex.player[4], (int) x, (int) y, null);
            else
                      g.drawImage(tex.player[0], (int) x, (int) y, null);
                    
        }

        if (getId() == ObjectId.Player2) {
            /*
            g.drawImage(tex.player2[0], (int) x, (int) y, null);
            if (!setFace) {
                setFacingX(-1);
                setFace = true;
            }*/
             if(jumping)
            {
                if(facingX==1)
                    g.drawImage(tex.player2[7],(int)x,(int)y,(int)62,(int)82,null);
                    else
                    g.drawImage(tex.player2[3],(int)x,(int)y,(int)62,(int)82,null);
                   
            }
            else if(velX != 0)
            {
                if(facingX==1)
                    player2Walk.drawAnimation(g,(int)x,(int)y,(int)62,(int)82);
                  else
                player2WalkLeft.drawAnimation(g,(int)x,(int)y,(int)62,(int)82);
            }
                
             else
                if(facingX==1)
          g.drawImage(tex.player2[4], (int) x, (int) y, null);
            else
                      g.drawImage(tex.player2[0], (int) x, (int) y, null);
            
        }
        

        /*
        if (getId() == ObjectId.Player) {
            g.setColor(Color.blue);
            g.fillRect((int) x, (int) y, (int) width, (int) height);
        }
        if (getId() == ObjectId.Player2) {
            g.setColor(Color.red);
            g.fillRect((int) x, (int) y, (int) width, (int) height);
        }
         */
        
        /*
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.white);
        g2d.draw(getBoundsDown());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsTop());
        g2d.draw(getBoundsAll());*/

    }

    public Rectangle getBoundsAll() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    public Rectangle getBoundsDown() {
        return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) ((int) y + (height - 9)), (int) width / 2, (int) 9);
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) y, (int) width / 2, (int) height / 2);
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) ((int) x + width - 10), (int) y + 5, (int) 6, (int) height - 10);
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x+5, (int) y + 5, (int) 5, (int) height - 10);
    }

}
