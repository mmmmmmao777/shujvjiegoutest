package Test12;



import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadOutPut extends ReentrantLock {

    int temp=0;


    //输出
    public void print(Condition thisCon,Condition nextCon){
        while(temp<101){
            this.lock();
            try {
                thisCon.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打印
            if(temp<101){
                System.out.println(Thread.currentThread().getName()+" : "+ temp++);
            }
            nextCon.signal();
            this.unlock();
        }
    }

    public void start(Condition thisCon){
         this.lock();
         thisCon.signal();
         this.unlock();
    }

    //开始

}
