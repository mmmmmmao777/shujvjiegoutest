package Packege1.Shujvjiegou.Paixu;

import java.util.Arrays;

public class ShellSortpractice {
    static int[] i;
    public static void main ( String[] args ) {
        i = new int[]{3,-1,9,-10,99,10,9,4,-6};
        sort(i);
        System.out.println ( Arrays.toString ( i ) );
    }

    public static void sort(int[ ] i){
        int len=i.length;
        int c;
        int temp;
        //a为分的组数，同时也是步长
        for(int a=len/2;a>0;a/=2){
            for(int b=a;b<len;b++){
               c=b-a;
                temp=i[b];
                while(c>=0&&temp<i[c]){
                    i[c+a]=i[c];
                    c-=a;
                }
                   i[c+a]=temp;
                    }
                }
            }
        }


