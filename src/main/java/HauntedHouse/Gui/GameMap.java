/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HauntedHouse.Gui;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;

/**
 *
 * @author jorge
 */
public class GameMap {
    
    private Scanner mapScanner;
    private String Map[] = new String[14];
    
    private Image grass,
                   wall;

    public GameMap() {
        ImageIcon img = new ImageIcon("images/grass.png");
        grass = img.getImage();
        
        img = new ImageIcon("images/wall.png");
        wall = img.getImage();
        
        openFile("map");
        readFile();
        closeFile();
    }
    
    public Image getGrass(){
        return grass;
    }
    
    public Image getWall(){
        return wall;
    }
    
    public String getMap(int x, int y){
        return Map[y].substring(x,x+1);
    }
    
    public void openFile(String map){
        
        String tmp_map = "images/" + map + ".txt";
        
        try {
            mapScanner = new Scanner(new File(tmp_map));
        } catch (FileNotFoundException ex) {
            System.out.println("map not loaded");
        }
        
        
    }
    
    public void readFile(){
        while(mapScanner.hasNext()){
            for(int i = 0; i < 14; ++i){
                Map[i] = mapScanner.next();
            }
        }
        
    }
    
    public void closeFile(){
        mapScanner.close();
    }
    
    
    
    
    
}
