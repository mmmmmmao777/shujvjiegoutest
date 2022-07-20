package Packege1.Shujvjiegou.Paixu;


import java.util.Arrays;

public class Quicksortpractice {
   static int[]  i = new int[]{3,-1,9,-10,99,9,8,4,90,-6};

    public static void main ( String[] args ) {
        sort(i,0,i.length-1);
        System.out.println ( Arrays.toString ( i ) );
    }

    public static  void sort(int[] i,int first,int last){
        if(first<last) {
            //把第一个当做中间的数，左右分大小
            int mid = i[ first ];
            int l = first;
            int r = last;
            while ( l < r ) {
                while ( l < r && i[ r ] >= mid ) {
                    r--;
                }
                i[ l ] = i[ r ];
                while ( l < r && i[ l ] <= mid ) {
                    l++;
                }
                i[ r ] = i[ l ];
            }
            i[ l ] = mid;

            sort ( i , first , l-1 );
            sort ( i , l + 1 , last );

        }
    }
}
