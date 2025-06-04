public class ArgsApp2 {
    public static void main(String[] args) {
        float sum = 0f;
        float ave = 0f;
        for (int i = 0; i < args.length; i++){
            sum += Float.parseFloat(args[i]);
        }
        ave = sum / args.length;
        System.out.printf("합계: %.1f\n",sum);
        System.out.printf("평균: %.2f",ave);
    }
}
