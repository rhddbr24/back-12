import java.util.Arrays;

public class ex14_6 {
    public static void main(String[] args) {
        String[] strArr = { "aaa","bb","c", "dddd" };
        int max = Arrays.stream(strArr).mapToInt(String::length).max().getAsInt();
        System.out.println(max);
    }
}
