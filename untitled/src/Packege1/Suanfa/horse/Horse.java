package Packege1.Suanfa.horse;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Horse {
   static int[][] pan;
    int X;
    int Y;

    boolean finished;
    public Horse ( int x , int y ) {
        X = x;
        Y = y;
        pan=new int[x][y];
    }

    public static void main ( String[] args ) {
        Horse h1 = new Horse (6,6);
      Long l1  =System.currentTimeMillis () ;
        h1.horsego ( 4,3,1 );
        for(int[] i:pan){
        System.out.println ( Arrays.toString ( i ) );}
        System.out.println (System.currentTimeMillis ()-l1 );
    }
    //出发点 i，j
    public void horsego(int i,int j,int step){

        pan[i][j]=step;

        ArrayList<Point> arr=getArroundPoint ( i,j );
        sort1 ( arr );
        while(!arr.isEmpty ()){

          Point p =  arr.remove ( 0 );
          if(pan[p.x][p.y]==0){
              horsego ( p.x,p.y,step+1 );
          }
        }
        //这时候遍历完了，有两个情况
        //1.所有点都被遍历完了，回溯全部
        //2.没有遍历完，回溯再找

        //两个条件都满足，说明没有遍历完，需要回溯再找
        if(step<X*Y && !finished ){
            pan[i][j]=0;
        }else{
            //有一个不满足，说明每一个点都走过，需要回溯全部
            //最后一步满足，一旦step==x*y  直接把finished变为true；回溯过程中这个判断就满足不了了，
            // 可以一直往上回溯。pan【i】【j】就保存了下来
            finished=true;

        }
    }

    //得到输入点 棋盘内 周围八个点 把他们加入到arr中传出来
    public ArrayList<Point> getArroundPoint(int x,int y){
        ArrayList<Point> arr = new ArrayList<> (  );
        if(y-2>=0 &&  x-1>=0){
            arr.add ( new Point ( x-1,y-2 ) );
        }
        if(y-1>=0 &&  x-2>=0){
            arr.add ( new Point ( x-2,y-1 ) );
        }
        if(y+1<Y &&  x-2>=0){
            arr.add ( new Point ( x-2,y+1 ) );
        }
        if(y+2<Y &&  x-1>=0){
            arr.add ( new Point ( x-1,y+2 ) );
        }

        if(y-2>=0 &&  x+1<X){
            arr.add ( new Point ( x+1,y-2 ) );
        }
        if(y+2<Y &&  x+1<X){
            arr.add ( new Point ( x+1,y+2 ) );
        }

        if(y-1>=0 &&  x+2<X){
            arr.add ( new Point ( x+2,y-1 ) );
        }
        if(y+1<Y &&  x+2<X){
            arr.add ( new Point ( x+2,y+1 ) );
        }
        return arr;
    }


    //优化 贪心算法 下一步 选择 下一步的下一步 最少的那一个
    public  void sort1(ArrayList<Point> arr){
        Collections.sort ( arr , new Comparator<Point> ( ) {
            @Override
            public int compare ( Point o1 , Point o2 ) {
                return   getArroundPoint(o1.x,o1.y).size ()-getArroundPoint(o2.x,o2.y).size ();

            }
        } );
    }
}
