package snakeandladdersgame;
import java.util.Random;
public class Dice{
    private int maxValue;
    public Dice(int maxValue){
        this.maxValue=maxValue;
    }
    public int rollDice(){
        Random rand=new Random();
        return rand.nextInt(maxValue)+1;
    }
}