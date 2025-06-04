public class distar {
    static void star(int x){
        int a = (x-1)/2;
        for (int i = -a; i <= a; i++){
            int ab = Math.abs(i);
            for (int j = 0; j < ab ; j++){
                System.out.print(" ");
            }
            for (int j = 0; j< x - 2*ab; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        star(7);
    }
}