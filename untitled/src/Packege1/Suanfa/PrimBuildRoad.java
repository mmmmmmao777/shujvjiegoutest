package Packege1.Suanfa;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.sql.SQLOutput;

public class PrimBuildRoad {

    public static void main ( String[] args ) {
Graph1 graph1 = new Graph1 ( 7 );
MinTree mintree = new MinTree ( graph1 );
        graph1.allroad = new int[][]{{10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};
        graph1.town = new char[]{'A','B','C','D','E','F','G'};
            mintree.creatTree ( 0);
        System.out.println (mintree.b );
    }

}
//构造村庄的最小生成树
class MinTree{
    Graph1 graph;

    int b;
    int[] visited;
    public MinTree(Graph1 graph){
        this.graph=graph;
        visited =new int[graph.num];
         b = graph.num;
    }

    //从第n个村庄开始
    public void creatTree(int n) {
        visited[ n ] = 1;
        //遍历需要graph.num-1次
        for ( int t = 1 ; t < graph.num ; t++ ) {
           int  minweight = 10000;
         //存放最短路径所连的城市
            int a=-1;
            int b=-1;
            //i代表已经走过的那个村庄
            for ( int i = 0 ; i < graph.num ; i++ ) {
                if(visited[i]==0){
                    continue;
                }
                //j代表没有走过的村庄 并且与已走过村庄相连
                for(int j=0;j<graph.num;j++){
                    if(visited[j]==0 && graph.allroad[i][j]<minweight){
                    minweight=graph.allroad[i][j];
                    a=i;
                    b=j;
                    }

                }
            }
            //找到了与当前路径相连 最短的路径
            System.out.println ( "把"+graph.town[a]+"和"+graph.town[b]+"连起来"+"路长为"+minweight );
            visited[b]=1;
        }

    }

}


class Graph1{
   int num;
   char[] town ;
   int[][] allroad;

    public Graph1 ( int num ) {
        this.num = num;
      town = new char[num];
      allroad =new int[num][num];
    }
}
