/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.jumptoyeda;


import framework.KeyInput;
import framework.ObjectId;
import static framework.ObjectId.Player;
import static framework.ObjectId.Rope;
import static framework.ObjectId.Wall;
import framework.Texture;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import static java.awt.SystemColor.menu;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Random;
import javafx.scene.media.AudioClip;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import objects.Block;
import objects.Flag;
import objects.Player;
import objects.Rope;
import objects.Wall;

/**
 *
 * @author BooKy
 */
public class Game extends Canvas implements Runnable{

   private static final long serialVersionUID = -6261436164361361187L;
   
   protected int n=1;
   
   private boolean running = false;
   private Thread thread;
   
   public static int WIDTH,HEIGHT;
   
   public BufferedImage level,level2,level3,bg1,map1,bullet,map2,end = null;
   public static int LEVEL = 0;
  
   private Menu menu;
   Image image;
   
  Handler handler;
  static Texture tex;
  
  
  
 // Random rand = new Random();
  
  public enum STATE{
    Menu,Game,End
  };
  
  public static STATE gameState = STATE.Menu;
  
  public Game(){
      
  }
  
  public void init()
  {
      WIDTH = getWidth();
      HEIGHT = getHeight();
      
      tex = new Texture();
      
     BufferedImageLoader loader = new BufferedImageLoader();
     
      bullet = loader.loadImage("/res/bullet.png");
     level = loader.loadImage("/res/level.png");
     level2 = loader.loadImage("/res/level2.png");
     bg1 = loader.loadImage("/res/bg1.png");
     map2 = loader.loadImage("/res/map2.png");
     map1 = loader.loadImage("/res/map1.png");
     level3 = loader.loadImage("/res/level3.png");
        end = loader.loadImage("/res/end.png");
        
      handler = new Handler();
      menu = new Menu(this,handler);
      
       URL url = this.getClass().getResource("/res/start.gif");
         image = new ImageIcon(url).getImage();
      
     AudioClip plonkSound = new AudioClip(getClass().getResource("/res/air.mp3").toString());
       
       
      if(gameState == STATE.Game)
      {
          //this.removeKeyListener(menu);
          
         // plonkSound.stop();
          
          
           this.addKeyListener(new KeyInput(handler));
              handler.switchLevel();
           
      }
    
      else if(gameState == STATE.Menu)
        {
            plonkSound.stop();
            plonkSound.play();
            this.addKeyListener(new Menu(handler));
        }
         else if(gameState == STATE.End)
        {
            
                  
            this.addKeyListener(new End(handler));
        }
      
      
     //handler.addObject(new Player(100,100,handler,ObjectId.Player));
     //handler.createLevel();
      
      
      //handler.addObject(new Block(rand.nextInt(800),rand.nextInt(600),ObjectId.Block));
  }
  
     public synchronized void start() {
       if(running)
           return;
       
       running = true;
       thread = new Thread(this);
       thread.start();
    }
     
    public void run() {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amoutOfTicks = 60.0;
        double ns = 1000000000 / amoutOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: "+frames+" TICKS: "+updates);
                frames = 0;
                updates = 0;
            }
        }
        
        System.out.println("Thread has begun");
                }
    
   
    
    public static void main(String args[]){
      new Window(1024,768,"Jump To Yeda",new Game());//780
      //628*628
    }
   private void tick() {
        handler.tick();
        if(gameState == STATE.Game)
        {
            
        }
        else if(gameState == STATE.Menu)
        {
            menu.tick();
        }
        
    }
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
       
        //////Draw Here
        
         
       
        
      //  g.setColor(Color.pink);
      //  g.fillRect(0, 0, getWidth(), getHeight());
        
           //g.drawImage(level, WIDTH, WIDTH, WIDTH, WIDTH, this);
        //  bg1.getGraphics();
       
        
        if(gameState == STATE.Game)
        {
            if(n==1){
                init();n++;
       
 
            }
            if(LEVEL==1)
                  g.drawImage(map1, 0, 0 ,null);
            if(LEVEL==2)
                  g.drawImage(map2, 0, 0 ,null);
            if(LEVEL==3)
                  g.drawImage(bg1, 0, 0 ,null);
           
            handler.render(g);
            
        }
         else if(gameState == STATE.Menu)
        {
            if(n==1){
               
                super.paint(g);
             g.drawImage(image, 0, 0 ,null);
            }
            else
               menu.render(g);
           
        }
        else if(gameState == STATE.End)
        {
            if(n==2){
               
               LEVEL = 0;
                super.paint(g);
             g.drawImage(end, 0, 0 ,null);
             n=1;
          //  init();
            }
            
           
        }
        ////
        g.dispose();
        bs.show();
    }
    
  
   
    public static Texture getInstance(){
        return tex;
    }

 

}
