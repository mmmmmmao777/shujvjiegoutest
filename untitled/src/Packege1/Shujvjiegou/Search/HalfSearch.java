package Packege1.Shujvjiegou.Search;

import java.util.ArrayList;
import java.util.Collections;

public class HalfSearch {
    static int[] i = {-3,10,19,19,19,19,40,50,55,60};
    public static void main ( String[] args ) {
       ArrayList a1= search2(i,0,i.length-1,19) ;
        System.out.println (" "+a1 );
    }
    //找到一个下标
    public static void search(int[] i,int left,int right,int t ){
        if(left>right){
            System.out.println ("meizhaodao" );
            return;
        }
        int mid=(left+right)/2;
        if(i[mid]==t){
            System.out.println ("找到了，下标为"+mid );
            return;
        }
        if(i[mid]>t){
            search ( i,left,mid-1,t );
        }else{
            search ( i,mid+1,right,t );
        }

}
//找到所有下标
    public static ArrayList search2( int[] i, int left, int right, int t ){
        if(left>right||t>i[right]||t<i[left]){
            return new ArrayList (  );
        }
        int mid=(left+right)/2;
        if(i[mid]==t){
           ArrayList<Integer> arr = new ArrayList<Integer> (  );
           int temp = mid-1;
           while(temp>=0 && i[temp]==t){
               arr.add ( temp );
            temp--;
           }
           arr.add(mid);
           temp=mid+1;
            while(temp<=i.length-1 && i[temp]==t){
                arr.add ( temp );
                temp++;
            }

            return arr;
        }
        if(i[mid]>t){
           return search2 ( i,left,mid-1,t );
        }else{
           return search2 ( i,mid+1,right,t );
        }


    }

}
