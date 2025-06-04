package cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class CardDealer {
    PokerCardDeck card = new PokerCardDeck();           // 기본 카드 덱 객체 생성
    ArrayList<PokerCardDeck> Deck = new ArrayList<>();  // 핸들링할 카드 덱 선언
    Stack<PokerCardDeck> CardDeck = new Stack<>();      // 섞은 카드 보관용
    private int RankPoint = 0;                          // 카드 족보에 따른 점수
    private String CardRank = "";                       // 카드 족보에 따른 문양
    private String kindscore = "";                      // 문양에 따른 점수
    private int highCardIndex = 0;                      // 배열에 입력된 카드중 가장 높은 점수의 카드의 배열 인덱스
    private int kindstack = 0;                          // 플러시를 확인 할 수 있는 같은 문양의 개수


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
        this.CardDeck.clear();

        return Cardvalue;
    }

    // 카드 숫자 점수 보조
    public int CardNumscore(int num){
        num = 4 * (num-2);
        return num;
    }

    // 카드 문양에 따른 점수 선언과 문양에 대한 족보 보조
    public int rank2(PokerCardDeck[] card){
        int extrascore = 0;                         // 문양에 따른 점수

        // 문양에 따른 점수 선언
        for (int i = 0; i < card.length; i++){
            if (card[i].Cardkind.equals("Spade ")){
                extrascore = 4;
                this.highCardIndex = i;
                break;
            } else if (card[i].Cardkind.equals("Diamond ")){
                extrascore = 3;
                this.highCardIndex = i;
            } else if (card[i].Cardkind.equals("Heart ") && extrascore != 3) {
                extrascore = 2;
                this.highCardIndex = i;
            } else if (card[i].Cardkind.equals("Clover ") && extrascore < 2) {
                extrascore = 1;
                this.highCardIndex = i;
            }
        }

        // 플러시 확인
        int spade = 0, diamond = 0, heart = 0, clover = 0;
        for (int i = 0; i < card.length; i++){
            switch (card[i].Cardkind) {
                case "Spade" -> spade++;
                case "Diamond" -> diamond++;
                case "Heart" -> heart++;
                case "Clover" -> clover++;
            }
        }
        int[] flushcheck = {spade, diamond, heart, clover};
        for (int i = 0; i < flushcheck.length; i++){
            if (flushcheck[i] == 5){
                this.kindstack = 5;
                break;
            }
        }

        // 해당 카드의 문양 확인
        switch (extrascore){
            case 1:
                this.kindscore = "Clover";
                break;
            case 2:
                this.kindscore = "Heart";
                break;
            case 3:
                this.kindscore = "Diamond";
                break;
            case 4:
                this.kindscore = "Spade";
                break;
        }
        return extrascore;
    }

    // 배열의 정렬된 카드 갯수에 맞게 배열 크기 재선언
    public PokerCardDeck[] remakedeck(PokerCardDeck[] deck){
        int redeckcount = 0;
        int insertcounter = 0;
        for (int i = 0; i < deck.length; i++){
            if (!(deck[i].Cardkind.equals("n"))){
                redeckcount++;
            }
        }
        PokerCardDeck[] remakedeck = new PokerCardDeck[redeckcount];
        for (int i = 0; i < deck.length; i++){
            if (!(deck[i].Cardkind.equals("n"))){
                remakedeck[insertcounter] = deck[i];
                insertcounter++;
            }
        }
        return remakedeck;
    }

    // 포커 카드 족보
    public int rankCheck(ArrayList<PokerCardDeck> cardArr) {
        PokerCardDeck highCard = new PokerCardDeck();                   // 높은 점수의 카드
        PokerCardDeck highCard2;                                        // 높은 점수의 카드2
        PokerCardDeck nullcheck = new PokerCardDeck("n", 0);  // 배열의 null값을 제거하기 위한 초기화 배열 값
        int topscore2 = 0;                                              // 카드의 높은 점수
        int cardcheck = 0;                                              // 카드 확인
        String result = "";                                             // 족보의 결과값
        int Topnum = 0;                                                 // 족보중 가장 큰 숫자값
        int pair = 0;                                                   // 페어 개수 셈
        int fullouse = 0;                                               // 풀하우스 조건 셈
        int Topscore = 0;                                               // 문양에 따른 점수
        int straighthighnum = 0;                                        // 스트라이트 셈
        int flushhighscore = 0;                                         // 플러시 셈
        boolean flushck = false;                                        // 스트플을 확인하기 위한 플러시 체크
        boolean straightck = false;                                     // 스트플을 확인하기 위한 스트랄이트 체크
        PokerCardDeck[] Top = new PokerCardDeck[5];                     // 같은 숫자의 카드들을 문양을 확인하기 위한 배열
        PokerCardDeck[][] mycard = new PokerCardDeck[15][5];            // 카드의 값을 확인하기 위한 배열
        String Topkindscore = "";                                       // 카드의 문자가 필요한 경우 숫자에 따라 문자를 받는 값


        // 배열 초기화
        for (int i = 0; i < mycard.length; i++){
            Arrays.fill(mycard[i], nullcheck);
        }
        Arrays.fill(Top, nullcheck);

        // 카드 숫자에 따라 카드 배열에 입력
        for (int i = 0; i < 5; i++){
            mycard[cardArr.get(i).Cardnum][cardcheck] = cardArr.get(i);
            cardcheck++;
        }
        mycard[14] = mycard[1];



        // HIGH CARD
        for (int i = 2; i < mycard.length; i++){
            if (1 == remakedeck(mycard[i]).length){
                Top = remakedeck(mycard[i]);
                Topnum = i;
            }
        }

        Topscore = rank2(Top);

        Topkindscore = Topnum + "";

        switch (Topnum){
            case 14 :
                Topkindscore = " A";
                break;
            case 13 :
                Topkindscore = " K";
                break;
            case 12 :
                Topkindscore = " Q";
                break;
            case 11 :
                Topkindscore = " J";
        }
        result = this.kindscore + Topkindscore + "\t/ HIGH CARD";
        this.RankPoint = CardNumscore(Topnum) + Topscore;

        // 1 PAIR, 2 PAIR, THREE CARD
        boolean twopaircheck = true;
        String kind = "";
        for (int i = 2; i< mycard.length; i++){
            if (remakedeck(mycard[i]).length == 2 ){
                pair++;
                Topnum = i;
                // ONE PAIR
                if (twopaircheck){
                    Topscore = rank2(remakedeck(mycard[i]));
                    highCard = remakedeck(mycard[i])[highCardIndex];
                    kind = this.kindscore;
                }
                twopaircheck = !twopaircheck;
                switch (Topnum){
                    case 14 :
                        Topkindscore = " A";
                        break;
                    case 13 :
                        Topkindscore = " K";
                        break;
                    case 12 :
                        Topkindscore = " Q";
                        break;
                    case 11 :
                        Topkindscore = " J";
                }
                result = this.kindscore + Topkindscore + "\t/ ONE PAIR";
                this.RankPoint = CardNumscore(Topnum) + Topscore + 52;
                // TWO PAIR
                if (pair == 2) {
                    topscore2 = rank2(remakedeck(mycard[i]));
                    highCard2 = remakedeck(mycard[i])[highCardIndex];
                    if (highCard.Cardnum < highCard2.Cardnum) {
                        this.RankPoint = CardNumscore(Topnum) + topscore2 + (52 * 2);
                        switch (Topnum){
                            case 14 :
                                Topkindscore = " A";
                                break;
                            case 13 :
                                Topkindscore = " K";
                                break;
                            case 12 :
                                Topkindscore = " Q";
                                break;
                            case 11 :
                                Topkindscore = " J";
                        }
                        result = this.kindscore + Topkindscore + "\t/ TWO PAIR";
                    } else{
                        this.RankPoint = this.RankPoint + 52;

                        switch (Topnum){
                            case 14 :
                                Topkindscore = " A";
                                break;
                            case 13 :
                                Topkindscore = " K";
                                break;
                            case 12 :
                                Topkindscore = " Q";
                                break;
                            case 11 :
                                Topkindscore = " J";
                        }
                        result = kind + Topkindscore + "\t/ TWO PAIR";
                    }
                }
            }
            // THREE CARD
            if (remakedeck(mycard[i]).length == 3){
                Topscore = rank2(remakedeck(mycard[i]));
                Topnum = i;
                this.RankPoint = CardNumscore(Topnum) + Topscore + (52*3);
                switch (Topnum){
                    case 14 :
                        Topkindscore = " A";
                        break;
                    case 13 :
                        Topkindscore = " K";
                        break;
                    case 12 :
                        Topkindscore = " Q";
                        break;
                    case 11 :
                        Topkindscore = " J";
                }
                result = this.kindscore + Topkindscore + "\t/ THREE CARD";
            }
        }
        // STRAIGHT
        for (int i = 1; i < mycard.length-4; i++){
            int straight = 0;
            for (int j = 0; j < 5; j++){
                if (remakedeck(mycard[i+j]).length != 0){
                    straight++;
                    if(straight == 5){
                        Topscore = rank2(remakedeck(mycard[i+j]));
                        Topnum = i+j;
                        this.RankPoint = CardNumscore(Topnum) + Topscore + (52*4);
                        switch (Topnum){
                            case 14 :
                                Topkindscore = " A";
                                break;
                            case 13 :
                                Topkindscore = " K";
                                break;
                            case 12 :
                                Topkindscore = " Q";
                                break;
                            case 11 :
                                Topkindscore = " J";
                        }
                        if (Topnum == 14){
                            result = this.kindscore + Topkindscore + "\t/ MOUNTAIN";
                        } else {
                            result = this.kindscore + Topkindscore + "\t/ STRAIGHT";
                        }
                        straighthighnum = i+j;
                        straightck = true;
                    }
                } else {
                    break;
                }
            }
        }
        // FLUSH
        for (int i = 2; i < mycard.length; i++){
            if (remakedeck(mycard[i]).length > 0){
                Topscore = rank2(remakedeck(mycard[i]));
                if (this.kindstack == 5){
                    Topnum = i;
                    this.RankPoint = Topscore + Topnum + (52*5);
                    switch (Topnum){
                        case 14 :
                            Topkindscore = " A";
                            break;
                        case 13 :
                            Topkindscore = " K";
                            break;
                        case 12 :
                            Topkindscore = " Q";
                            break;
                        case 11 :
                            Topkindscore = " J";
                    }

                    result = this.kindscore + Topkindscore + "\t/ FLUSH";
                    flushhighscore = Topscore;
                    flushck = true;
                    break;
                }
            }
        }
        // FULL HOUSE
        pair = 0;
        for (int i = 2; i < mycard.length; i++){
            if (remakedeck(mycard[i]).length == 2){
                pair++;
            }
            if (remakedeck(mycard[i]).length == 3){
                fullouse++;
                Topscore = rank2(remakedeck(mycard[i]));
                Topnum = i;
            }
            if (pair == 1 && fullouse ==1){
                this.RankPoint = CardNumscore(Topnum) + Topscore + (52*6);
                switch (Topnum){
                    case 14 :
                        Topkindscore = " A";
                        break;
                    case 13 :
                        Topkindscore = " K";
                        break;
                    case 12 :
                        Topkindscore = " Q";
                        break;
                    case 11 :
                        Topkindscore = " J";
                }
                result = this.kindscore + Topkindscore + "\t/ FULL HOUSE";
            }
        }
        // FOUR CARD
        for (int i = 2; i < mycard.length; i++){
            if(remakedeck(mycard[i]).length == 4){
                Topscore = rank2(remakedeck(mycard[i]));
                Topnum = i;
                this.RankPoint = CardNumscore(Topnum) + Topscore + (52*7);
                switch (Topnum){
                    case 14 :
                        Topkindscore = " A";
                        break;
                    case 13 :
                        Topkindscore = " K";
                        break;
                    case 12 :
                        Topkindscore = " Q";
                        break;
                    case 11 :
                        Topkindscore = " J";
                }
                result = this.kindscore + Topkindscore + "\t/ FOUR CARD";
            }
        }
        // STRAIGHT FLUSH
        if (straightck && flushck){
            this.RankPoint = straighthighnum + flushhighscore + (52*8);
            switch (straighthighnum){
                case 14 :
                    Topkindscore = " A";
                    break;
                case 13 :
                    Topkindscore = " K";
                    break;
                case 12 :
                    Topkindscore = " Q";
                    break;
                case 11 :
                    Topkindscore = " J";
            }
            if (straighthighnum == 14){
                result = this.kindscore + Topkindscore + "\t/ ROYAL STRAIGHT FLUSH";
            } else {
                result = this.kindscore + Topkindscore + "\t/ STRAIGHT FLUSH";
            }
        }
        // 결과
        this.CardRank = result;
        return this.RankPoint;
    }

    // 카드족보 확인
    String getCardRank(){
        return this.CardRank;
    }
}

