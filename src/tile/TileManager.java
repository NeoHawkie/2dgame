/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author Wallyson M Lima
 */
public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[10];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        
        getTileImage();
        loadMap("./res/maps/sample.txt");
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/blueBrick.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/lines.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/lines2.png"));
        }catch(IOException error){
            error.printStackTrace();
        }
    }
    
    public void loadMap(String filePath){
        
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();
                
                while(col < gp.maxScreenCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
        }catch(Exception error){
            error.printStackTrace();
        }
                
    }
    
    public void draw(Graphics2D g2){
        /*
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 0, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 0, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 48, gp.tileSize, gp.tileSize, null);
        */
        
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while(col < gp.maxScreenCol && row < gp.maxScreenRow){
            
            int tileNum = mapTileNum[col][row];
            
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
        
    }
}
