package Packege1.Shujvjiegou.递归;

import java.util.Arrays;

public class QUen88practice {
    static int count=0;
    static int[] list = new int[8];
    public static void main ( String[] args ) {
        quen(0);
    }
    public static void  quen(int i){
        int t=i;
        if(i==8){
            System.out.println ( Arrays.toString ( list ));
            System.out.println (++count );
        }else{
                for(int j = 0;j<8;j++) {
                    list[ t ] = j;
                    if ( isok ( t ) ) {
                        quen ( t + 1 );
                    }
                }

            }


        }


    public static boolean isok(int a){
        if(a==0){
            return true;
        }
        for(int i=0;i<a;i++){
        if(list[a]==list[i]||Math.abs ( a-i )==Math.abs ( list[a]-list[i] ) ){
            return false;
        }
        }
        return true;
    }

}
