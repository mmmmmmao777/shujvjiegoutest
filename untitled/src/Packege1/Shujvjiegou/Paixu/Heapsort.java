package Packege1.Shujvjiegou.Paixu;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heapsort {

    public static void main ( String[] args ) {
//        int[] arr = new int[]{4 , 6 , 8 , 5 , 9};
        int[] arr = new int[]{3 , 2 , 4 , 1 , 0};
        Heapsort h1 = new Heapsort ( );
        h1.sortAll ( arr );
        System.out.println ( Arrays.toString ( arr ) );
    }





    public void sortAll(int[] arr){
        int len = arr.length;
        //最后一个非叶子结点。
        int n = len/2-1;
        for(int i = n;i>=0;i--){
            sort ( i , arr , len );
        }
        int temp;
        //然后把最后一个位置移除，再构建大顶堆。
        for(int t=len-1;t>0;t--){
            temp=arr[0];
            arr[0]=arr[t];
            arr[t]=temp;
            sort(0,arr,t);
        }
    }



    /**
     * 从下标为i的非叶子节点来排序  数组arr
     *
     * @Param: [i]
     * @return: void
     * @Author: mao
     * @Date: 2021/10/5
     */
    public void sort ( int i , int[] arr , int len ) {
        int temp = arr[ i ];
       for(int k=i*2+1; k<len;k=k*2+1){
           if(k+1<len && arr[k]>arr[k+1]){
               k=k+1;
           }
           if(arr[k]<temp){
               arr[i]=arr[k];
               i=k;
           }else{
               break;
           }
       }


        arr[i]=temp;
    }




}