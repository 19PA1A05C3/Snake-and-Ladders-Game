package snakeandladdersgame;
public class Ladder {
    private int start;
    private int end;
    public Ladder(int start,int end){
        this.start=start;
        this.end=end;
    }
    public int getLadderStart(){
        return start;
    }
    public int getLadderEnd(){
        return end;
    }
    
}
