/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import entity.Entity;

/**
 *
 * @author Wallyson M. Lima
 */
public class CollisionChecker {
    
    GamePanel gp;
    
    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    
    public void checkTile(Entity entity){
        
        int entityLeftX = entity.X + entity.solidArea.x;
        int entityRightX = entity.X + entity.solidArea.x + entity.solidArea.width;
        int entityTopY = entity.Y + entity.solidArea.y;
        int entityBottomY = entity.Y + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftX/gp.tileSize;
        int entityRightCol = entityRightX/gp.tileSize;
        int entityTopRow = entityTopY/gp.tileSize;
        int entityBottomRow = entityBottomY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopY - entity.Speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }
    }
}
