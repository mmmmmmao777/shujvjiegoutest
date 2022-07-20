package Packege1.Shujvjiegou.Paixu;

import java.util.Arrays;

public class Guibing01 {


    public static void main ( String[] args ) {
       int[] i = new int[]{3,-1,5,10,8,9,20,45,3};
        int[] temp = new int[i.length];
        sort ( i,0,i.length-1,temp );
        System.out.println ( Arrays.toString ( i ) );
    }
    public static void sort(int[] i,int left,int right,int[] temp){
        if(left>=right) {
            return;
        }
            int mid = ( left + right ) / 2;
            sort(i,left,mid,temp);
            sort(i,mid+1,right,temp);
            combine ( i,left,mid,right,temp );

    }

    public static  void combine(int[] i,int left,int mid ,int right,int[] temp){
        int l1=left;
        int l2 = mid+1;
        int n = 0;
        while(l1<=mid && l2<=right ){
            if(i[l1]<=i[l2]){
                temp[n]=i[l1];
                n++;
                l1++;
            }else{
                temp[n]=i[l2];
                n++;
                l2++;
            }
        }
        while(l1<=mid){
            temp[n]=i[l1];
            n++;
            l1++;
        }
        while(l2<=right){
            temp[n]=i[l2];
            n++;
            l2++;
        }
        //排好序了，在temp中，最后一个元素下标为n
         n=0;
        while(left<=right){
           i[left]= temp[n];
           left++;
           n++;
        }

    }
}
