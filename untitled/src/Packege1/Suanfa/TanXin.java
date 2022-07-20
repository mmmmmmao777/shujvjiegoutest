package Packege1.Suanfa;

import java.util.HashMap;
import java.util.HashSet;

public class TanXin {
    public static void main ( String[] args ) {
        test();
    }

    public static void test(){
       HashMap<String, HashSet> guangbo= new HashMap<String, HashSet> (  );
       HashSet h1 = new HashSet (  );
       h1.add ( "北京" );
        h1.add ( "上海" );
        h1.add ( "天津" );

        HashSet h2 = new HashSet (  );
        h2.add ( "北京" );
        h2.add ( "广州" );
        h2.add ( "深圳" );


        HashSet h3= new HashSet (  );
        h3.add ( "上海" );
        h3.add ( "成都" );
        h3.add ( "杭州" );

        HashSet h4 = new HashSet (  );
        h4.add("上海");
        h4.add("天津");

        HashSet h5 = new HashSet (  );
        h5.add("杭州");
        h5.add("大连");

        guangbo.put("K1",h1);
        guangbo.put("K2",h2);
        guangbo.put("K3",h3);
        guangbo.put("K4",h4);
        guangbo.put("K5",h5);

        HashSet allcity = new HashSet (  );
        allcity.addAll ( h1 );
        allcity.addAll ( h2 );
        allcity.addAll ( h3 );
        allcity.addAll ( h4 );
        allcity.addAll ( h5 );



       //还有城市没有被覆盖时循环
       while(!allcity.isEmpty ()){
           String max = "";
           HashSet temp = null;
           //取每一个广播进行遍历 找出覆盖最多城市的那个广播 max
           for(String str : guangbo.keySet ()){
         temp=  guangbo.get ( str );
         //temp中有多少没有覆盖的城市
         temp.retainAll ( allcity );

         if(temp.size ()>0 ){

             if(max.length ()==0){
                 max=str;
             }else{
               HashSet hh = guangbo.get ( max );
               hh.retainAll ( allcity );
               if(temp.size ()>hh.size ()){
                   max=str;
               }
             }
         }
       }
           //找到了覆盖最多城市的那个广播 max
           //删除已经广播的城市
           allcity.removeAll ( guangbo.get (max  ) );
           System.out.println (allcity );
           System.out.println ("选择"+max+"广播" );
           guangbo.remove ( max );
       }


    }
}
