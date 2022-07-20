package Packege1.Shujvjiegou.Paixu;

import java.util.Arrays;

public class GuibingSortpractice {
    //归并排序分为两步 分开 和 排序组合
    static int[] i = new int[]{3,-1,5,10,8,9,20,45,3};
    static int[] temp = new int[i.length];
    public static void main ( String[] args ) {

            fenkai ( i,0,i.length-1);
        System.out.println ( Arrays.toString ( i ) );
    }


    public static void fenkai(int[] i,int left,int right){
        int mid = ( left + right ) / 2;
        if ( left < right ) {
            //分为左右两边
            fenkai ( i , left , mid  );
            fenkai ( i , mid + 1 , right);
            //左右两边进行排序
            merge ( i,left,mid,right,temp );
    }
    }

    public static void  merge(int[] i,int left,int mid,int right,int[] temp){
      int  t1=left;
      int  t2=mid+1;
        int a=0;
        while(t1<=mid&&t2<=right) {
            if ( i[ t1 ] <= i[ t2 ] ) {
                temp[ a ] = i[ t1 ];
                t1++;
                a++;
            } else {
                temp[ a ] = i[ t2 ];
                t2++;
                a++;
            }
        }
        while(t1<=mid){
            temp[a]= i[t1];
            t1++;
            a++;
        }
        while ( t2<=right ){
            temp[a]=i[t2];
            t2++;
            a++;
        }


         a=0;
        int temptt=left;
        //把i数组中的顺序替换掉
        while(temptt<=right){
            i[temptt]=temp[a];
            a++;
            temptt++;

        }
        System.out.println (left+" "+right );
    }
}
