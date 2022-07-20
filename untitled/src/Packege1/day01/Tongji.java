package Packege1.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.*;

public class Tongji {
    public static void main ( String[] args ) {
    Tongji1 t1 = new Tongji1 ();
    t1.tj ();
    }
}
class Tongji1{
    public void tj(){
        HashMap<Character,Integer> h1 = new HashMap<Character , Integer> (  );
        try {
            FileReader f1 = new FileReader("C:\\Users\\LEGION\\Desktop\\姓名.txt");
            BufferedReader b1 = new BufferedReader ( f1 );

            String str;
            while((str=b1.readLine ())!=null){
                char cc =str.charAt ( 0 );
//                System.out.println ( str);
                if(cc==' '){
                    continue;
                }
                if(null==h1.get(cc)){
                h1.put ( cc,1 );
                }else{
                    int count=h1.get(cc);
                    count++;
                    h1.put ( cc,count );
                }
            }

//           Set<Map.Entry<Character,Integer>> s1 = h1.entrySet ();
//           Iterator ii = s1.iterator ();
//            while(ii.hasNext ()){
//              Map.Entry mm = (Map.Entry)ii.next ();
//                System.out.println ( mm.getKey ()+"姓的人数是："+mm.getValue ());
//            }
            Set<Character> s1 = h1.keySet ();
            for(char c1: s1){
                System.out.println ( c1+"姓的人数是："+ h1.get(c1));
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }


    }



}
