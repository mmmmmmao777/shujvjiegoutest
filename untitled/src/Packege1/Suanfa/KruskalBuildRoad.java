package Packege1.Suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KruskalBuildRoad {
    public static void main ( String[] args ) {
        int INF = Integer.MAX_VALUE;
        int[][] allroad = new int[][]
      /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
/*A*/ {{ 0, 12, INF, INF, INF, 16, 14},
/*B*/ { 12, 0, 10, INF, INF, 7, INF},
/*C*/ { INF, 10, 0, 3, 5, 6, INF},
/*D*/ { INF, INF, 3, 0, 4, INF, INF},
/*E*/ { INF, INF, 5, 4, 0, 2, 8},
/*F*/ { 16, 7, 6, INF, 2, 0, 9},
/*G*/ { 14, INF, INF, INF, 8, 9,0}};
        char[] city = {'A','B','C','D','E','F','G'};
    Road r1 = new Road ( allroad.length,city,allroad );
        int numline=r1.buildLine ();
        r1.sortLine ();
        for(Line l :r1.ll){
            System.out.println (l );
        }
        int[] ends = new int[numline];
        r1.selectLine(ends);
       for(Line l1 :r1.selectline){
           System.out.println (city[l1.a]+"到"+city[l1.b]+"的距离是"+l1.weight );
       }
        System.out.println ( Arrays.toString ( ends ) );
    }

}
class Road{
    //城市的数目
    int num;
    int[][] allroad;
    char[] city;
    int INF = Integer.MAX_VALUE;
    Line[] ll;
    ArrayList<Line> selectline = new ArrayList<> (  );
    public Road ( int num ,char[] city,int[][] allroad) {
        this.num = num;
        this.allroad  = allroad;
        this.city=city;
    }

    /**
    * 计算得到有多少条路线,并构造储存 Line信息的对象数组 l    返回路线的总数目
    * @Param: []
    * @return: int
    * @Author: mao
    * @Date: 2021/10/16
    */
    public int buildLine(){
    int count=0;
        for(int i = 0;i<num;i++){
            for(int j=i+1;j<num;j++){
                if(allroad[i][j]!=INF ){
               count++;
            }
        }
    }
 ll = new Line[count];
        int temp=0;
        //构造储存 Line信息的对象 数组 l
        for(int i = 0;i<num;i++){
            for(int j=i+1;j<num;j++){
                if(allroad[i][j]!=INF){
                    //ll中存着很多line对象 包含前后节点和路径长度的信息
                   ll[temp++] = new Line (i,j,allroad[i][j]);
                }
            }
        }
return count;

}
    //按照距离从短到长排个序  循环快速排序
public void sortLine(){
        Line temp=null;
        int left= 0;
        int right = ll.length-1;
    Stack<Integer> stack = new Stack<> ();
    //用栈的方法来进行快速排序
    stack.push ( right );
    stack.push ( left );
    while(!stack.empty ()){
      int fr= stack.pop ();
      int la = stack.pop();
     int front =fr;
     int last = la;
     temp=ll[front];
     while(front<last){
         while(ll[last].weight>=temp.weight && front<last){
             last--;
         }
         ll[front]=ll[last];
         while(ll[front].weight<=temp.weight && front<last){
             front++;
         }
         ll[last]=ll[front];
     }
     //此时左右两个指针指向同一个位置。
     ll[last]=temp;
     if(last-1>fr){
     stack.push ( last-1 );
     stack.push ( fr );
    }
     if(last+1<la){
         stack.push ( la );
         stack.push ( last+1 );
     }
    }
}

//按照路线长度排好序之后 进行比较加入
    public void selectLine(int[] ends){
       for(int i=0;i<ll.length;i++){
        int last1 = getends ( ends,ll[i].a );
        int last2= getends ( ends,ll[i].b );
        if(last1!=last2){
            selectline.add ( ll[i] );
            ends[last1]=last2;
        }
    }
    }

    //得到最终的城市下标
    public int getends(int[] ends,int i){
        while(ends[i]!=0){
            i=ends[i];
        }
        return i;
    }
    //根据char城市名得到下标
    public int getnum ( char c ) {
        for ( int i = 0 ; i < num ; i++ ) {
            if( city[i]==c){
                return i;
            }
        }
        return -1;
    }



}
class Line{
    //路两端
    int a;
    int b;
    int weight;

    public Line ( int a , int b , int weight ) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public String toString ( ) {
        return "Line{" +
                "前城市" + a +
                "到后城市" + b +
                "距离为" + weight +
                '}';
    }

}
