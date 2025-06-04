import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int[] a = solution("hi1239zd5202");
        System.out.println(Arrays.toString(a));
    }
    public static int[] solution(String my_string) {
        int[] answer = {};
        int j = 0;
        String str = "";
        for (int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if ('0'<=c&&c<='9'){
                str = c + str;
                j++;
            }
        }
        answer = new int[j];
        for (int i = 0; i < str.length();i++){
            char c = str.charAt(i);
            int a = c - '0';
            answer[i] = a;
        }
        Arrays.sort(answer);
        return answer;
    }
}