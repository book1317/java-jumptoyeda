/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import java.awt.image.BufferedImage;
import pkg2.jumptoyeda.BufferedImageLoader;

/**
 *
 * @author BooKy
 */


public class Texture {
    SpriteSheet bs,ps,ps2;
    private BufferedImage block_sheet = null;
    private BufferedImage player_sheet = null;
     private BufferedImage player2_sheet = null;
     
     public BufferedImage bullet = null;    
    public BufferedImage[] block = new BufferedImage[2];
    public BufferedImage[] player = new BufferedImage[20];
    public BufferedImage[] player2 = new BufferedImage[20];
     
    public Texture(){
        
        BufferedImageLoader loader = new BufferedImageLoader();
        
        try{
            block_sheet = loader.loadImage("/res/block_sheet.png");
            player_sheet = loader.loadImage("/res/player_sheet.png");
            player2_sheet = loader.loadImage("/res/player2_sheet.png");
            bullet = loader.loadImage("/res/bullet.png");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        bs = new SpriteSheet(block_sheet);
        ps = new SpriteSheet(player_sheet);
        ps2 = new SpriteSheet(player2_sheet);
        
        
        getTextures();
    }

    private void getTextures() {
        int height = 76;
        int width = 51;
        int height2 = 82;
        int width2 = 62;
        block[0] = bs.grabImage(1,1,16,16);//dirt block
        block[1] = bs.grabImage(2,1,32,32);//grass block
        
        player[0] = ps.grabImage(1, 1, width, height);
        player[1] = ps.grabImage(2, 1, width, height);
        player[2] = ps.grabImage(3, 1, width, height);
        player[3] = ps.grabImage(4, 1, width, height);
        player[4] = ps.grabImage(1, 2, width, height);
        
        player[5] = ps.grabImage(4, 1, width, height);//jump
        player[6] = ps.grabImage(4, 2, width, height);
        
        player[7] = ps.grabImage(2, 2, width, height);
        player[8] = ps.grabImage(3, 2, width, height);
        player[9] = ps.grabImage(4, 2, width, height);
        player[10] = ps.grabImage(11, 1, 32, 64);
        player[11] = ps.grabImage(12, 1, 32, 64);
        player[12] = ps.grabImage(13, 1, 32, 64);
        
        player[13] = ps.grabImage(14, 1, 32, 64);
        player[14] = ps.grabImage(15, 1, 32, 64);
        
        //plsyer 2
        
        player2[0] = ps2.grabImage(1, 2, width2, height2);
        player2[1] = ps2.grabImage(2, 2, width2, height2);
        player2[2] = ps2.grabImage(3, 2, width2, height2);
        
        
        player2[4] = ps2.grabImage(1, 3, width2, height2);
        player2[5] = ps2.grabImage(2, 3, width2, height2);
        player2[6] = ps2.grabImage(3, 3, width2, height2);
        
        player2[7] = ps2.grabImage(4, 3, width2, height2);//jump
        player2[3] = ps2.grabImage(4, 2, width2, height2);
    }
}
