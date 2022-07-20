package Packege1.practice;

import org.junit.Test;
//正确的基数排序应该这么写：
import java.util.Arrays;

public class JiShuSort {

    @Test
    public void main () {
        JiShuSort j1 = new JiShuSort ();
        int[] arr = {332,10,5,23,56,77,0,66,120};
        arr=j1.jiShuSort (arr);
        System.out.println ( Arrays.toString ( arr ) );
    }


    public int[] jiShuSort(int[] arr){
        if(arr==null || arr.length==0){
            return arr;
        }
      int  length = arr.length;

        int max=arr[0];
      for(int t: arr){
          if(t>max){
             max=t;
          }
      }
       int k=String.valueOf ( max ).length ();
      for(int i=0,j=1;i<k;i++){
          //从头到尾计数
         if(i>0){
             j=j*10;
         }
        arr=jiShu ( arr,j,length );
      }
        return arr;
    }

    public int[] jiShu(int[] arr,int j , int length){
        //申请了一个10位的桶子 0-9
        int[] count = new int[10];
        //申请了一个n位数组
        int[] arrt=new int[length];
        int temp=0;
        for(int i=0;i<length;i++){
            temp=(arr[i]/j)%10;
            count[temp]++;
        }
        for(int i =1; i<10;i++){
            count[i]=count[i]+count[i-1];
        }
        //倒着输出 保持稳定性
        for(int i = length-1;i>=0; i--){
            arrt[--count[(arr[i]/j)%10]]=arr[i];
        }

        return arrt;
    }


}
