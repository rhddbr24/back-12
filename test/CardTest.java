//import static org.junit.Assert.*;
//import org.junit.Test;
//
//public class CardTest {
//    public String rankCheck(Card[] cardArr) {
//        int[] counter = new int[14];
//        int[] cardkind = new int[4];
//        int pair = 0;
//        int fullouse = 0;
//        String result = "NO RANK";
//        boolean flushck = false;
//        boolean straightck = false;
//        for (int i = 0; i < cardArr.length; i++){
//            counter[cardArr[i].num]++;
//            if ("S".equals(cardArr[i].kind)){
//                cardkind[0]++;
//            } else if ("D".equals(cardArr[i].kind)) {
//                cardkind[1]++;
//            } else if ("H".equals(cardArr[i].kind)){
//                cardkind[2]++;
//            } else if ("C".equals(cardArr[i].kind)) {
//                cardkind[3]++;
//            }
//        }
//        // 1 PAIR, 2 PAIR, THREE CARD
//        for (int i = 0; i< counter.length; i++){
//            if (counter[i] == 2 ){
//                result = "1 PAIR";
//                pair++;
//                if (pair == 2){
//                    result = "2 PAIR";
//                }
//            }
//            if (counter[i] == 3){
//                result = "THREE CARD";
//            }
//        }
//        // STRAIGHT
//        for (int i = 1; i < counter.length-4; i ++){
//            int straight = 0;
//            for (int j = 0; j < 5; j++){
//                if (counter[i+j] !=0){
//                    straight++;
//                    if(straight == 5){
//                        result = "STRAIGHT";
//                        straightck = true;
//                    }
//                }
//            }
//        }
//        // FLUSH
//        for (int i = 0; i < cardkind.length; i++){
//            if (cardkind[i] == 5){
//                result = "FLUSH";
//                flushck = true;
//                break;
//            }
//        }
//        // FULL HOUSE
//        for (int i = 0; i < counter.length; i++){
//            if (counter[i] == 2){
//                pair++;
//            }
//            if (counter[i] == 3){
//                fullouse++;
//            }
//            if (pair == 1 && fullouse ==1){
//                result = "FULL HOUSE";
//            }
//        }
//        // FOUR CARD
//        for (int i = 0; i < counter.length; i++){
//            if(counter[i] == 4){
//                result = "FOUR CARD";
//            }
//        }
//        // STRAIGHT FLUSH
//        if (straightck && flushck){
//            result = "STRAIGHT FLUSH";
//        }
//    return result;
//    }
//
//
//    @Test
//    public void FourCardTest() {
//        // 조건
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(1,"H"),new Card(1,"H"),
//                new Card(1,"H"),new Card(3,"D")};
//
//        // 테스트
//        String result = rankCheck(cardArr);
//
//        // 확인
//        assertTrue(result.equals("FOUR CARD"));
//    }
//
//
//    @Test
//    public void fullHouseTest() {
//        // 조건
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(1,"H"),new Card(1,"H"),
//                new Card(3,"H"),new Card(3,"D")};
//
//        // 테스트
//        String result = rankCheck(cardArr);
//
//        // 확인
//        assertTrue(result.equals("FULL HOUSE"));
//    }
//
//    @Test
//    public void flushTest() {
//        // 조건
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(8,"H"),new Card(3,"H"),
//                new Card(4,"H"),new Card(5,"H")};
//
//        // 테스트
//        String result = rankCheck(cardArr);
//
//        // 확인
//        assertTrue(result.equals("FLUSH"));
//    }
//
//    @Test
//    public void straightTest() {
//        // 조건
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(2,"D"),new Card(3,"H"),
//                new Card(4,"H"),new Card(5,"H")};
//
//        // 테스트
//        String result = rankCheck(cardArr);
//
//        // 확인
//        assertTrue(result.equals("STRAIGHT"));
//    }
//
//    @Test
//    public void OnePairTest(){
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(1,"D"),new Card(5,"H"),
//                new Card(9,"C"),new Card(10,"D")};
//
//        String result = rankCheck(cardArr);
//
//        assertTrue(result.equals("1 PAIR"));
//    }
//
//    @Test
//    public void StraightFlushTest(){
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(2,"H"),new Card(3,"H"),
//                new Card(4,"H"),new Card(5,"H")};
//
//        String result = rankCheck(cardArr);
//
//        assertTrue(result.equals("STRAIGHT FLUSH"));
//    }
//
//    @Test
//    public void twoPairTest(){
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(1,"D"),new Card(5,"H"),
//                new Card(5,"C"),new Card(10,"D")};
//
//        String result = rankCheck(cardArr);
//
//        assertTrue(result.equals("2 PAIR"));
//    }
//
//    @Test
//    public void ThreeCardTest(){
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(1,"D"),new Card(1,"H"),
//                new Card(9,"C"),new Card(10,"D")};
//
//        String result = rankCheck(cardArr);
//
//        assertTrue(result.equals("THREE CARD"));
//    }
//
//    @Test
//    public void NoRankTest (){
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(2,"D"),new Card(3,"H"),
//                new Card(9,"C"),new Card(10,"D")};
//
//        String result = rankCheck(cardArr);
//
//        assertTrue(result.equals("NO RANK"));
//    }
//}
//
//class Card {
//    int num;
//    String kind;
//
//    Card(int num, String kind){
//        this.num = num;
//        this.kind = kind;
//    }
//
//    @Override
//    public String toString() {
//        return "Card [num=" + num + ", kind=" + kind + "]";
//    }
//}
//
//        String[] str = new String[gamercount];
//        for (int i = 0; i < gamercount; i++){
//            System.out.printf("%s번째 참가자 닉네임 입력(최대 20자): ",i+1);
//            str[i] = s.next();
//        }
