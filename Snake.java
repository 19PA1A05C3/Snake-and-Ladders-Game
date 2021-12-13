package snakeandladdersgame;
class Snake {
    private int head;
    private int tail;
    public Snake(int head,int tail){
        this.head=head;
        this.tail=tail;
    }
    public int getSnakeHead(){
        return head;
    }
    public int getSnakeTail(){
        return tail;
    }
}
