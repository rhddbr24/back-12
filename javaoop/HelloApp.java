import java.util.Scanner;

public class HelloApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("이름을 입력하세요: ");
        String name = s.nextLine();
        System.out.print("현재 연도를 입력하세요: ");
        String year = s.nextLine();
        System.out.println("Hello " + name);
        System.out.println("Good Luck in " + year);

    }
}
