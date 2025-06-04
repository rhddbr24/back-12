package cardgame;

import java.util.ArrayList;

public class Gamer {
    private int gamemoney = 10000;                                  // 게임 플레이어 초기 자본
    private String nickname = "";                                   // 게임 플레잉어의 닉네임
    private int RankPoint = 0;                                      // 게임 플레이어의 받은 카드의 족보 점수
    private int VictoryCount = 0;                                   // 게임 플레이어의 우승 횟수
    private int DefeatCount = 0;                                    // 게임 플레이어의 패배 횟수
    private ArrayList<PokerCardDeck> GamerDeck = new ArrayList<>(); // 게임 플레이어의 딜러에게 받은 5장의 카드
    private int Ranking = 1;                                        // 게임 플레이어의 순위

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

    // 게임 플레이어 순위 입력
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

    // 게임 플레이어 덱 확인
    ArrayList<PokerCardDeck> getGamerDeck(){
        return this.GamerDeck;
    }

    // 게임 플레이어 순위 확인
    int getRanking(){
        return this.Ranking;
    }

    // 게임 플레이어 우승 횟수 확인
    int getVictoryCount(){
        return this.VictoryCount;
    }

    // 게임 플레이어 덱 출력
    void printGameDeck(){
        System.out.println("획득한 카드 확인");
        for (int i = 0; i < 5 ; i++){
            String str = GamerDeck.get(i).Cardkind;
            int num = GamerDeck.get(i).Cardnum;
            String numexchange = num + "";
            switch (num){
                case 14 :
                    numexchange = "A";
                    break;
                case 13 :
                    numexchange = "K";
                    break;
                case 12 :
                    numexchange = "Q";
                    break;
                case 11 :
                    numexchange = "J";
                    break;
                case 1 :
                    numexchange = "A";
                    break;
            }
            System.out.printf("%s %s, " ,str,numexchange);
        }
        System.out.println();
    }

    // 게임 플레이어의 현재 정보 확인
    String getState(){
        return Ranking + "등 : " + nickname + "\n돈 : " + gamemoney + ", 우승횟수 : " + VictoryCount + ", 패배횟수 : " + DefeatCount + "\n";
    }
}
