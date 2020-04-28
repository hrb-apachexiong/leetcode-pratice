package thread;

import java.util.concurrent.atomic.AtomicInteger;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-04-23<p>
// 注释说明
// -------------------------------------------------------
public class UlimitThread {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i = 0; i < 1000000; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("#######start " + atomicInteger.incrementAndGet());
                        Thread.sleep(1000000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            });
        }
    }
}
