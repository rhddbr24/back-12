import java.util.Random;
import java.util.stream.IntStream;

public class ex14_7 {
    public static void main(String[] args) {
        IntStream lotto = new Random().ints(1,46);
        lotto.limit(5).forEach(System.out::println);
    }
}
