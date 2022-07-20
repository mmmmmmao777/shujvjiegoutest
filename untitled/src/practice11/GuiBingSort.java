package practice11;

import org.junit.Test;

import java.util.Arrays;

public class GuiBingSort {
    @Test
    public void main(){
        int[] arr = {332,10,5,23,56,77,0,66,120};
        guiBing ( arr,0,arr.length-1 );
        System.out.println ( Arrays.toString ( arr) );
    }

    public void guiBing(int[] arr,int left,int right){
        int mid = (left+right)/2;
        if(left<mid){
            guiBing ( arr,left,mid );
        }
        if(right>mid){
            guiBing ( arr,mid+1,right );
        }
        int[] arr1 = new int[arr.length];
        int before=left;
        int after = mid+1;
        int count=0;
        while(before<=mid && after<=right){
            if(arr[before]<=arr[after]){
                arr1[count++]=arr[before++];
            }else{
                arr1[count++]=arr[after++];
            }
        }
        while(before<=mid){
            arr1[count++]=arr[before++];
        }
        while(after<=right){
            arr1[count++]=arr[after++];
        }
        count=0;
        while(left<=right){
            arr[left++]=arr1[count++];
        }

    }



}
