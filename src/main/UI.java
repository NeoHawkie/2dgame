/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import object.OBJ_Meat;

/**
 *
 * @author Wallyson M. Lima
 */
public class UI {
    GamePanel gp;
    Font arial_30;
    BufferedImage meatImage;
    
    public UI(GamePanel gp){
        this.gp = gp;
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        OBJ_Meat meat = new OBJ_Meat();
        meatImage = meat.image;
    }
    
    public void draw(Graphics2D g2){
        g2.setFont(arial_30);
        g2.setColor(Color.white);
        g2.drawImage(meatImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.hasMeat, 74, 50);
    }
}
