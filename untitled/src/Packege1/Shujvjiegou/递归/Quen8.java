package Packege1.Shujvjiegou.递归;

public class Quen8 {
    static int count=0;
   static int[] list = new int[8];
    public static void main ( String[] args ) {
        Quen8 q8 = new Quen8 ();
       q8.judge ( 0 );

        System.out.println (count );
    }


/**
* 遍历数组
* @Param: [list]
* @return: void
* @Author: mao
* @Date: 2021/10/1
*/
    public void show(int[] list){
        for(int i =0;i<8;i++){
            System.out.print (list[i]+" " );
        }
        System.out.println ( );
    }

    //i 第几行
    public boolean ok(int i){
        for(int t=0; t<i;t++){
            if(list[t]==list[i]||Math.abs ( t-i )==Math.abs ( list[t]-list[i] )){
                return false;
            }
        }
        return true;
    }

    public boolean judge(int hang){
        int t=hang;
        //t=8 代表着 全部通过了
        if(t==8){
            show ( list );
            count++;
            return false;
        }

        for ( int i = 0 ; i < 8 ; i++ ) {
            list[ t ] = i;
            if(ok(t)){
             if(judge ( t + 1 )){
                 return true;
             }
            }
            }
        return false;
        }
        //这一行遍历完了。没有找到合适的。说明上一层有问题 返回false  让上一层向后挪一位
    }


