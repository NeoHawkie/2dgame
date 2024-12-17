/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import object.OBJ_Meat;

/**
 *
 * @author Wallyson M. Lima
 */
public class AssetSetter {
    GamePanel gp;
    
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        gp.obj[0] = new OBJ_Meat();
        gp.obj[0].X = 8 * gp.tileSize;
        gp.obj[0].Y = 6 * gp.tileSize;
    }
}
