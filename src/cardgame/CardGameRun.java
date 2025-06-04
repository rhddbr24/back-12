package cardgame;

public class CardGameRun extends Thread{
    Gameplay gameplay = new Gameplay();
    @Override
    public void run(){
        gameplay.GameStart();
    }
}