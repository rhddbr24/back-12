public class ex13_7 {
    static volatile boolean stopped = false;

    public synchronized static void main(String[] args) {
        Thread5 th1 = new Thread5();
        th1.setDaemon(true);
        th1.start();
        try {
            Thread.sleep(6*1000);
        } catch(Exception e) {}
        stopped = true;
        // 쓰레드를 정지시킨다.
        System.out.println("stopped");
//        th1.interrupt();
//        th1.interrupt();
    }
}

class Thread5 extends Thread {
    public void run() {
// Exercise13_7.stopped의 값이 false인 동안 반복한다.
        for(int i=0; !ex13_7.stopped; i++) {
            System.out.println(i);
            try {
                Thread.sleep(5*1000);
            } catch(Exception e) {}
        }
    } // run()
}