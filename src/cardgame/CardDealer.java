package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class CardDealer {
    PokerCardDeck card = new PokerCardDeck();
    ArrayList<PokerCardDeck> Deck = new ArrayList<>();
    Stack<PokerCardDeck> CardDeck = new Stack<>();
    private int RankPoint = 0;
    private String CardRank = "";
    private int ifTop = 0;



    // 52개의 카드 선언
    void setCardDeck(){
        card.setCardDeck();
        this.Deck.addAll(card.CardDeck);
    }

    //카드 회수
    void resetCardDeck(){
        this.Deck.clear();
        this.Deck.addAll(card.CardDeck);
        this.CardDeck.clear();
    }

    // 게임 플레이어에게 카드 5장씩 나눠주기
    ArrayList<PokerCardDeck> GiveCard(){
        Collections.shuffle(Deck);

        for (int i = 0; i < Deck.size(); i++){
            this.CardDeck.push(Deck.get(i));
        }

        ArrayList<PokerCardDeck> Cardvalue = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            PokerCardDeck CardValue = this.CardDeck.pop();
            Cardvalue.add(CardValue);
        }

        Deck.clear();
        Deck.addAll(CardDeck);

        return Cardvalue;
    }

    // 포커 카드 족보
    public int rankCheck(ArrayList<PokerCardDeck> cardArr) {
        int[] counter = new int[15];
        int[] cardkind = new int[4];
        int pair = 0;
        int fullouse = 0;
        int Top = 0;
        String result = "";   //"NO RANK";
        boolean flushck = false;
        boolean straightck = false;


        for (int i = 0; i < cardArr.size(); i++){
            counter[cardArr.get(i).Cardnum]++;
            if ("Clover".equals(cardArr.get(i).Cardkind)){
                cardkind[0]++;
            } else if ("Heart".equals(cardArr.get(i).Cardkind)) {
                cardkind[1]++;
            } else if ("Diamond".equals(cardArr.get(i).Cardkind)){
                cardkind[2]++;
            } else if ("Spade".equals(cardArr.get(i).Cardkind)) {
                cardkind[3]++;
            }
        }
        counter[14] = counter[1];
        // TOP
        for (int i = 0; i < cardArr.size(); i++){
            for (int j = i+1; j < cardArr.size(); j++){
                if (cardArr.get(i).Cardnum < cardArr.get(j).Cardnum){
                    Top = cardArr.get(j).Cardnum;
                    if (Top == 1){
                        Top = 14;
                    }
                }else {
                    Top = cardArr.get(i).Cardnum;
                }
            }
        }
        this.ifTop = Top;
        String Topnum = Top + "";
        switch (Top){
            case 11 : Topnum = "J";
                break;
            case 12 : Topnum = "Q";
                break;
            case 13 : Topnum = "K";
                break;
            case 14 : Topnum = "A";
        }
        this.RankPoint = 1;
        result = Topnum + " Top";

        // 1 PAIR, 2 PAIR, THREE CARD
        for (int i = 0; i< counter.length-1; i++){
            if (counter[i] == 2 ){
                this.RankPoint = 3;
                result = "1 PAIR";
                pair++;
                if (pair == 2){
                    this.RankPoint = 4;
                    result = "2 PAIR";
                }
            }
            if (counter[i] == 3){
                this.RankPoint = 5;
                result = "THREE CARD";
            }
        }
        // STRAIGHT
        for (int i = 1; i < counter.length-5; i ++){
            int straight = 0;
            for (int j = 0; j < 5; j++){
                if (counter[i+j] !=0){
                    straight++;
                    if(straight == 5){
                        this.RankPoint = 6;
                        result = "STRAIGHT";
                        straightck = true;
                    }
                }
            }
        }
        // FLUSH
        for (int i = 0; i < cardkind.length-1; i++){
            if (cardkind[i] == 5){
                this.RankPoint = 7;
                result = "FLUSH";
                flushck = true;
                break;
            }
        }
        // FULL HOUSE
        for (int i = 0; i < counter.length-1; i++){
            if (counter[i] == 2){
                pair++;
            }
            if (counter[i] == 3){
                fullouse++;
            }
            if (pair == 1 && fullouse ==1){
//                highnum = i;
                this.RankPoint = 8;
                result = "FULL HOUSE";
            }
        }
        // FOUR CARD
        for (int i = 0; i < counter.length-1; i++){
            if(counter[i] == 4){
                this.RankPoint = 9;
                result = "FOUR CARD";
            }
        }
        // STRAIGHT FLUSH
        if (straightck && flushck){
            this.RankPoint = 10;
            result = "STRAIGHT FLUSH";
        }

        // 결과
        this.CardRank = result;
        return this.RankPoint;
    }

    // 카드족보 확인
    String getCardRank(){
        return this.CardRank;
    }

    // 카드 족보가 TOP가 나올 때
    int getIfTop(){
        return this.ifTop;
    }
}

