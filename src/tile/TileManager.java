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
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        
        tile = new Tile[10];
        //mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow]; //openworld-like settings
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        
        getTileImage();
        loadMap("./res/maps/sample.txt");
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/blueBrick.png"));
            tile[0].collision = true;
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/lines.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/lines2.png"));
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("./res/tiles/XBlock.png"));
            tile[3].collision = true;
            
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
            
            {/*
            while(col < gp.maxWorldCol && row < gp.maxWorldRow){
                String line = br.readLine();
                
                while(col < gp.maxWorldCol){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            */} //openworld-like settings
            
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
        {/*
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 0, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 0, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 48, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 48, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 96, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[0].image, 96, 48, gp.tileSize, gp.tileSize, null);
        */} //manual method of drawing
        
        {/*int worldCol = 0;
        int worldRow = 0;
        //int x = 0;
        //int y = 0;
        
        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            
            int tileNum = mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            
            if (worldX - gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX + gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY - gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY + gp.tileSize < gp.player.worldY + gp.player.screenY) {
                
            }
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            worldCol++;
            //x += gp.tileSize;
            
            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                //x = 0;
                worldRow++;
                //y += gp.tileSize;
            }
        }
      */} //openworld-like settings
        
        int Col = 0;
        int Row = 0;
        int x = 0;
        int y = 0;
        
        while(Col < gp.maxScreenCol && Row < gp.maxScreenRow){
            
            int tileNum = mapTileNum[Col][Row];
            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            
            Col++;
            x += gp.tileSize;
            
            if (Col == gp.maxScreenCol) {
                Col = 0;
                x = 0;
                Row++;
                y += gp.tileSize;
            }
        }
        
    }
}
