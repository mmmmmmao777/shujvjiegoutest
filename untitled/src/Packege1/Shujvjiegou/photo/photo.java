package Packege1.Shujvjiegou.photo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class photo {
    int weight=1;
    int edgenum=0;
    ArrayList<String> arr;
    int[][] edges ;
  boolean visit[];
    public photo ( int nodenum ) {
        arr = new ArrayList<> ( nodenum );
        edges  = new int[nodenum][nodenum];

    }
public String getValue(int i){
        return arr.get ( i );
}
    public void insertEdges(int i ,int j){
    edges[i][j]=weight;
        edges[j][i]=weight;
        edgenum++;
    }
    public int getEdgenum(){
        return edgenum;
    }
    public int getNodenum(){
        return arr.size ();
    }
    public void addNode(String str){
        arr.add ( str );
    }
    public void showGraph(){
        for(int[] i: edges){
            System.out.println ( Arrays.toString ( i) );
        }
    }
    public int getFirstneib(int i){
        int  num=getNodenum();
        for(int t=0;t<num;t++ ){
            if(edges[i][t]==weight){
                return t;
            }
        }
        return -1;
    }

    public int getNextneib(int i,int j){
        int  num=getNodenum();
        for(int t=j+1;t<num;t++){
            if(edges[i][t]==weight){
                return t;
            }
        }
        return -1;
    }

    public void shenduShow(){
        visit = new boolean[7];
      int  num=getNodenum();
        for(int i=0;i<num;i++){
            if(visit[i]!=true){
        shenduShow ( i );
    }}
    }
    //深度遍历
    public void shenduShow(int i){
        System.out.print( getValue ( i )+"-->");
        visit[i]=true;
        //i 是行  n是列
       int n= getFirstneib ( i );

       while(n!=-1) {
           if ( visit[ n ] != true ) {
               shenduShow ( n );
           }
           n= getNextneib ( i , n );
       }
    }
    //需要一个队列来记录输出过哪些结点
    public void broadShow(int i){
        LinkedList<Integer> list = new LinkedList<Integer> (  );
        list.add ( i );
        visit[i]=true;
        System.out.print ( getValue ( i ) + "-->");
        while ( ! list.isEmpty ( ) ) {
            int m = list.removeFirst ( );
            int n = getFirstneib ( m );
            //n是列下标
            while(n!=-1) {
                if ( visit[ n ] == false ) {
                    System.out.print ( getValue ( n ) + "-->" );
                    visit[ n ] = true;
                    list.addLast ( n );
                }
                //n 取下一个 坐标
                n=getNextneib ( m,n );
            }

        }
    }
    public void broadShow(){
        visit = new boolean[7];
        for(int i=0;i<getNodenum();i++){
            if(visit[i]==false){
            broadShow ( i );}
        }
    }

    public static void main ( String[] args ) {
photo p1 = new photo ( 7 );
        String[] str = new String[]{"A","B","C","D","E","F","G"};
        for(String s:str){
            p1.addNode ( s );
        }
        p1.insertEdges ( 0,1 );
        p1.insertEdges ( 0,2 );
        p1.insertEdges ( 0,4 );
        p1.insertEdges ( 1,2 );
        p1.insertEdges ( 2,3 );
        p1.insertEdges ( 5,6 );
        p1.showGraph ();
//        p1.shenduShow ( 3);
        p1.broadShow (  );
    }
}
class Wang{


}
class Node{
    String name;

}
