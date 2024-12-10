/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

/**
 *
 * @author Wallyson M Lima
 */
public class Player extends Entity{
    GamePanel gp;
    KeyHandler KeyH;
    
    //public final int screenX, screenY; //openworld-like setting

    public Player(GamePanel gp, KeyHandler KeyH) {
        this.gp = gp;
        this.KeyH = KeyH;
        
        {/*
        screenX = gp.ScreenWidth/2 - (gp.tileSize/2); //if using moving camera
        screenY = gp.ScreenHeight/2 - (gp.tileSize/2);
        */} //openworld-like settings
        
        setDefaultValues();
        System.out.println(System.getProperty("user.dir"));
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        {/*
        worldX = gp.tileSize * 8; //if using moving camera
        worldY = gp.tileSize * 8;
        Speed = 4; 
        direction = "down";
        */} //openworld-like settings
        X = gp.tileSize * 8;
        Y = gp.tileSize * 6;
        Speed = 4; 
        direction = "down";
    }
    
    public void getPlayerImage(){
        try{
            //System.out.println("Image loading started");
            // load sprite images....
            up1 = ImageIO.read(getClass().getResource("./res/player/idle_R0.png"));
            up2 = ImageIO.read(getClass().getResource("./res/player/idle_R1.png"));
            right1 = ImageIO.read(getClass().getResource("./res/player/idle_R0.png"));
            right2 = ImageIO.read(getClass().getResource("./res/player/idle_R1.png"));
            down1 = ImageIO.read(getClass().getResource("./res/player/idle_L0.png"));
            down2 = ImageIO.read(getClass().getResource("./res/player/idle_L1.png"));
            left1 = ImageIO.read(getClass().getResource("./res/player/idle_L0.png"));
            left2 = ImageIO.read(getClass().getResource("./res/player/idle_L1.png"));
            // load sprite images....
            //System.out.println("Image loading ended");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        {/*
        if (KeyH.upPressed) {
            direction = "up";
            worldY -= Speed; //if using moving camera, change to worldY
        }else if (KeyH.downPressed) {
            direction = "down";
            worldY += Speed; //if using moving camera, change to worldX, and so on...
        }else if (KeyH.leftPressed) {
            direction = "left";
            worldX -= Speed;
        }else if (KeyH.rightPressed) {
            direction = "right";
            worldX += Speed;
        }
        */} //openworld-like settings
        
        if (KeyH.upPressed) {
            direction = "up";
            Y -= Speed; //if using moving camera, change to worldY
        }else if (KeyH.downPressed) {
            direction = "down";
            Y += Speed; //if using moving camera, change to worldX, and so on...
        }else if (KeyH.leftPressed) {
            direction = "left";
            X -= Speed;
        }else if (KeyH.rightPressed) {
            direction = "right";
            X += Speed;
        }
        
        spriteCounter++;
        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    
    public void draw(Graphics g2){
//        g2.setColor(Color.white);  //rectangle
//        g2.fillRect(X, Y, gp.tileSize, gp.tileSize);
        
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if (spriteNum == 1) {
                    image = up1;    
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
        }
        //g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null); //openworld-like setting
        g2.drawImage(image, X, Y, gp.tileSize, gp.tileSize, null);
    }
}
