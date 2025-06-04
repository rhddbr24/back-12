public class counting {
    public static void main(String[] args) {
        int [] arr = {3,4,6,1,2,5,1,2,3,2,5};
        int [] counter = new int[10];
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            counter[arr[i]]++;
        }

        //1. 중복제거
        System.out.print("1. 중복제거 : ");
        for (int i = 0; i < counter.length; i++){
            if(sum == 0 && counter[i] != 0){
                sum = 1;
                System.out.print(i);
            } else if (counter[i] != 0){
                System.out.print(", " + i);
            }
        }
        System.out.println();

        //2. 정렬
        System.out.print("2. 정렬 : ");
        for (int i = 0; i < counter.length; i++){
            int c = counter[i];
            if( c != 0 && sum == 1 ){
                System.out.print(i);
                for(int j = 1; j <= c - 1; j++) {
                    System.out.print(", " + i);
                }
                sum++;
            } else if( c != 0 ){
                for(int j = 1; j <= c; j++) {
                    System.out.print(", " + i);
                }
            }
        }
    }
}
