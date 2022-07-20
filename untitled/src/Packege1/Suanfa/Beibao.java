package Packege1.Suanfa;

import java.util.Arrays;

public class Beibao {
    //背包有4个格子
    //1物品 1 个格子 1500
    //2物品 4个格子  3000
    //3物品 3个格子  2000
    //问怎么装可以最大价值？
    public static void main ( String[] args ) {

        Bag(3,4);
    }
    //m个物品 背包容量n
    public static void Bag(int m,int n){
        int[][] arr = new int[m+1][n+1];
        int[][] temp = new int[m+1][n+1];
        int[] w = {0,1,4,3};
        int[] val = {0,1500,3000,2000};
        for(int i=0;i<n+1;i++){
            arr[0][i]=0;
        }

        for(int i=0;i<m+1;i++){
            arr[i][0]=0;
        }
        //从arr【1】【1】开始放东西
        for(int i = 1;i<m+1;i++){
            //j代表列 和 背包的容量
            //i代表行 和 加物品
            for ( int j = 1 ; j < n + 1 ; j++ ) {
                if ( w[ i ] > j ) {
                    arr[ i ][ j ] = arr[i-1][j];
                } else  {
                    //进行价值的判断
                    if(arr[i-1][j]<val[i]+arr[i-1][j-w[i]]){
                        arr[i][j]=val[i]+arr[i-1][j-w[i]];
                        //有新加入的物品就加入新的数组中
                        temp[i][j]=1;
                        //数组的某个位置等于1 代表这个位置新加了i物品
                    }else{
                        arr[i][j]=arr[i-1][j];
                    }
//                    arr[i][j]=Math.max ( arr[i-1][j],val[i]+arr[i-1][j-w[i]] );
                }
        }
        }

        //最后我们想知道最大价值3500是怎么装的？
        int a = m;
        int b = n;
        while ( a>=0 && b>=0){
            if(temp[a][b]==1){
                System.out.printf ("放入了%d物品\n" , a );
                b=b-w[a];
            }
            a--;

        }


        for(int[] i: arr){
            System.out.println ( Arrays.toString ( i ) );
        }
            for(int[] i: temp){
                System.out.println ( Arrays.toString ( i ) );
            }
}}
