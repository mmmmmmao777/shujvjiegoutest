package Packege1.day01;

import java.util.*;

public class Daoxu {
    public static void main ( String[] args ) {
        Scanner s1 = new Scanner(System.in);
        List l1 = new ArrayList (  );
        int count=0;
        while(s1.hasNext ()){
          l1.add(Integer.parseInt ( s1.next () ));
          count++;
          if(count>=10)
              break;
        }

        Comparator<Integer> cc= new Comparator<Integer> ( ) {

            @Override
            public int compare ( Integer o1 , Integer o2 ) {
                return o2-o1;
            }
        };

        Collections.sort ( l1,cc );
        Iterator ii =l1.iterator ();
        while(ii.hasNext ())
            System.out.println (ii.next () );
    }


    }


