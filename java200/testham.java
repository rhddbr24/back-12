public class testham {
    public static int BITMASK=1;
    public static String shifts(int a){
        int t = 0;
        StringBuilder stb = new StringBuilder(15);
        String str;
        while(a>=2){
            t = a%2;
            stb.append(t);
            a = a/2;
        }
        t= a%2;
        stb.append(t);
        stb.reverse();
        str = stb.toString();
        return str;
    }
    public static void main(String[] args) {
        int intNums1 = 123;
        int intNums2 = 800;
        System.out.printf("%d : %s%n", intNums1,shifts(intNums1));
        System.out.printf("%d : %s%n", intNums2,shifts(intNums2));
    }

}
