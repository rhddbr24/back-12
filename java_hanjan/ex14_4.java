public class ex14_4 {
    public static void main(String[] args) {
        int[] dice1 = {1,2,3,4,5,6};
        int[] dice2 = {1,2,3,4,5,6};
        for(int i = 0; i < dice1.length; i++){
            for(int j = 0; j < dice2.length; j++){
                if(dice1[i] + dice2[j] == 6){
                    int[] sum = {dice1[i], dice2[j]};
                    System.out.printf("[%d, %d]\n", sum[0], sum[1]);
                }
            }
        }
    }
}
