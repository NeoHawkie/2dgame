import java.util.*;
public class randomnumber
{
    public static void main(String[] args)
    {
        Random rng = new Random();
        HashSet randomX = new HashSet();
        HashSet randomY = new HashSet();
        do{
            randomX.add(4 + rng.nextInt(7));
        }while (randomX.size() != 10);
        do{
            randomY.add(2 + rng.nextInt(7));
        }while (randomY.size() != 10);
        
        System.out.println(randomX.toString());
    }
}