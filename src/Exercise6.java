//class SutdaDeck {
//    final int CARD_NUM = 20;
//    SutdaCard[] cards = new SutdaCard[CARD_NUM];
//    SutdaDeck() {
//        for (int i = 0; i < CARD_NUM; i++){
//            if ( i == 0 || i == 2 || i == 7){
//                this.cards[i] = new SutdaCard(i+1,true);
//            } else {
//                this.cards[i] = new SutdaCard(i+1,false);
//            }
//        }
//    }
//
//    void shuffle(){
//        for (int i =0; i < CARD_NUM; i ++){
//            SutdaCard sc = this.cards[i];
//            int r = (int)(Math.random()*CARD_NUM);
//            this.cards[i] = this.cards[r];
//            this.cards[r] = sc;
//        }
//    }
//
//    SutdaCard pick(int index){
//        return this.cards[index];
//    }
//
//    SutdaCard pick(){
//        int rc = (int)(Math.random()*CARD_NUM);
//        return this.cards[rc];
//    }
//}
//
//class SutdaCard {
//    int num;
//    boolean isKwang;
//    SutdaCard() {
//        this(1, true);
//    }
//    SutdaCard(int num, boolean isKwang) {
//        this.num = num;
//        this.isKwang = isKwang;
//    }
//    // info()대신 Object클래스의 toString()을 오버라이딩했다.
//    public String toString() {
//        return num + ( isKwang ? "K":"");
//    }
//}
//
//
//public class Exercise6 {
//    public static void main(String args[]) {
//        SutdaDeck deck = new SutdaDeck();
//        System.out.println(deck.pick(0));
//        System.out.println(deck.pick());
//        deck.shuffle();
//        for(int i=0; i < deck.cards.length;i++)
//            System.out.print(deck.cards[i]+",");
//        System.out.println();
//        System.out.println(deck.pick(0));
//    }
//}
