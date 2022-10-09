/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

/**
 *
 * @author BooKy
 */
public abstract class GameObject {
    protected float x,y;
    protected ObjectId id;
    protected float velX = 0, velY = 0;
    protected boolean falling = true;
    protected boolean jumping = false;
    protected boolean climing = false;
    protected boolean jerrope = false;
    protected int facingX = 1;
    protected int facingY = 0;
    protected boolean shotRight = false;
    protected boolean shotLeft = false;
    protected int numBullet = 0;
    protected int playerScore = 0;

    
    public GameObject(float x,float y,ObjectId id)
    {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    
    public int getFacingX()
    {
        return facingX;
    }
    public void setFacingX(int facingX)
    {
        this.facingX = facingX;
    }
    public void setFacingY(int facingY) {
        this.facingY = facingY;
    }
    public int getFacingY() {
        return facingY;
    }
    
public float getX() {
        
    return x;}

  
    public float getY() {
    return y;    
    }

   
    public void setX(float x) {
    this.x = x;   
    }

   
    public void setY(float y) {
this.y = y;
    }

   
    public float getVelX() {
      return velX ;
    }

    
    public float getVelY() {
return velY;
        }

  
    public void setVelX(float velX) {
        this.velX = velX;
    }

    
    public void setVelY(float velY) {
      this.velY = velY;  
    }

   
    public ObjectId getId() {
    return id;    
    }
    public boolean isFalling(){
        return falling;
    }
    
    public void setFalling(boolean falling){
        this.falling = falling;
    }
    
    public boolean isJumping(){
        return jumping;
    }
    
    public void setJumping(boolean jumping){
        this.jumping = jumping;
    }

    public boolean isCliming() {
       return climing;
    }
    public void setCliming(boolean climing){
        this.climing = climing;
    }

    public boolean isJerrope() {
       return jerrope;
    }

    public void setJerrope(boolean jerrope) {
    this.jerrope = jerrope;    
    }
public void setNumBullet(int numBullet) {
    this.numBullet = numBullet;    
    }
 
    
}
