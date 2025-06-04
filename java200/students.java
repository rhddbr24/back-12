import java.util.Scanner;

class Student{
    String name;
    int score;

    Student(){
    }

    Student(String name, int score){
       this.name = name;
       this.score = score;
    }
    @Override
    public String toString(){
        return "이름: " + name + ", 점수: " + score;
    }
}

public class students {
    public static void main(String[] args) {
        int scorec = 0;
        String namec = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요: ");
        int c = scanner.nextInt();
        String[] str = new String[c];
        int[] score = new int[c];
        try{
            Exception e = new Exception("점수는 0~100 범위의 값을 입력");
            for (int i = 0; i < c; i++){
                System.out.printf("학생 %d 이름: ",i+1);
                str[i] = scanner.next();
                System.out.printf("점수 %d 점수: ",i+1);
                score[i] = scanner.nextInt();
                if (score[i] < 0 || 100 < score[i]){
                    throw e;
                }
            }
            for (int i = 0; i < score.length-1; i++){
                scorec = score[i];
                namec = str[i];
                for (int j = i + 1; j < score.length; j++){
                    if (scorec < score[j]){
                        score[i] = score[j];
                        score[j] = scorec;
                        str[i] = str[j];
                        str[j] = namec;
                    }
                }
            }
            System.out.println("정렬 결과:");
            for (int i = 0; i < c; i++){
                Student s = new Student(str[i], score[i]);
                System.out.printf("%d등 - %s",i+1,s);
                System.out.println();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
