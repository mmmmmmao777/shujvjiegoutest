package Packege1.Shujvjiegou.Paixu;

public class Charu {
    static int[] i;
    public static void main ( String[] args ) {
        i = new int[]{-1,3,9,-4,99,10,9};
        Charu s1 = new Charu ();
        s1.cha ( i );
        for(int t: i){
            System.out.print ( t+" ");
        }
    }
    public void cha(int[] i){
        int temp=0;
        for(int t=1;t<i.length;t++){
            //前面的有序数组；
            temp=i[t];
            for(int a=t-1;a>=0;a--){
                //如果这一个数大于等于有序数组中的一个位置，那么就赋值给这个位置后面
                if(temp>=i[a]){
                    i[a+1]=temp;
                    break;
                }else{
                    //如果这个数小于某个位置，就将这个位置的数后移一位。腾出位置。
                    i[a+1]=i[a];
                }
            }
            if(i[0]==i[1]){
               i[0]=temp;
            }
        }
    }

}


