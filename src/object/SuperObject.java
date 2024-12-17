/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;

/**
 *
 * @author Wallyson M. Lima
 */
public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int X, Y;
    
    public void draw(Graphics2D g2, GamePanel gp){
            g2.drawImage(image, X, Y, gp.tileSize, gp.tileSize, null);
    }
}
