public class Exercise5_11 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        while (i < 100){
            j = ++j;
            if (j % 2 != 0){
                i = i + j;
            } else {
                i = i + (-1 * j);
            }
        }
        System.out.println(j);
    }
}
