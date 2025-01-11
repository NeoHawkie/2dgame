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
    Font arial_30, arial_90B;
    BufferedImage meatImage;
    double playTime = 0;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    
    public UI(GamePanel gp){
        this.gp = gp;
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        arial_90B = new Font("Arial", Font.BOLD, 90);
        OBJ_Meat meat = new OBJ_Meat();
        meatImage = meat.image;
    }
    
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        if (gameFinished) {
            
            //message #1
            g2.setFont(arial_30);
            g2.setColor(Color.white);
            String text = "You ate 'em all!";
            int textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            int x = gp.ScreenWidth/2 - textLen + gp.tileSize*2;
            int y = gp.ScreenHeight/2 - (gp.tileSize*5);
            g2.drawString(text, x, y);
            
            //message #2
            g2.setFont(arial_90B);
            g2.setColor(Color.CYAN);
            text = "Congrats!";
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.ScreenWidth/2 - textLen + gp.tileSize*4+20;
            y = gp.ScreenHeight/2 + (gp.tileSize*1);
            g2.drawString(text, x, y);
            
            g2.setFont(arial_30);
            g2.setColor(Color.white);
            text = String.format("Your time: %.2fs", playTime);
            textLen = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.ScreenWidth/2 - textLen + gp.tileSize*2;
            y = gp.ScreenHeight/2 - (gp.tileSize*4)-10;
            g2.drawString(text, x, y);
            
            gp.gameThread = null;
            
        }else{
        
            g2.setFont(arial_30);
            g2.setColor(Color.white);
            g2.drawImage(meatImage, gp.tileSize/3, gp.tileSize/3, gp.tileSize*1, gp.tileSize*1, null);
            g2.drawString("  x " + gp.player.hasMeat, gp.tileSize*1, gp.tileSize*1);

            //TIME
            playTime += (double)1/60;
            g2.drawString(String.format("Time: %.3f", playTime), gp.tileSize*12, gp.tileSize*1);

            //MESSAGE
            if (messageOn) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gp.tileSize*1/2, gp.tileSize*2);
                messageCounter++;
                if (messageCounter > 120) {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
