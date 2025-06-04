import java.util.Scanner;

public class GradeApp4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int koi, komax = 0, kosum = 0, koave = 0;
        int komin = 100;
        int mai, mamax = 0, masum = 0, maave = 0;
        int mamin = 100;
        int[] stuscoresum = new int[5];
        int[] rank = {1,1,1,1,1};
        for (int i = 0; i < 5; i++){
            System.out.printf("%d번째 학생의 국어 성적: ",i+1);
            koi = s.nextInt();
            if (koi > komax){
                komax = koi;
            }
            if(koi < komin){
                komin = koi;
            }
            kosum += koi;
            System.out.printf("%d번째 학생의 수학 성적: ",i+1);
            mai = s.nextInt();
            if (mai > mamax){
                mamax = mai;
            }
            if (mai < mamin) {
                mamin = mai;
            }
            masum += mai;

            stuscoresum[i] = koi + mai;
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
//                if ( i != j){
                    if (stuscoresum[i] < stuscoresum[j]){
                        rank[i]++;
                    }
//                }
            }
        }
        koave = kosum / 5;
        maave = masum / 5;
        System.out.println();
        System.out.println("국어 최고 점수: " + komax);
        System.out.println("국어 최저 점수: " + komin);
        System.out.println("국어 총점: " + kosum);
        System.out.println("국어 평균: " + koave);
        System.out.println();
        System.out.println("수학 최고 점수: " + mamax);
        System.out.println("수학 최저 점수: " + mamin);
        System.out.println("수학 총점: " + masum);
        System.out.println("수학 평균: " + maave);

        System.out.println();
        for (int i = 0; i < 5; i++){
            System.out.printf("%d번째 학생 총점: %d 석차: %d\n", i+1, stuscoresum[i], rank[i]);
        }
    }
}

