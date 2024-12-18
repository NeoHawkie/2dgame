/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Wallyson M. Lima
 */
public class OBJ_Meat extends SuperObject{
    public OBJ_Meat(){
        name = "Meat";
        try{
            image = ImageIO.read(getClass().getResource("./res/objects/meat.png"));
        }catch(IOException error){
            error.printStackTrace();
        }
//        solidArea.x = 8;
//        solidArea.y = 16;
//        solidArea.height = 32;
//        solidArea.width = 32;
        collision = true;
    }
}
