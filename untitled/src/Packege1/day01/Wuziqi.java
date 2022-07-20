package Packege1.day01;

import org.junit.Test;

import java.io.Serializable;


public class Wuziqi implements Serializable {
    private static final long serialVersionUID = 146564521L;
    int[][] qipan = new int[11][11];
    int[][] xishu;

    public int[][] qipan(){
        //黑色 1 白子 2
        qipan[1][2]=1;
        qipan[2][3]=2;
        int t =0;
        for(int[] i1 : qipan){
            for(int i2 :i1){
                System.out.printf ( "%d\t",i2);
            }
            System.out.println ( );
        }
    int count=0;

        for(int i=0 ;i<11; i++){
           for(int j =0; j<11;j++){
               if(qipan[i][j]!=0){
                   count++; }
            }
        }
        System.out.println (count );


         xishu = new int[count+1][3];
        xishu[0][0]=11;
        xishu[0][1]=11;
        xishu[0][2]=count;

                int count1=1;
            for(int i1=0 ;i1<11; i1++){
                for(int j =0; j<11;j++){
                    if(qipan[i1][j]!=0){
                        xishu[count1][0]=i1;
                        xishu[count1][1]=j;
                        xishu[count1][2]=qipan[i1][j];
                        count1++;
                    }
                }
            }
            for(int[] i :xishu){
                for(int j :i){
                    System.out.printf ("%d\t",j );
                }
                System.out.println ( );
            }

        return xishu;
        }

    }



