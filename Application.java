package snakeandladdersgame;
import java.util.Scanner;
public class Application {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the board size");
        int boardSize=sc.nextInt();
        System.out.println("Enter no of players");
        int noOfPlayers=sc.nextInt();
        System.out.println("Enter no of Snakes");
        int noOfSnakes=sc.nextInt();
        System.out.println("Enter no of Ladders");
        int noOfLadders=sc.nextInt();
        Game game=new Game(noOfSnakes,noOfLadders,boardSize);
        for(int i=0;i<noOfPlayers;i++){
            System.out.println("Enter player name");
            String pname=sc.next();
            Player player=new Player(pname);
            game.addPlayer(player);
        }
        game.playGame();
        sc.close();
    }
    
}
