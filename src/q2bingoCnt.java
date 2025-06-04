public class q2bingoCnt {
    public static void main(String[] args) {
        int[][] arr = {
                {1,0,0,0,1},
                {1,1,1,1,1},
                {1,1,1,1,1},
                {0,1,0,1,1},
                {1,1,1,1,1}
        };
        System.out.println(bingoCnt(arr));
    }

    static int bingoCnt(int[][] arr){
        int bsum = 0;                               //빙고 개수
        int rusum = 0;
        int rdsum = 0;
        for (int i = 0; i < arr.length; i++){
            int xsum = 0;
            int ysum = 0;
            int c = arr[i][i];                      //우하향 변수
            int d = arr[i][arr[i].length -1 - i];   //우상향 변수
            if ( c == 1 ){                          //우상향 빙고 확인
                rusum++;
                if ( rusum == arr.length){
                    bsum++;
                }
            }
            if ( d == 1 ){                          //우하향 빙고 확인
                rdsum++;
                if ( rdsum == arr.length){
                    bsum++;
                }
            }
            for(int j = 0; j < arr[i].length; j++){
                int a = arr[i][j];                  //가로열 변수
                int b = arr[j][i];                  //세로열 변수
                if ( b == 1 ){                      //세로열 확인
                    ysum++;
                    if ( ysum == arr.length){
                        bsum++;
                        ysum = 0;
                    }
                }
                if ( a == 1 ){                      //가로열 확인
                    xsum++;
                    if ( xsum == arr[i].length){
                        bsum++;
                        xsum = 0;
                    }
                }
            }
        }
        return bsum;
    }
}
