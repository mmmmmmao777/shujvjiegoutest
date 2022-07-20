package Test12;

import java.util.*;

public class lee347 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(2,5);
        map.put(3,2);
        map.put(4,6);
        map.put(1,3);
        map.put(7,4);
        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);	//堆中存放的是元素，但比较的应该是元素的频率
        });
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        for(Map.Entry<Integer, Integer> en: entries){
            que.add(en.getKey());
        }
        System.out.println(que);

    }
}
