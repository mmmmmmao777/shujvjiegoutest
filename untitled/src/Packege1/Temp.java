package Packege1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class Temp {
    public static void main(String[] args) {
   cc[] c1 = new cc[5];
   cc c2=new cc();
   c1[0]=c2;
   c2.t=3;
   c1[1]=new cc();

   char[] char1 = new char[2];
   char1[0]='d';
   for(cc c4:c1){
       System.out.println (c4.t);

   }

    }
}
class cc{
    int t ;
}