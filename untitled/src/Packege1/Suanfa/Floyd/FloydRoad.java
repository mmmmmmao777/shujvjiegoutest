package Packege1.Suanfa.Floyd;

import java.util.Arrays;

public class FloydRoad {
    public static void main ( String[] args ) {
        char[] city = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //邻接矩阵
        int[][] graphroad = new int[city.length][city.length];
        final int N = 65535;// 表示不可以连接
        graphroad[0]=new int[]{N,5,7,N,N,N,2};
        graphroad[1]=new int[]{5,N,N,9,N,N,3};
        graphroad[2]=new int[]{7,N,N,N,8,N,N};
        graphroad[3]=new int[]{N,9,N,N,N,4,N};
        graphroad[4]=new int[]{N,N,8,N,N,5,4};
        graphroad[5]=new int[]{N,N,N,4,5,N,6};
        graphroad[6]=new int[]{2,3,N,N,4,6,N};
        Road r1= new Road ( graphroad,city );
        r1.mainn ();
    }

}
class Road{
    int[][] graphroad;
    char[] city;
    int[][] pre;

    public Road ( int[][] graphroad , char[] city ) {
        this.graphroad = graphroad;
        this.city = city;

        pre = new int[ city.length ][ city.length ];
        for ( int i = 0 ; i < city.length ; i++ ) {
            Arrays.fill ( pre[i],i );
//            System.out.println (Arrays.toString ( pre[i] ) );
        }
    }
    public void mainn(){
        buildRoad ();
        for ( int i = 0 ; i < city.length ; i++ ) {
            System.out.println (Arrays.toString ( pre[i] ) );

            System.out.println (Arrays.toString ( graphroad[i] ) );
            System.out.println ('f' );
        }
    }
    public void buildRoad(){
        //i为中间的点 j k分别为前后两端的点
        for(int i =0;i<city.length;i++){
            for(int j =0;j<city.length;j++){
                for(int k=0;k<city.length;k++){
                    if(j==k){
                        graphroad[j][k]=0;
                    }
                   if(graphroad[j][k]>graphroad[j][i]+graphroad[i][k]){
                       graphroad[j][k]=graphroad[j][i]+graphroad[i][k];
                       pre[j][k]=pre[i][k];
                   }
                }
            }
        }

    }

}
