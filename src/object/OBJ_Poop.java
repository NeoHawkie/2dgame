/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Wallyson M. Lima
 */
public class OBJ_Poop extends SuperObject {
    public BufferedImage img1, img2;
    public OBJ_Poop(){
        name = "Poop";
        try{
            img1 = ImageIO.read(getClass().getResource("./res/objects/poop1.png"));
            img2 = ImageIO.read(getClass().getResource("./res/objects/poop2.png"));
        }catch(IOException error){
            error.printStackTrace();
        }
    }
}
