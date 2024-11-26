/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Wallyson M. Lima
 */
public class GamePanel extends JPanel implements Runnable{
    
    // Screen settings
    final int originalTileSize = 16; //16x16 draw tile
    final int scale = 3;
    
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int ScreenWidth = tileSize * maxScreenCol; //768 pixels
    final int ScreenHeight = tileSize * maxScreenRow; //576 pixels
    
    //FPS
    int FPS = 60;
    
    KeyHandler KeyH = new KeyHandler();
    Thread gameThread;
    
    //sets player's default position and move speed
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
//    public void run() {
//        
//        double drawInterval = 1000000000/FPS; //0,01666 s
//        double nextDrawTime = System.nanoTime() + drawInterval;
//        while(gameThread != null){
//
////            long currentTime = System.nanoTime();
////            System.out.println("Current time: "+ currentTime);
//            
//            //update information such as char position
//            update();
//           //draw the screen 
//           repaint();
//           
//           
//           
//            try {
//                double remainingTime = nextDrawTime - System.nanoTime();
//                remainingTime = remainingTime/100000;
//                
//                if (remainingTime < 0) {
//                    remainingTime = 0;
//                }
//                Thread.sleep((long)remainingTime);
//                
//                nextDrawTime += drawInterval;
//                
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        
        while(gameThread != null){
            currentTime = System.nanoTime();
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            
            if (timer >= 1000000000) {
                System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
    
    public void update(){
        if (KeyH.upPressed) {
            playerY -= playerSpeed;
        }else if (KeyH.downPressed) {
            playerY += playerSpeed;
        }else if (KeyH.leftPressed) {
            playerX -= playerSpeed;
        }else if (KeyH.rightPressed) {
            playerX += playerSpeed;
        }
{
            
        }
    
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
