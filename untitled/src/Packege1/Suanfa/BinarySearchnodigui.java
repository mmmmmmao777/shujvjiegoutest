package Packege1.Suanfa;

public class BinarySearchnodigui {
    public static void main(String[] args){
        int[] arr = {3,5,6,9,10,18,20};
        System.out.println ( binarySearch ( arr,5));
    }

    public static int binarySearch(int[] arr,int target){
        int left=0;
        int right= arr.length-1;
        if(arr==null||target>arr[right]||target<arr[left]){
            return -1 ;
        }
        while(left<=right){
            int mid=(left+right)/2;
            if(target==arr[mid]){
                return mid;
            }else if(target>arr[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
}
