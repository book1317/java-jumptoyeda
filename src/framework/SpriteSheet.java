/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import java.awt.image.BufferedImage;

/**
 *
 * @author BooKy
 */
public class SpriteSheet {
    
    private BufferedImage image;
    
    public SpriteSheet(BufferedImage image){
        this.image = image;
    }
    public BufferedImage grabImage(int col,int row ,int width,int height){
        BufferedImage img = image.getSubimage((col*width)-width,(row*height)-height,width,height);
       
        return img;
    }
      public BufferedImage getImage(int col,int row ,int width,int height){
        BufferedImage img = image.getSubimage(col,row,width,height);
       
        return img;
    }
}
