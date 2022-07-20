package Packege1.Suanfa;

import java.util.Arrays;

public class KMP {
    //找到字符串str2在str1中第一次出现的下标
    public static void main ( String[] args ) {
        String str1 = "ABABCABABAv";
        String str2="ABABAV";
       int[] next= getnext ( str2 );
        System.out.println ( Arrays.toString ( next ) );
        System.out.println (getindex ( str1,str2,next ) );
    }

    public static int getindex(String str1 ,String str2, int[] next){
        char[] c1 = str1.toCharArray ();
        char[] c2 = str2.toCharArray ();
        for(int i=0,j=0;i<str1.length ();i++){

           while(c1[i]!=c2[j] && j>0){
               j=next[j-1];
           }
            if(c1[i]==c2[j]){
                j++;
            }

            if(j==str2.length ()){
                return i-j+1;
            }
        }
        return -1;
    }


    //得到next数组
    public  static int[] getnext(String str2){
        int[] next = new int[str2.length ()];
        next[0]=0;
        char[] str= str2.toCharArray ();

       for(int i =1, j = 0; i<str2.length ();i++ ){

           while(str[i]!=str[j] && j>0){
               j = next[j-1];
           }
          // ab ab ac ab
          // 00 12 30 12
           if(str[i]==str[j]){
               j++;
           }
           next[i]=j;
       }

            return next;
        }

    }


