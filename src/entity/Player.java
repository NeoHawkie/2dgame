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

    public Player(GamePanel gp, KeyHandler KeyH) {
        this.gp = gp;
        this.KeyH = KeyH;
        
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        
        X = 100;
        Y = 100;
        Speed = 4; 
        direction = "right";
    }
    
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("res/player/tile3.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("res/player/tile4.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("res/player/tile3.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("res/player/tile4.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("res/player/file0.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("res/player/tile1.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("res/player/tile0.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("res/player/tile1.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        if (KeyH.upPressed) {
            direction = "up";
            Y -= Speed;
        }else if (KeyH.downPressed) {
            direction = "down";
            Y += Speed;
        }else if (KeyH.leftPressed) {
            direction = "left";
            X -= Speed;
        }else if (KeyH.rightPressed) {
            direction = "right";
            X += Speed;
        }
        
    }
    
    public void draw(Graphics g2){
//        g2.setColor(Color.white);  //rectangle
//        g2.fillRect(X, Y, gp.tileSize, gp.tileSize);
        
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "right":
                image = right1;
                break;
            case "left":
                image = left1;
                break;
        }
        g2.drawImage(image, X, Y, gp.tileSize, gp.tileSize, null);
    }
}
