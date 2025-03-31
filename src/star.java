public class star {
    public static void main(String[] args) {
        // 1.
        System.out.println("1.");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 2.
        System.out.println("2.");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j < i ; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        // 3.
        System.out.println("3.");
        for (int i = 1; i <= 5; i++) {
            int j = 5;
            j = j - i;
            for (; j >= 1; j--) {
                System.out.print(" ");
            }
            System.out.println("*");
        }

        // 4.
        System.out.println("4.");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 ; j++) {
                if( i == j || 5 - (i-1) == j){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // 5.
        System.out.println("5.");
        for (int i = 1; i <=5; i++){
            for(int j = 1 ; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 6.
        System.out.println("6.");
        for (int i = 1; i<=5; i++){
            for (int j = 1; j <=5; j++){
                if(5-(i-1) <= j){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        // 7.
        System.out.println("7.");
        for (int i = 1; i <=5; i++){
            for(int j = 1; j <=5; j++){
                System.out.print("*");
            }
            for(int j = 1; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 8.
        System.out.println("8.");
        for (int i = 1; i<=5; i++){
            for (int j = 1; j <= 9; j++){
                if ( 10 / 2 - (i-1) <= j && 10 / 2 + (i-1) >= j){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // 9.
        System.out.println("9.");
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= 5; j++){
                if ( 3-i >= 0 ){
                    if( 6 / 2 - ( 4 - i ) < j && j < 6 / 2 + ( 4 - i ) ){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                } else{
                    if( 6 / 2 - ( i - 2 ) < j && j < 6 / 2 + ( i - 2) ){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }

            }
            System.out.println();
        }
        // 10.
        System.out.println("10.");
        for (int i = 1; i <= 5; i++){
            for (int j = 1; j <= 5; j++){
                if ( 3-i >= 0 ){
                    if( 6 / 2 - ( 3 - i ) < j && j < 6 / 2 + ( 3 - i ) ){
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                } else{
                    if( 6 / 2 - ( i - 3 ) < j && j < 6 / 2 + ( i - 3) ){
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }

            }
            System.out.println();
        }
    }
}
