import java.lang.reflect.Array;

public class Exercise8 {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(args[0]);
            System.out.println(4);
        } catch (ArithmeticException ae){
            if (ae instanceof ArithmeticException){
                System.out.println("true");
            }
            System.out.println("ArithmeticException");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }
        System.out.println(6);
    }
}
