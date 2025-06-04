public class casting {
    public static void main(String[] args) {
        for ( int a = 2; a <= 9; a = a+3){
            for(int i = 1; i <=4; i++){
                if ( i <= 3 ){
                    for(int j = 0; j <= 2; j++) {
                        if (a == 10) {
                            System.out.println();
                            a = a-2;
                        } else if( j == 2) {
                            System.out.println(a + "*" + i + "="+ i * a);
                            a = a-2;
                        } else{
                            System.out.print(a + "*" + i + "="+i * a +"\t");
                            ++a;
                        }
                    }
                }else {
                    System.out.println();
                }
            }
        }
    }
}