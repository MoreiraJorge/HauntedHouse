/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HauntedHouse.Gui;

import javax.swing.JFrame;

/**
 *
 * @author jorge
 */
public class GameWindow {

    public GameWindow() {
        
        JFrame f = new JFrame();
        f.setTitle("Game");
        f.add(new GameBoard());
        f.setSize(500,600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
}
