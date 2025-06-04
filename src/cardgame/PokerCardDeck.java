package cardgame;

import java.util.ArrayList;

public class PokerCardDeck {
    final static ArrayList<PokerCardDeck> CardDeck = new ArrayList<>(52);
    String Cardkind;
    int Cardnum;

    PokerCardDeck(){}

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
}
