import server.ServerHeart;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("开始检测客户端是否在线...");
        ServerHeart serverHeart=new ServerHeart();
        serverHeart.start();
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ServerHeart.check(5L);
            }
        }, TimeUnit.MINUTES.toMillis(3L),TimeUnit.MINUTES.toMillis(3L));
    }

}
