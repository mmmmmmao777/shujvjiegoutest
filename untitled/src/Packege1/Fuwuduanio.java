package Packege1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Fuwuduanio {
        @Test
        public void fuwu() throws Exception {
               ServerSocket s1= new ServerSocket(8899);
               Socket s2 = s1.accept ();
               InputStream i1 = s2.getInputStream ();
                ByteArrayOutputStream i2=new ByteArrayOutputStream();
               byte[] bb = new byte[10];
               int i=0;
               while(( i=i1.read ( bb ))!=-1){
                        i2.write ( bb,0,i );
                }
                System.out.println ( i2.toString ());
                i2.close ();
               i1.close ();
               s2.close ();
               s1.close ();
        }

        @Test
        public void kehu() throws Exception {
                InetAddress i1 = InetAddress.getLocalHost ();
                Socket s1 = new Socket (i1,8899 );
                OutputStream o1 = s1.getOutputStream ();
                o1.write ( "你好，我是大宝".getBytes () );
                o1.close ();
                s1.close ();
                }
        }


