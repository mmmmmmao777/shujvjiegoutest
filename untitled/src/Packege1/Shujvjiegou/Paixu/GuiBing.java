package Packege1.Shujvjiegou.Paixu;

import java.util.Arrays;

public class GuiBing {
   static int[] i = new int[]{3,-1,5,9,20,45,3};

    public static void main ( String[] args ) {

        System.out.println ( Arrays.toString ( sort(i,0,i.length-1) ));
    }

    public static int[] sort(int[] i,int first,int last){
        int[] p =null;
        int[] a=null;
        int[] b=null;
        int aa=0;
        int bb=0;
        int j=0;
        //当first小于last时执行方法，否则方法结束
        if(first<last) {
            int mid = ( first + last ) / 2;
            //当first小于last时进行分割
              a= sort ( i , first , mid );
              b= sort ( i , mid + 1 , last );
                //给p赋值；
                p=new int[a.length+b.length];
                while(aa<a.length && bb<b.length){
                    if(a[aa]<b[bb]){
                        p[j]=a[aa];
                        j++;
                        aa++;
                    }else{
                        p[j]=b[bb];
                        j++;
                        bb++;
                    }
                }

                while(aa<a.length){
                    p[j]=a[aa];
                    j++;
                    aa++;
                }

                while(bb< b.length){
                    p[j]=b[bb];
                    j++;
                    bb++;
                }

            return p;
        }
        //分好了，每个一组。
//最后一层只有一个数字，就把他打包成数组，返回上一层
        System.out.println ( i[first]);
        return p=new int[]{i[first]};
    }


}
