package Packege1.day01;


import org.junit.Test;

import java.io.*;

public class Shuchuqipan {
    @Test
    public void Test1()  {
        ObjectOutputStream o1 = null;
        FileOutputStream f1=null;
        try {
            Wuziqi w1 = new Wuziqi ();
            w1.qipan();
            File f2 =new File ("C:\\Users\\LEGION\\Desktop\\wuziqi.txt"  ) ;
             f1 = new FileOutputStream ( f2 );
             o1 = new ObjectOutputStream ( f1 );
            o1.writeObject ( w1 );

        } catch ( Exception e ) {
            e.printStackTrace ( );
        }finally {
            if(o1!=null){
                try {
                    o1.close ();
                } catch ( IOException e ) {
                    e.printStackTrace ( );
                }
            }
            if(f1!=null){
                try {
                    f1.close ();
                } catch ( IOException e ) {
                    e.printStackTrace ( );
                }
            }
        }

    }
    @Test
    public void Daoru(){
        FileInputStream i1=null;
        ObjectInputStream o1 =null;
        Wuziqi w1;
        try {
            i1 = new FileInputStream ( "C:\\Users\\LEGION\\Desktop\\wuziqi.txt") ;
            o1=new ObjectInputStream ( i1 );
            Object oo=o1.readObject ();
            if(oo instanceof Wuziqi){
               w1 =(Wuziqi)oo;

            }else{ return;}
            for(int[] i :w1.xishu){
                for(int j :i){
                    System.out.printf ("%d\t",j );
                }
                System.out.println ( );
            }

        } catch ( Exception e ) {
            e.printStackTrace ( );
        }


    }


}
