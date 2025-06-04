import java.util.Scanner;

public class GetminApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // 정수
        System.out.print("두개의 정수를 입력하세요: ");
        int i = s.nextInt();
        int i2 = s.nextInt();
        System.out.printf("최소값은 %d 입니다.\n", Math.min(i, i2));
        // 실수
        System.out.print("두 개의 실수를 입력하세요: ");
        float f = s.nextFloat();
        float f2 = s.nextFloat();
        System.out.printf("최소값은 %.1f 입니다.\n", Math.min(f, f2));
        // 문자열
        System.out.print("두 개의 문자열을 입력하세요: ");
        String str = s.next();
        String str2 = s.next();
        for (int j = 0; j < Math.min(str.length(), str2.length()); j++){
            char ch = str.charAt(j);
            char ch2 = str2.charAt(j);
            if (ch < ch2){
                System.out.printf("최소값은 %s 입니다.\n", str);
                break;
            } else if(ch > ch2){
                System.out.printf("최소값은 %s 입니다.\n", str2);
                break;
            }
        }
        //배열
        System.out.print("정수 배열의 5개 원소: ");
        int[] ia = new int[5];
        for (int j = 0; j < 5; j++){
            ia[j] = s.nextInt();
        }
        int min = ia[0];
        for (int j = 0; j < ia.length; j++){
            for (int t = j+1; t < ia.length; t++){
                min = Math.min(ia[t], ia[j]);
            }
        }
        System.out.printf("최소값은 %d입니다.\n",min);
    }
}
