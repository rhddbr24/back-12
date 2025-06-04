class Solution0 {
    public static void main(String[] args) {
        int s = solution(54321);
        System.out.println(s);
    }
    public static int solution(int n) {
        int answer = 0;
        while(n != 0){
            answer += n%10;
            n /= 10;
        }
        return answer;
    }
}