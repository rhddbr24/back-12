//import static org.junit.Assert.*;
//import org.junit.Test;
//
//public class CardTest {
//    public String rankCheck(Card[] cardArr) {
//        String ckind = cardArr[0].kind; //모양 비교
//        String result = "No Rank";  //결과 값
//        int pairsum = 0;    // 같은 카드의 개수
//        int Twopairsum = 0; // 페어 개수
//        int threesum = 1;   // 트리플
//        int fhthreesum = 1; // 풀하우스 트리플
//        int fhpairsum = 1;  // 풀하우스 원페어
//        int Foursum = 1;    //포카드
//        int rank = 0;       //족보 나누기
//        int Stmax = 0;      //스트레이트 카드에서 가장 높은 수
//        int Stmin = 0;      //스트레이트 카드에서 가장 낮은 수
//        for (int i = 0; i < cardArr.length; i++) {
//            //Straight Flush
//            if (Stmax < cardArr[i].num && rank == 0) {               //Straight Flush
//                Stmax = cardArr[i].num;
//            } else if (Stmin > cardArr[i].num) {
//                Stmin = cardArr[i].num;
//            }
//            if (ckind.equals(cardArr[i].kind)) {
//                ckind = cardArr[i].kind;
//                if (ckind.equals(cardArr[cardArr.length - 1].kind) && Stmax - Stmin == 4) {
//                    result = "STRAIGHT FLUSH";
//                    return result;
//                }
//            } else if (rank == 0) {
//                rank = 1;
//            }
//
//            // Four Card
//            if (i < 2 && rank <= 1) {                                //Four Card
//                for (int j = i+1; j < cardArr.length; j++){
//                    if (cardArr[i].num == cardArr[j].num){
//                        Foursum++;
//                        if (Foursum == 4){
//                            result = "FOUR CARD";
//                            return result;
//                        }
//                    } else{
//                        Foursum = 0;
//                    }
//                }
//            } else if (rank == 1) {
//                rank = 2;
//            }
//
//            // Full House
//            if ( i < 4 && rank <= 2){                               // Full House
//                for (int j = i+1; j < cardArr.length; j++){
//                    if (cardArr[i].num == cardArr[j].num){
//                        fhpairsum++;
//                        if (fhpairsum == 3){
//                            fhthreesum++;
//                            fhpairsum = 0;
//                        }
//                        if (fhthreesum == 1 && fhpairsum == 2){
//                            result = "FULL HOUSE";
//                            System.out.println(Stmax + "," + Stmin);
//                            return result;
//                        }
//                    }
//                }
//            } else if (rank ==2 ){
//                rank = 3;
//            }
//
//            // Flush
//            if (ckind.equals(cardArr[i].kind) && rank <= 3) {       // Flush
//                ckind = cardArr[i].kind;
//                if (ckind.equals(cardArr[cardArr.length - 1].kind)) {
//                    result = "FLUSH";
//                    return result;
//                }
//            } else if (rank == 3) {
//                rank = 4;
//            }
//
//            // Straight
//            if (Stmax - Stmin == 4 && i == cardArr.length-1) {      // Straight
//                result = "STRAIGHT";
//                return result;
//            }
//
//            // Three Card
//            if (i < 3 && rank <=4){
//                for (int j = i+1; j < cardArr.length; j++){
//                    if (cardArr[i].num == cardArr[j].num){
//                        threesum++;
//                        if (threesum == 3){
//                            result = "THREE CARD";
//                        }
//                    }
//                }
//                threesum = 0;
//            } else if (rank ==4) {
//                rank = 5;
//            }
//
//            // 2Pair, 1Pair
//            if (i < 4){                                             //2Pair, 1Pair
//                for (int j = i+1; j < cardArr.length; j++){
//                    if (cardArr[i].num == cardArr[j].num){
//                        pairsum++;
//                        System.out.println(pairsum);
//                        if (pairsum == 2){
//                            Twopairsum++;
//                            System.out.println(Twopairsum);
//                            pairsum = 0;
//                        }
//                        if (Twopairsum == 1 && !(result.equals("THREE CARD")) ){
//                            result = "2 PAIR";
//                        } else if (pairsum == 1 && !(result.equals("THREE CARD")) ) {
//                            result = "1 PAIR";
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
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
//    public void pair(){
//        Card[] cardArr = {
//                new Card(1,"H"),new Card(1,"D"),new Card(5,"H"),
//                new Card(9,"C"),new Card(10,"D")};
//
//        String result = rankCheck(cardArr);
//
//        assertTrue(result.equals("1 PAIR"));
//    }
//
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
