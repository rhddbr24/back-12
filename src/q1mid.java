public class q1mid {
    static int mid(int a, int b, int c){
        int[] t = {a, b, c};
        for (int i = 0; i < t.length - 1; i++){
            for(int j = i; j < t.length - i; j++){
                int o = t[i];
                if ( o < t[j] ){
                    t[i] = t[j];
                    t[j] = o;
                }
            }
        }
        int m = (t.length + 1) / 2;
        return t[m];
    }

    public static void main(String[] args) {
        System.out.println(mid(1, 2, 3));
        System.out.println(mid(2, 1, 3));
        System.out.println(mid(1, 2, 2));
        System.out.println(mid(1, 1, 2));
    }
}