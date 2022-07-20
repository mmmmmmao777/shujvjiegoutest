package Packege1.Suanfa;

import java.util.Arrays;

public class DijkstraRoad {
    //有一个图很多城市和线
    // 问：如何计算出 G 村庄到 其它各个村庄的最短距离?
    //每一次都找到与出发城镇最近的那个城镇进行访问，广度遍历后更新未访问城市与first之间的距离。
    // 再找到与first相距最近的城镇的距离...
    //三个核心数组
    //int[] fathercity; 储存当前 最短路径中 与之相连的城镇
    // int[] dis; 储存各城镇与g城镇之间的距离
    //boolean[] isvisited; 储存各城镇是否访问过

    // public void flushDis(int t){
    //        for(int i=0;i<city.length;i++) {
    //            //如果这个城市没有访问过，通过比较大小关系 赋新值。
    //            if(isvisited[i]==false && graphroad[t][i]+dis[t]<dis[i]) {
    //                dis[ i ] = graphroad[ t ][ i ]+dis[t];
    //                setFathercity ( t,i );
    //            }
    //        }
    //    }

    public static void main ( String[] args ) {
        int first = 6;
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
        int[] dis = new int[city.length];
        Arrays.fill ( dis,N );
        dis[first]=0;
        graphRoad gg = new graphRoad ( city.length,city,graphroad,first,dis );
            gg.mainn (  );
    }
}
class graphRoad{
    char[] city ;
    boolean[] isvisited;
    int[][] graphroad ;
    int[] fathercity;
    int[] dis;
    int first;
    graphRoad(int num,char[] city,int[][] graphroad ,int first,int[] dis){
        this.city = city;
        isvisited = new boolean[num];
        this.graphroad=graphroad;
        fathercity=new int[num];
        for(int i=0;i<city.length;i++ ){
            fathercity[i]=i;
        }
//        Arrays.fill ( fathercity,6 );
//        System.out.println (Arrays.toString ( fathercity ) );
        this.first=first;
        this.dis = dis;
    }
    /**
    * 程序执行的入口
    * @Param: [n] n代表 出发城市
    * @return: void
    * @Author: mao
    * @Date: 2021/10/16
    */
    public void mainn(){
        isvisited[first]=true;
        flushDis ( first );

        for(int i=1;i<city.length;i++){
            //循环length-1次，每次都访问距离first最近的那个未访问过的城市
            // 进行刷新距离（与first之间）的操作，再找到最近的未访问城市进行访问
            int minindex=searchMinRoad ( );
            flushDis ( minindex );
        }
        System.out.println (Arrays.toString ( isvisited ) );
        System.out.println (Arrays.toString ( dis ) );
        System.out.println (Arrays.toString ( fathercity ) );

    }
    /**
    *
    * @Param: [pre, index]  输入两个数字，前驱结点和当前节点
    * @return: void
    * @Author: mao
    * @Date: 2021/10/16
    */
    public void setFathercity(int pre,int index){
        fathercity[index]=pre;
    }
    /**
    * 更新输入节点周围的城市与出发城市之间的距离  根据graphroad
    * @Param: [t] t为当前节点下标
    * @return: void
    * @Author: mao
    * @Date: 2021/10/16
    */
    public void flushDis(int t){
        for(int i=0;i<city.length;i++) {
            //如果这个城市没有访问过，通过比较大小关系 赋新值。
            if(isvisited[i]==false && graphroad[t][i]+dis[t]<dis[i]) {
                dis[ i ] = graphroad[ t ][ i ]+dis[t];
                setFathercity ( t,i );
            }
        }
    }
    /**
    * 找到距离first最短的一个路 准备将它visited
    * @Param: []
    * @return: void
    * @Author: mao
    * @Date: 2021/10/16
    */
    public int searchMinRoad(){
        int min = 65535;
        int index=-1;
        for(int i=0; i<dis.length;i++){
        if(isvisited[i]==false && dis[i]<min){
            min=dis[i];
            index=i;
        }
        }
        isvisited[index]=true;
        return index;
    }



}
