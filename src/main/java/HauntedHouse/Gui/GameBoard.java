/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HauntedHouse.Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author jorge
 */
public class GameBoard extends JPanel implements ActionListener{
    
    private final Timer timer;
    
    private final GameMap m;
    private final Player p;
    
    public GameBoard() {
       m = new GameMap();
       p = new Player();
       addKeyListener(new Al());
       setFocusable(true);
       timer = new Timer(25,this);
       timer.start();
    }
  
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        for(int i = 0; i < 14; i++){
            for(int j = 0; j < 14; ++j){
                if(m.getMap(j, i).equals("g")){
                    g.drawImage(m.getGrass(), j * 32, i * 32, null);
                }
                
                if(m.getMap(j, i).equals("w")){
                    g.drawImage(m.getWall(), j * 32, i * 32,null);
                }
            }
        }
        
        g.drawImage(p.getPlayer(), p.getTileX() * 32, p.getTileY() * 32, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    
    public class Al extends KeyAdapter{
        
        @Override
        public void keyPressed(KeyEvent e){
            int keycode = e.getKeyCode();
            
            if(keycode == KeyEvent.VK_W){
               if(!m.getMap(p.getTileX(), p.getTileY() - 1).equals("w")){
                p.move(0,-1);
               }
            }
            
            if(keycode == KeyEvent.VK_S){
                if(!m.getMap(p.getTileX(), p.getTileY() + 1).equals("w")){
                p.move(0,1);
                }
            }
         
            if(keycode == KeyEvent.VK_A){
                if(!m.getMap(p.getTileX() - 1, p.getTileY()).equals("w")){
                p.move(-1, 0);
                }
            }
            
            if(keycode == KeyEvent.VK_D){
                if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("w")){
                p.move(1,0);
                }
            }
        }
        
        public void KeyReleased(KeyEvent e){
       
            
        }
        
        public void KeyTyped(KeyEvent e){
       
            
        }
        
    }
    
}
