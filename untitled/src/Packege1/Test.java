package Packege1;

import sun.java2d.pipe.SpanIterator;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.BlockingQueue;

public class Test {


    public static void main(String[] args) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        map1.put(10,10);
        map1.put(3,20);
        map1.put(5,15);
        map1.put(6,1);
    PriorityQueue<Integer> que = new PriorityQueue<>((x,y)->map1.get(x)-map1.get(y) );

        map1.forEach((x,y)->{
            System.out.println(x+" "+y);
            que.add(x);
        });

        System.out.println(que);

    }
}


