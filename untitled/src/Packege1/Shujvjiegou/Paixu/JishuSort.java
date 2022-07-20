package Packege1.Shujvjiegou.Paixu;

import java.util.Arrays;

public class JishuSort {
    static int[] i = new int[]{3,5,100,8,9,20,45,3};
    public static void main ( String[] args ) {
        sort ( i );
        System.out.println ( Arrays.toString ( i ) );
    }
    public static void sort(int[] i){
       int len= i.length;
       int[][] bucket = new int[10][len];
       int[] arr = new int[10];

       //找出最大的位数n
        int max = 0;
       for(int t = 0;t<i.length;t++){
           if(i[t]>max){
               max=i[t];
           }
        }
       int n = (max+"").length ();
       int count;
       //循环放入取出桶
       for(int k=0,j=1;k<n;k++,j*=10) {
           for ( int a = 0 ; a < i.length ; a++ ) {
               count = i[a] /j% 10;
               bucket[ count ][ arr[ count ] ] = i[ a ];
               arr[ count ]++;
           }
           int index = 0;
           //遍历0-9个桶，如果桶中不为空，那么就循环取出。
           for ( int b = 0 ; b < 10 ; b++ ) {
               if ( arr[b] != 0 ) {
                   for ( int t = 0 ; t < arr[ b ] ; t++ ) {
                       i[ index ] = bucket[ b ][ t ];
                       index++;
                   }
               }
               arr[ b ] = 0;
           }
       }

    }



}
