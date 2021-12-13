package snakeandladdersgame;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
class Game {
    private int noOfSnakes;
    private int noOfLadders;
    private Queue<Player> players;
    private Board board;
    private Dice dice;
    private List<Snake> snakes;
    private List<Ladder> ladders;
    public Game(int noOfSnakes,int noOfLadders,int boardSize){
        this.noOfSnakes=noOfSnakes;
        this.noOfLadders=noOfLadders;
        board=new Board(boardSize);
        dice=new Dice(6);
	    this.players=new ArrayDeque<>();
        snakes=new ArrayList<>(noOfSnakes);
        ladders=new ArrayList<>(noOfLadders);
        initializeBoard();

    }
    public void initializeBoard(){
        Set<Integer> sl=new HashSet<>();
        Random rand=new Random();
        for(int i=0;i<noOfSnakes;i++){
            while(true){
                int snakeHead=rand.nextInt(board.getBoardSize()-1)+1;
                int snakeTail=rand.nextInt(snakeHead+1)+1;
                // String headtail=String.valueOf(snakeHead)+String.valueOf(snakeTail);
                if(!sl.contains(snakeHead)&& !sl.contains(snakeTail)){
                    Snake snake=new Snake(snakeHead,snakeTail);
                    snakes.add(snake);
                    sl.add(snakeHead);
                    sl.add(snakeTail);
                    System.out.println("Snakes : "+snakeHead+" "+snakeTail);
                    break;
                }
            }
        }
        for(int i=0;i<noOfLadders;i++){
            while(true){
                int ladderStart=rand.nextInt(board.getBoardSize()-1)+1;
                int ladderEnd=rand.nextInt(board.getBoardSize()-ladderStart-1)+ladderStart;
                if(!sl.contains(ladderStart)&&!sl.contains(ladderEnd)){
                    Ladder ladder=new Ladder(ladderStart,ladderEnd);
                    ladders.add(ladder);
                    sl.add(ladderStart);
                    sl.add(ladderEnd);
                    System.out.println("Ladders : "+ladderStart+" "+ladderEnd);
                    break;
                }
            }
        }
    }
    public void addPlayer(Player player){
        players.add(player);
    }
    public void playGame(){
        while(true){
            Player player=players.poll();
            int val=dice.rollDice();
            int old=player.getPosition();
            int newPos=player.getPosition()+val;
            if(newPos>board.getBoardSize()){
                System.out.println("Illegal move :Player "+player.getPlayerName()+" remains at the same position");
                players.offer(player);
            }
            else{
                player.setPosition(newPos);
                if(player.getPosition()==board.getBoardSize()){
                    System.out.println("Player "+player.getPlayerName()+" rolled "+val+" and moved from "+old+" to "+newPos);
                    System.out.println("Hurray!Player "+player.getPlayerName()+" has won the game.");
                }
                else{
                    System.out.println("Player "+player.getPlayerName()+" rolled "+val+" and moved from "+old+" to "+newPos);
                    player.setPosition(getNewPosition(newPos, player));
                    players.offer(player);
                }
                if(players.size()<2){
                    break;
                }

            }

        }
    }
    public int getNewPosition(int newPos,Player player){
        for(Snake snake:snakes){
            if(snake.getSnakeHead()==newPos){
                System.out.println("Player "+player.getPlayerName()+" has bitten by a snake and fall down to "+snake.getSnakeTail());
                return snake.getSnakeTail();
            }
        }
        for(Ladder ladder:ladders){
            if (ladder.getLadderStart()==newPos){
                System.out.println("Player"+player.getPlayerName()+" moved from "+newPos+" to "+ladder.getLadderEnd()+" by climbing the ladder");
                return ladder.getLadderEnd();
            }
        }
        return newPos;
        
    }
    
}