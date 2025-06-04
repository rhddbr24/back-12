package cardgame;

import java.util.ArrayList;

public class Gamer {
    private int gamemoney = 10000;
    private String nickname = "";
    private int RankPoint = 0;
    private int VictoryCount = 0;
    private int DefeatCount = 0;
    private ArrayList<PokerCardDeck> GamerDeck = new ArrayList<>();
    private int ifTop = 0;
    private int Ranking = 1;

    // 닉네임 설정
    int setNickname(String str){
        if (str.length() < 21){
            this.nickname = str;
            return 0;
        } else{
            System.out.println("닉네임은 최대 20자");
            return -1;
        }
    }

    // 게임 플레이어 개인 덱 받기
    void setGamerDeck(ArrayList<PokerCardDeck> deck){
        GamerDeck.addAll(deck);
    }

    // 게임 플레이어 덱 점수 받기
    void setRankPoint(int rankPoint){
        this.RankPoint = rankPoint;
    }

    // 카드 족보가 TOP일 때의 경우
    void setIfTop(int Topvalue){
        this.ifTop = Topvalue;
    }

    void setRanking(int rank){
        this.Ranking = rank;
    }

    // 게임 플레이어가 우승
    void Victory(){
        gamemoney += 100;
        VictoryCount++;
    }

    // 게임 플레이어가 패배
    void Defeat(){
        DefeatCount++;
    }

    // 게임 플레이어 덱 회수
    void ResetDeck(){
        GamerDeck.clear();
    }

    // 게임 플레이어 덱 확인
    int getRankPoint(){
        return this.RankPoint;
    }

    // 게임 플레이어 닉네임 확인
    String getNickname() {
        return nickname;
    }

    // 게임 플레이어 덱 족보가 TOP일 때
    int getIfTop(){
        return ifTop;
    }

    // 게임 플레이어 덱 확인
    ArrayList<PokerCardDeck> getGamerDeck(){
        return this.GamerDeck;
    }

    int getRanking(){
        return this.Ranking;
    }

    int getVictoryCount(){
        return this.VictoryCount;
    }

    // 게임 플레이어 덱 출력
    void printGameDeck(){
        for (int i = 0; i < 5 ; i++){
            String str = GamerDeck.get(i).Cardkind;
            int num = GamerDeck.get(i).Cardnum;
            System.out.printf("%s %d, ",str,num);
        }
        System.out.println();
    }

    // 게임 플레이어의 현재 정보 확인
    String getState(){
        return Ranking + "등 : " + nickname + "\n돈 : " + gamemoney + ", 우승횟수 : " + VictoryCount + ", 패배횟수 : " + DefeatCount + "\n";
    }
}
