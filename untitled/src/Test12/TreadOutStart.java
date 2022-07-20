package Test12;

import java.util.concurrent.locks.Condition;

public class TreadOutStart {
    public static void main(String[] args) {
        ThreadOutPut th = new ThreadOutPut();
        Condition condition1 = th.newCondition();
        Condition condition2 = th.newCondition();
        Condition condition3 = th.newCondition();
        new Thread(()->{
            th.print(condition1,condition2);
        },"a").start();
        new Thread(()->{
            th.print(condition2,condition3);
        },"b").start();
        new Thread(()->{
            th.print(condition3,condition1);
        },"c").start();
        th.start(condition1);
    }

}
