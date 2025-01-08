/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.HashSet;
import object.OBJ_Meat;
import java.util.Random;
import object.OBJ_Poop;
/**
 *
 * @author Wallyson M. Lima
 */
public class AssetSetter {
    GamePanel gp;
    Random rng = new Random();
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        HashSet randomX = new HashSet();
        HashSet randomY = new HashSet();
        do{
            randomX.add(4 + rng.nextInt(7));
        }while (randomX.size() != 10);
        do{
            randomY.add(2 + rng.nextInt(7));
        }while (randomY.size() != 10);
        
        gp.obj[0] = new OBJ_Meat();
        gp.obj[0].X =  randomX.* gp.tileSize;
        gp.obj[0].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[1] = new OBJ_Meat();
        gp.obj[1].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[1].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[2] = new OBJ_Meat();
        gp.obj[2].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[2].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[3] = new OBJ_Meat();
        gp.obj[3].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[3].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[4] = new OBJ_Meat();
        gp.obj[4].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[4].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[5] = new OBJ_Meat();
        gp.obj[5].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[5].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[6] = new OBJ_Meat();
        gp.obj[6].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[6].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        
        gp.obj[7] = new OBJ_Poop();
        gp.obj[7].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[7].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[8] = new OBJ_Poop();
        gp.obj[8].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[8].Y = (2 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[9] = new OBJ_Poop();
        gp.obj[9].X = (4 + rng.nextInt(7)) * gp.tileSize;
        gp.obj[9].Y = (2 + rng.nextInt(7)) * gp.tileSize;
    }
    
    public int autoDropCounter = 0;
    
    public void update(){
        autoDropCounter++;
        if (autoDropCounter == GamePanel.dropInterval) {
            gp.obj[0].Y++;
            autoDropCounter = 0;
        }
    }
}
