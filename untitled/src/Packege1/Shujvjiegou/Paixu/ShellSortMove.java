package Packege1.Shujvjiegou.Paixu;

import java.util.Arrays;

/**
* 希尔排序移动法
* @Param:
* @return:
* @Author: mao
* @Date: 2021/10/2
*/
public class ShellSortMove {
    static int[] i;
    public static void main ( String[] args ) {
        i = new int[]{3,-1,9,-10,99,10,9,8,4,-6};
        sort ( i );
        System.out.println ( Arrays.toString ( i ) );
    }
    public static void sort(int[] arr){
        int temp=0;
        for(int a= arr.length/2;a>0;a/=2){
            //步长为a；分为a组；
            for(int b = a;b<arr.length;b++){
                int c =b-a;
                temp= arr[b];
                //倘若目标的左边第一个数比他小，就没必要执行赋值语句了，直接跳过 arr[c+a]=temp;
                //算是优化技巧
                if(arr[c]>temp) {
                    while ( c >= 0 && arr[ c ] > temp ) {
                        arr[ c + a ] = arr[ c ];
                        c -= a;
                    }
                    //出了循环表示位置已经找到 为c+a；
                    arr[c+a]=temp;
                }

                }
            }

        }
    }

