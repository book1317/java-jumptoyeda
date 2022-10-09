/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.jumptoyeda;

import framework.GameObject;
import framework.ObjectId;
import static framework.ObjectId.BlockReset;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import objects.Block;
import objects.ResetBlock;
import objects.Flag;
import objects.Player;
import objects.Rope;
import objects.Wall;
import static pkg2.jumptoyeda.Game.STATE.End;

/**
 *
 * @author BooKy
 */
public class Handler {
    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    private GameObject tempObject;

    
    private BufferedImage level,level2,level3 = null;
    
    public Handler(){
         
     BufferedImageLoader loader = new BufferedImageLoader();

     level = loader.loadImage("/res/level.png");
     level2 = loader.loadImage("/res/level2.png");
    }
    
    public void tick(){
        for(int i=0;i<object.size();i++)
        {
            tempObject = object.get(i);
            
            tempObject.tick(object);
        }
    }
    public void clearLevel(){
        object.clear();
    }
    
    
    
    public void render(Graphics g)
    {
        for(int i=0;i<object.size();i++)
        {
            tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
     public void LoadImageLevel(BufferedImage image){
       
       int w = image.getWidth();
       int h = image.getHeight();
       
       System.out.println("width, height: "+w+" "+h);
       
        for(int xx = -16;xx<h+108;xx++){
               addObject(new ResetBlock(xx*16,-502,0,ObjectId.BlockReset));
           }
        
              addObject(new ResetBlock(-16,768,0,ObjectId.BlockReset));
              addObject(new ResetBlock(-32,768,0,ObjectId.BlockReset));
           
        for(int yy =-16;yy<w+108;yy++){
            addObject(new ResetBlock(-96,yy*16,0,ObjectId.BlockReset));
        }
       
       
       for(int xx = 0;xx<h;xx++){
           for(int yy =0;yy<w;yy++){
               int pixel = image.getRGB(xx,yy);
               int red = (pixel >>16)&0xff;
               int green = (pixel >>8) & 0xff;
               int blue = (pixel)& 0xff;
               
               //need to render player last
               
               
               if(red == 255 && green == 255 & blue == 255)addObject(new Block(xx*16,yy*16,0,ObjectId.Block));
               if(red == 100 && green == 0 & blue == 255){addObject(new ResetBlock(xx*16,yy*16,0,ObjectId.BlockReset));
               
               }
               if(red == 128 && green == 128 & blue == 128)addObject(new Wall(xx*16,yy*16,0,ObjectId.Wall));
               if(red == 255 && green == 216 & blue == 0)addObject(new Flag(xx*16,yy*16,0,ObjectId.Flag));
               if(red == 0 && green == 255 & blue == 33)addObject(new Rope(xx*16,yy*16,0,ObjectId.Rope,this));
          
           }
       }
         for(int xx = 0;xx<h;xx++){
           for(int yy =0;yy<w;yy++){
               int pixel = image.getRGB(xx,yy);
               int red = (pixel >>16)&0xff;
               int green = (pixel >>8) & 0xff;
               int blue = (pixel)& 0xff;
               
               //render player last
      
               if(red == 0 && green == 0 & blue == 255)addObject(new Player(xx*16,yy*16,this,ObjectId.Player));
               if(red == 255 && green == 0 & blue == 0)addObject(new Player(xx*16,yy*16,this,ObjectId.Player2));
              
           }
       }
   }
     public void LoadPlayer(BufferedImage image){
       
       int w = image.getWidth();
       int h = image.getHeight();
       
      
       
      
         for(int xx = 0;xx<h;xx++){
           for(int yy =0;yy<w;yy++){
               int pixel = image.getRGB(xx,yy);
               int red = (pixel >>16)&0xff;
               int green = (pixel >>8) & 0xff;
               int blue = (pixel)& 0xff;
               
               //render player last
      
               if(red == 0 && green == 0 & blue == 255)addObject(new Player(xx*16,yy*16,this,ObjectId.Player));
               if(red == 255 && green == 0 & blue == 0)addObject(new Player(xx*16,yy*16,this,ObjectId.Player2));
              
           }
       }
   }
     
     
      public void switchLevel(){
      
             clearLevel();
             Game.LEVEL++;
            switch(Game.LEVEL)
            {
                case 1:
                         LoadImageLevel(level);
                            break;
                case 2:
                    LoadImageLevel(level2);
                            break;
                            case 3:
                   Game.gameState = End;
                            break;
                
            }
            
           
      }
      
    
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    /*
 public void createLevel()
    {
        for(int xx = 0;xx<Game.WIDTH+32;xx+=32)
        addObject(new Block(xx,Game.HEIGHT-32,ObjectId.Block));
        
        for(int yy = 0;yy<Game.HEIGHT+32;yy+=32)
        {
        addObject(new Block(0,yy,ObjectId.Block));
        addObject(new Block(Game.WIDTH-32,yy,ObjectId.Block));
        }
        
        for(int jj=0;jj<Game.WIDTH-336;jj+=32)
        addObject(new Block(jj+108,Game.HEIGHT-200,ObjectId.Block));
  
    }*/
    
}
