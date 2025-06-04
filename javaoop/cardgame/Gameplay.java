package cardgame;

import java.util.NoSuchElementException;
import java.util.Scanner;

// 게임 플레이 관련 클래스
public class Gameplay {
    private static int player = 0;              //플레이어 인원 수
    CardDealer dealer = new CardDealer();       // 딜러 객체 생성
    Scanner s = new Scanner(System.in);         //입력받을 스캐너 객체 생성
    Gamer[] gamer;                              // 게임 플레이어 객체 변수 선언
    private int HighRankPlayerIndex = 0;        //높은 점수를 얻은 플레이어를 찾기 위한 인데스 선언
    private int GameCount = 1;                  //게임 횟수 카운터
    private boolean regame = true;              //게임을 더 플레이 할지 결정

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
        int HighRankPoint = 0;                      // 가장 높은 점수
        String HighRankGamer = "";                  // 가장 높은 점수를 획득한 게임 플레이어
        String HighRankCardDeck = "";               // 가장 높은 점수의 카드 덱
        String[] showNickName = new String[player]; // 게임 플렝이어의 닉네임
        String[] showCardRank = new String[player]; // 게임 플레이어의 카드 족보 순위
        int[] showRankPoint = new int[player];      // 게임 플레이어의 카드 족보 점수

        // 플레이어 개개인의 족보 확인 후 최고점수 확인
        for (int i = 0; i < player; i++) {

            gamer[i].setRankPoint(dealer.rankCheck(gamer[i].getGamerDeck()));

            showNickName[i] = gamer[i].getNickname();
            showCardRank[i] = dealer.getCardRank();
            showRankPoint[i] = gamer[i].getRankPoint();

            if (HighRankPoint < gamer[i].getRankPoint()) {
                HighRankPoint = gamer[i].getRankPoint();
                HighRankGamer = gamer[i].getNickname();
                HighRankCardDeck = dealer.getCardRank();
            }
        }

        // 게임 플레이어의 가장 높은 점수의 카드와 족보, 점수
        System.out.println("해당 족보에서 가장 높은 점수와 카드와 족보, 점수 출력");
        for (int i = 0; i < player; i++){
            System.out.println(showNickName[i] + "\t: " + showCardRank[i] + "  \t/ " + showRankPoint[i] + "점");
        }

        // 최고점수 플레이어 찾기
        for (int i = 0; i < player; i++) {
            if (HighRankPoint == gamer[i].getRankPoint()) {
                HighRankPlayerIndex = i;
            }
        }
        System.out.println();

        // 포커 게임 승리한 플레이어 가장 높은 점수의 카드와 족보, 점수 출력
        System.out.println(HighRankGamer + " 승리!! \n" + "해당 족보에서 가장 높은 점수의 카드와 족보, 점수 출력\n" + HighRankGamer + " : " + HighRankCardDeck + " / " + HighRankPoint + "점");
        System.out.println("\n");
    }

    // 게임 끝난 후 결과 플레이어 정보에 입력
    public void EndGame(){
        for (int i = 0; i < player; i++){
            if (HighRankPlayerIndex == i){
                gamer[i].Victory();
            } else{
                gamer[i].Defeat();
            }
        }
    }

    // 첫 게임
    public void FirstGameStart(String s){
        createCardDeck();
        setPlayer();
        setNickName();
        System.out.println("\n\n");
        System.out.printf("%d번째 게임\n", GameCount);
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
        if (s.equals("y")){
            Ranking();
            System.out.printf("%d번째 게임 현재 플레이어 정보\n", GameCount);
            for (int j = 0; j < player; j++) {
                System.out.println(gamer[j].getState());
                gamer[j].setRanking(1);
            }
            System.out.println("\n\n\n");
            GameCount++;
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
        System.out.printf("%d번째 게임\n", GameCount);
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
        if (GameCount == 100){
            Ranking();
            System.out.println("\n\n\n");
            for (int j = 0; j < player; j++){
                System.out.println(gamer[j].getState());
            }
            return;
        }
        Ranking();
        System.out.printf("%d번째 게임 현재 플레이어 정보\n", GameCount);
        for (int j = 0; j < player; j++) {
            System.out.println(gamer[j].getState());
            gamer[j].setRanking(1);
        }
        System.out.println("\n\n\n");
        GameCount++;
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

    // 게임을 다시 할지 확인
    boolean isRegame(){
        return regame;
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

}
