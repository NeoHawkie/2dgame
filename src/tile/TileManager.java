/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import main.GamePanel;

/**
 *
 * @author Wallyson M Lima
 */
public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[10];
        getTileImage();
    }
    
    public void getTileImage(){
        
    }
}
