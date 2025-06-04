package cardgame;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Gameplay {
    private static int player = 0;
    CardDealer dealer = new CardDealer();
    Scanner s = new Scanner(System.in);
    Gamer[] gamer;
    private boolean NotWinner = false;
    private int HighRankPlayerIndex = 0;
    private int GameCount = 0;
    private boolean regame = true;

    // 게임플레이 할 카드
    public void createCardDeck(){
        dealer.setCardDeck();
    }

    // 게임플레이 후 다시 게임 시작을 위해 회수
    public void resetCardDeck(){
        dealer.resetCardDeck();
    }

    // 게임 플레이어 설정
    public void setPlayer(){
        System.out.print("참가자 수(2명 ~ 4명): ");
        try{
            int playercount = s.nextInt();
            if (1 < playercount && playercount < 5){
                player = playercount;
                gamer = new Gamer[player];
                for (int i =0; i < player; i++){
                    gamer[i] = new Gamer();
                }
            } else{
                System.out.println("참가자는 최소 2명, 최대 4명");
                setPlayer();
            }
        } catch (NoSuchElementException e){
            System.out.println("숫자를 입력하세요");
            s.nextLine();
            setPlayer();
        }
    }

    // 게임 플레이 닉네임 설정
    public void setNickName(){
        for (int i = 0; i < player; i++){
            System.out.printf("%s번째 참가자 닉네임 입력(최대 20자): ", i+1);
            String nickname = s.next();
            i += gamer[i].setNickname(nickname);
        }
    }

    // 플레이어에게 카드 배분
    public void GiveCard(){
        for (int i = 0 ; i < player; i++){
            gamer[i].setGamerDeck(dealer.GiveCard());
        }
    }

    // 플레이어 카드족보 확인
    public void CardRankCheck() {
        int HighRankPoint = 0;
        String HighRankGamer = "";
        String HighRankCardDeck = "";
        String[] showNickName = new String[player];
        String[] showCardRank = new String[player];
        int[] showRankPoint = new int[player];

        // 플레이어 개개인의 족보 확인 후 최고점수 확인
        for (int i = 0; i < player; i++) {
            gamer[i].setRankPoint(dealer.rankCheck(gamer[i].getGamerDeck()));
            if (gamer[i].getRankPoint() == 1) {
                gamer[i].setIfTop(dealer.getIfTop());
            }

            showNickName[i] = gamer[i].getNickname();
            showCardRank[i] = dealer.getCardRank();
            showRankPoint[i] = gamer[i].getRankPoint();

            if (HighRankPoint < gamer[i].getRankPoint()) {
                HighRankPoint = gamer[i].getRankPoint();
                HighRankGamer = gamer[i].getNickname();
                HighRankCardDeck = dealer.getCardRank();
            }
        }

        this.NotWinner = false;

        // 최고 점수가 TOP일 경우
        if (HighRankPoint == 1) {
            int HighTop = 0;
            for (int i = 0; i < player; i++) {
                if (HighTop < gamer[i].getIfTop()) {
                    HighTop = gamer[i].getIfTop();
                    HighRankGamer = gamer[i].getNickname();
                    this.NotWinner = false;
                } else if(HighTop == gamer[i].getIfTop()){
                    this.NotWinner = true;
                }
            }

            HighRankPoint++;
            for (int i = 0; i < player; i++){
                if(HighRankGamer.equals(gamer[i].getNickname())){
                    gamer[i].setRankPoint(2);
                    showRankPoint[i] = gamer[i].getRankPoint();
                }
            }
        }

        for (int i = 0; i < player; i++){
            System.out.println(showNickName[i] + " : " + showCardRank[i] + " / " + showRankPoint[i] + "점");
        }

        // 최고점수가 동점인 경우 확인
        int count = 0;
        for (int i = 0; i < player; i++) {
            if (HighRankPoint == gamer[i].getRankPoint()) {
                HighRankPlayerIndex = i;
                count++;
                if (count >= 2){
                    this.NotWinner = true;
                    break;
                }
            }
        }
        if (!this.NotWinner) {
            System.out.println();
            System.out.println(HighRankGamer + " 승리!! \n" + HighRankGamer + " : " + HighRankCardDeck + " / " + HighRankPoint + "점");
        } else{
            System.out.println("동점으로 재경기");
        }
    }

    // 게임 끝난 후 결과 플레이어 정보에 입력
    public void EndGame(){
        if (!this.NotWinner){
            for (int i = 0; i < player; i++){
                if (HighRankPlayerIndex == i){
                    gamer[i].Victory();
                } else{
                    gamer[i].Defeat();
                }
            }
        } else{
            ifNotWinner();
        }
    }

    // 동점일 때의 경우
    public void ifNotWinner(){
        for (int i = 0; i < player; i++){
            gamer[i].ResetDeck();
        }
        resetCardDeck();
        System.out.println();
        GiveCard();
        for (int i = 0; i < player; i++){
            System.out.print(gamer[i].getNickname() + " : ");
            gamer[i].printGameDeck();
        }
        System.out.println();
        CardRankCheck();
        System.out.println();
        EndGame();
    }

    // 첫 게임
    public void FirstGameStart(String s){
        createCardDeck();
        setPlayer();
        setNickName();
        System.out.println();
        GiveCard();
        for (int i = 0; i < player; i++){
            System.out.print(gamer[i].getNickname() + " : ");
            gamer[i].printGameDeck();
        }
        System.out.println();
        CardRankCheck();
        System.out.println();
        EndGame();
        GameCount++;
        if (s.equals("y")){
            ReGameStart();
        } else{
            Ranking();
            System.out.println("\n\n\n");
            for (int j = 0; j < player; j++){
                System.out.println(gamer[j].getState());
            }
        }
    }

    // 첫 게임 이후
    public void ReGameStart(){
        for (int i = 0; i < player; i++){
            gamer[i].ResetDeck();
        }
        resetCardDeck();
        System.out.println();
        GiveCard();
        for (int i = 0; i < player; i++){
            System.out.print(gamer[i].getNickname() + " : ");
            gamer[i].printGameDeck();
        }
        System.out.println();
        CardRankCheck();
        System.out.println();
        EndGame();
        GameCount++;
        if (GameCount == 100){
            Ranking();
            System.out.println("\n\n\n");
            for (int j = 0; j < player; j++){
                System.out.println(gamer[j].getState());
            }
            return;
        }
        ReGameStart();
    }

    // 게임 시작
    public void GameStart(){
        System.out.print("100번 반복 하시겠습니까?(y/n) : ");
        String str = s.next();
        if (!(str.equals("y") || str.equals("n"))){
            System.out.println("y또는 n을 입력하세요");
            s.nextLine();
            GameStart();
        } else if (str.equals("n")) {
            FirstGameStart(str);
        } else{
            FirstGameStart(str);
        }
    }

    // 게임 더할지 여부 확인
    public void ResetGameStartCheck(){
        Scanner s = new Scanner(System.in);
        System.out.print("한번 더 (y/n) : ");
        String regamestartcheck = s.next();
        if (!(regamestartcheck.equals("y") || regamestartcheck.equals("n"))){
            System.out.println("y또는 n을 입력하세요");
            ResetGameStartCheck();
        } else if (regamestartcheck.equals("y")) {
            this.regame = true;
        } else{
            this.regame = false;
        }
    }

    // 순위 확인
    public void Ranking(){
        for (int i = 0; i < player; i++){
            for (int j = 0; j < player; j++) {
                if (gamer[i].getVictoryCount() < gamer[j].getVictoryCount()) {
                    int a = gamer[i].getRanking();
                    a++;
                    gamer[i].setRanking(a);
                }
            }
        }
        for (int i = 0; i < player; i++){
            Gamer b;
            for (int j = i+1; j < player; j++){
                if (gamer[i].getRanking() > gamer[j].getRanking()){
                    b = gamer[i];
                    gamer[i] = gamer[j];
                    gamer[j] = b;
                }
            }
        }
    }

    // 게임을 다시 할지 확인
    boolean isRegame(){
        return regame;
    }

}
