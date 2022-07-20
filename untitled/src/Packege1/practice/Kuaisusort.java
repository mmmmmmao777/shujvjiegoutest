package Packege1.practice;

import Packege1.Shujvjiegou.Paixu.KuaiSuSort;

import java.util.Arrays;

public class Kuaisusort {
    public static void main ( String[] args ) {
        int[] t = {6,9,2,6,6,5};
        Kuaisusort k1 = new Kuaisusort ( );
        k1.sort ( 0 , t.length-1 , t );
        System.out.println ( Arrays.toString ( t ) );
    }

    public void sort ( int left , int right , int[] arr ) {
        if ( left > right || arr.length == 0 || arr == null ) {
            System.out.println("输入错误");
            return;
        }
        int temp = arr[ left ];
        int first = left;
        int last = right;

        while ( last > first ) {
            while ( arr[ last ] >= temp && last > first ) {
                last--;
            }
            arr[ first ] = arr[ last ];

            while ( arr[ first ] <= temp && last > first ) {
                first++;
            }

            arr[ last ] = arr[ first ];

        }

        //相等了
        arr[ last ] = temp;
        //一轮循环完了
        if ( left < last - 1 ) {
            sort ( left , last - 1 , arr );
        }
        if ( last < right - 1 ) {
            sort ( last + 1 , right , arr );
        }
    }
}
