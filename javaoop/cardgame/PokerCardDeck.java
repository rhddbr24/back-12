package cardgame;

import java.util.ArrayList;

public class PokerCardDeck {
    final static ArrayList<PokerCardDeck> CardDeck = new ArrayList<>(52);   //기본 카드
    String Cardkind;        // 카드의 문양
    int Cardnum;            // 카드의 숫자

    PokerCardDeck(){}

    // 문양과 숫자를 입력받아 카드 객체 생성
    PokerCardDeck(String kind, int num){
        this.Cardkind = kind;
        this.Cardnum = num;
    }

    //카드 덱 생성
    static void setCardDeck(){             // 카드 구성
        String cardkind = "";
        for (int i = 0; i < 4; i++){
            if (i == 0){
                cardkind = "Heart ";
            } else if (i == 1) {
                cardkind = "Diamond ";
            } else if (i == 2) {
                cardkind = "Clover ";
            } else {
                cardkind = "Spade ";
            }
            for (int j = 1; j < 14; j++){
                CardDeck.add(new PokerCardDeck(cardkind, j));
            }
        }
    }

    // 카드 덱 반환
    void getCardDeck(){
        for (int i = 0; i < 52 ; i++){
            String str = CardDeck.get(i).Cardkind;
            int num = CardDeck.get(i).Cardnum;
            System.out.printf("%s %d, ",str,num);
        }
    }
}
