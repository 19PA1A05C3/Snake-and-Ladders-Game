package snakeandladdersgame;

public class Player {
    private String name;
    private int position;
    public Player(String name){
        this.name=name;
        this.position=0;
    }
    public String getPlayerName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    public void setPosition(int pos){
        this.position=pos;
    }

}