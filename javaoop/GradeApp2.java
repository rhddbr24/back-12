import java.util.Scanner;

public class GradeApp2 {
    public static void main(String[] args) {
        int stucount = 0;
        int stuscoresum = 0;
        float stuscoreave = 0f;
        Scanner s = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요: ");
        stucount = s.nextInt();
        int[] stuscore = new int[stucount];
        System.out.print("학생 점수를 입력하세요: ");
        for (int i =0; i < stuscore.length; i++){
            stuscore[i] = s.nextInt();
            stuscoresum += stuscore[i];
        }
        stuscoreave = stuscoresum / stucount;
        System.out.printf("평균: %.1f\n",stuscoreave);
        for (int i = 0; i < stucount; i++){
            if (stuscore[i] < stuscoreave){
                System.out.printf("%d fail!\n", stuscore[i]);
            } else{
                System.out.printf("%d pass!\n", stuscore[i]);
            }
        }
    }
}
