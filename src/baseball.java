public class baseball {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] arr2 = {1, 3, 2};
        int S = 0;
        int B = 0;
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if (arr[i] == arr2[j]){
                    if(arr[i] == arr2[i]){
                        S++;
                    }else{
                        B++;
                    }
                }
            }
        }
        System.out.println(S + "S" + B + "B");
    }
}
