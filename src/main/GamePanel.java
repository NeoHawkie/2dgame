/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import tile.TileManager;

/**
 *
 * @author Wallyson M. Lima
 */
public class GamePanel extends JPanel implements Runnable{
    
    // Screen settings
    final int originalTileSize = 16; //16x16 draw tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int ScreenWidth = tileSize * maxScreenCol; //768 pixels
    public final int ScreenHeight = tileSize * maxScreenRow; //576 pixels
    
    // WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    //FPS
    int FPS = 60;
    
    //instances:
    TileManager tileM = new TileManager(this);
    KeyHandler KeyH = new KeyHandler();
    Thread gameThread;
    public Player player = new Player(this, KeyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    
    //sets player's default position and move speed
//    int playerX = 100;
//    int playerY = 100;
//    int playerSpeed = 4;
    
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
    
    {/*
    public void run() {
        
        double drawInterval = 1000000000/FPS; //0,01666 s
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){

//            long currentTime = System.nanoTime();
//            System.out.println("Current time: "+ currentTime);
            
            //update information such as char position
            update();
           //draw the screen 
           repaint();
           
           
           
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/100000;
                
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
      */} //unoptimizes method
    @Override
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
        player.update();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        tileM.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
