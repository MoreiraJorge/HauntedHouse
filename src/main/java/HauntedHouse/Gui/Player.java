/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HauntedHouse.Gui;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jorge
 */
public class Player {
    
    private int tileX, tileY;
    
    private Image player;
    
    
    public Player() {
        
       ImageIcon img = new ImageIcon("images/player.png");
       player = img.getImage();
       tileX = 1;
       tileY = 1;
    }
    
    public Image getPlayer(){
        return player;
    }

    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }
    
   
    
    public void move(int dx, int dy){    
        tileX += dx;
        tileY += dy;
    }
    
    
    
}
