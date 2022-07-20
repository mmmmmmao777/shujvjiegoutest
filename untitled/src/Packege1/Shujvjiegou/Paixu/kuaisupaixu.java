package Packege1.Shujvjiegou.Paixu;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class kuaisupaixu {

    public static void main(String[] args) {
         int[] arr = {20,5,9};
        quickSort(arr, 0, arr.length-1);
System.out.println("arr=" + Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int left, int right) {
        //定义两个指针
        if ( left < right ) {
            int l = left;
            int r = right;
            //选第一个为基准；
            int stard = arr[ l ];
            //从右边开始比较
            while ( l < r ) {

                while ( arr[ r ] >= stard && l < r ) {
                    r--;
                }
                //找到比基准小的数时，覆盖左指针，即基准 所在的位置。
                arr[ l ] = arr[ r ];

                while ( arr[ l ] <= stard && l < r ) {
                    l++;
                }
                //找到比基准大的数时，覆盖右指针所在的位置。
                arr[ r ] = arr[ l ];

            }
            //循环完毕后，l和r指针重合 把基准赋值给当前指针所在位置
            arr[ r ] = stard;
            //搞个递归
            quickSort ( arr , left , r-1 );
            quickSort ( arr , r+1, right );
        }

    }}


//}

