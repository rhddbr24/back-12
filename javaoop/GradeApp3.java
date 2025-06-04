//import java.util.Scanner;
//
//public class GradeApp3 {
//    public static void main(String[] args) {
//        int stucount = 0;
//        String stuname = "";
//        String stuscore2 = "";
//        int stuscore = 0;
//        int stuscoresum = 0;
//        float stuscoreave = 0f;
//        Scanner s = new Scanner(System.in);
//        System.out.print("학생 수를 입력하세요: ");
//        stucount = s.nextInt();
//        String[] str = new String[stucount];
//        String[] stuallname = new String[stucount];
//        int[] stuallscore = new int[stucount];
//        System.out.print("학생 이름과 점수를 입력하세요: ");
//        for (int i = 0; i < str.length; i++){
//            str[i] = s.next();
//            int j = 0;
//            while(true){
//                if (!('0' < str[i].charAt(j) && str[i].charAt(j) < '9')){
//                    char ch = str[i].charAt(j);
//                    stuname += ch;
//                    j++;
//                } else if (str[i].charAt(j) == ' ') {
//                    continue;
//                }
//            }
//            stuallname[i] = stuname;
//            stuname = "";
//            for (int t = stuallname[i].length(); t < str[i].length(); t++){
//                stuscore2 += str[i].charAt(t);
//            }
//            stuscore = Integer.parseInt(stuscore2);
//            stuscore2 = "";
//            stuallscore[i] = stuscore;
//            stuscoresum += stuallscore[i];
//        }
//        stuscoreave = (float)(stuscoresum / stucount);
//        System.out.printf("평균: %.1f\n", stuscoreave);
//        for (int t = 0; t < stucount; t++){
//            if (stuscoreave > stuallscore[t]){
//                System.out.printf("%s fail!\n",stuallname[t]);
//            } else{
//                System.out.printf("%s pass!\n",stuallname[t]);
//            }
//        }
//    }
//}
