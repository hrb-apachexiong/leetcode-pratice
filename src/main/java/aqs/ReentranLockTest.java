package aqs;

import java.util.concurrent.locks.ReentrantLock;

// --------------------- Change Logs----------------------
// <p>@author bjhexiong Initial Created at 2020-02-23<p>
// 注释说明
// -------------------------------------------------------
public class ReentranLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        System.out.println(lock.getHoldCount());
    }
}
