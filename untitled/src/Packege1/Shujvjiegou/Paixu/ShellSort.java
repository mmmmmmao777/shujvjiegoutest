package Packege1.Shujvjiegou.Paixu;
//希尔排序交换法 拿到最右端的数后，将其向左两两比较交换 效率较低
public class ShellSort {
   static int[] i;
    public static void main ( String[] args ) {
        i = new int[]{3,-1,9,-10,99,10,9,8,4,-6};
        sort(i);
        for(int t: i){
            System.out.print ( t+" ");
        }
    }
    public static void sort(int[] arr){

        for(int c=arr.length/2;c>0;c/=2){
        for(int a = c;a<arr.length;a++){
            for(int b=a-c;b>=0;b-=c){
                if(arr[b]>arr[b+c]){
                    int temp = arr[b];
                    arr[b]=arr[b+c];
                    arr[b+c]=temp;
                }
            }
        }
        }


////第一次循环，分为5个组，步长为5；

//        //第二次循环 分为2个组，步长为2
//        for(int a = 2;a<arr.length;a++){
//            for(int b=a-2;b>=0;b-=2){
//                //每一组在组内倒着循环，把最右边的数交换到应该在的位置。
//                if(arr[b]>arr[b+2]){
//                    int temp = arr[b];
//                    arr[b]=arr[b+2];
//                    arr[b+2]=temp;
//                }
//            }
//        }
//
    }

}
