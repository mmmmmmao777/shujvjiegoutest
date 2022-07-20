package Packege1.Shujvjiegou.Search;

import java.util.ArrayList;
import java.util.Arrays;

// 0 1 1 2 3 5 8 13

public class FBNQsearch {
    static int[] i = {1,2};
//    static int[] i = {-3,10,19,19,19,21};
    public static void main ( String[] args ) {
        System.out.println (search(i,0,i.length-1,1) );

    }
    public static int search(int[] i,int left,int right,int t){
        if(t>i[right]||t<i[left]){
            return -1;
        }
        int[] fbnq = new int[20];
        fbnq[0]=0;
        fbnq[1]=1;
        for(int a =2;a<20;a++){
            fbnq[a]=fbnq[a-1]+fbnq[a-2];
        }
        int len = i.length;
        int k=0;
        while(len>fbnq[k]-1){
            k++;
        }
        System.out.println (k );
       int[] temp= Arrays.copyOf ( i,fbnq[k]-1 );
        for(int a = len;a<= fbnq[k]-2;a++){
            temp[a]=i[len-1];
        }
        System.out.println (Arrays.toString ( temp ) );
        //开始 fbnq 分 查找

        while(left<=right){
            int mid;
//            if(k<1){
//                mid = (left+right)/2;
//                System.out.println ("警告 k《1" );
//            }else
                mid = left + fbnq[ k - 1 ] - 1;
//            if(mid <0){
//                mid = (left+right)/2;
//                System.out.println ("警告 mid<0" );
//            }
            //在右边
            if(temp[mid]<t){
                left=mid+1;
                k-=2;
                //在左边
            }else if(t<temp[mid]){
                right=mid-1;
                k--;
            }else{
                //找到了
                if(mid<=right){
                    return mid;
                }else{
                    return right;
                }
            }
        }
        return -1;
//
    }

}
