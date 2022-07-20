package Packege1.Shujvjiegou.递归;

public class Migong {
       static int count;

    public static void main ( String[] args ) {
        int[][] migong = new int[8][7];
        //1是墙，2是走过的路，3代表死路，0代表未走的路。
        for ( int j = 0 ; j < 7 ; j++ ) {
            migong[ 0 ][ j ] = 1;
        }
        for ( int j = 0 ; j < 7 ; j++ ) {
            migong[ 7 ][ j ] = 1;
        }
        for ( int i = 0 ; i < 8 ; i++ ) {
            migong[ i ][ 0 ] = 1;
        }
        for ( int i = 0 ; i < 8 ; i++ ) {
            migong[ i ][ 6 ] = 1;
        }
        migong[3][1]=1;
        migong[3][2]=1;
        migong[2][2]=1;
        for(int i=0;i<8;i++){
            for(int j =0;j<7;j++){
                System.out.print (migong[i][j]+"  " );
            }
            System.out.println ( );
        }
        System.out.println ("走过的路径为：" );
        Migong m1 = new Migong ();
        m1.lujing(migong,1,1);

        for(int i=0;i<8;i++){
            for(int j =0;j<7;j++){
                System.out.print (migong[i][j]+"  " );
            }
            System.out.println ( );
        }
        System.out.println (count );
    }

    //输入数组、起始位置i j坐标
    public boolean lujing(int[][] t,int i,int j ){

        if(t[6][5]==2){
            return true;
        }else{
            if(t[i][j]==1||t[i][j]==2||t[i][j]==3)
                return false;
            //下 右 上 左的顺序走，走通了写上2，下一个位置继续判断，走到死路写上3
            t[i][j]=2;
            if(lujing (t,i+1,j  )){
                count++;
                return true;
            }else if(lujing (t,i,j+1  )){
                count++;
                return true;
            }else if(lujing (t,i-1,j  )){
                count++;
                return true;
            }else if(lujing (t,i,j-1 )){
                count++;
                return true;
            }else{
                t[i][j]=3;
                return false;
            }

        }

    }
    }



