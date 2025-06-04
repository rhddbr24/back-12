package cardgame;

public class PokerCard {

    public static void main(String[] args) {
        Gameplay gameplay = new Gameplay();
        while(gameplay.isRegame()){
            try{
                CardGameRun GameStart = new CardGameRun();
                GameStart.start();
                GameStart.join();
                gameplay.ResetGameStartCheck();
            } catch (InterruptedException e){
                System.out.println("오류로 인한 종료");
            }
        }
    }
}