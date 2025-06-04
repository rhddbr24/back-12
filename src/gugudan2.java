public class gugudan2 {
    public static void main(String[] args) {
        int danmax = 9;
        int inputmultiple = 3;
        int showmultiple = 3*inputmultiple;
        for (int i = 2; i <= danmax; i = i+3){
            int b = 0;
            for (int j = 0 ; j < showmultiple ; j ++){
                int a = (j / 3) + 1;
                if ( i + b < 8){
                    if ( b < 2 ){
                        System.out.printf("%d*%d=%d\t", i +b, a, (i+b)*a);
                        b++;
                    } else if ( b == 2) {
                        System.out.printf("%d*%d=%d\n", i +b, a, (i+b)*a);
                        b = 0;
                    }
                } else if ( i + b >= 8) {
                    int c = (j / 2) +1;
                    if ( b < 1 && c < 4){
                        System.out.printf("%d*%d=%d\t", i +b, c, (i+b)*c);
                        b++;
                    } else if ( b == 1 && c < 4) {
                        System.out.printf("%d*%d=%d\n", i +b, c, (i+b)*c);
                        b = 0;
                    }
                }
            }
                System.out.println();
        }
    }
}
