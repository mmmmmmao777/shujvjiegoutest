package Packege1.Shujvjiegou;

import com.sun.xml.internal.bind.util.Which;
import org.junit.Test;

import java.util.Scanner;

public class Duilie {
    int front=0;
    int rear=0;
    int[] i = new int[4];
    int size = 4;


    public void main(){
        Scanner s1 = new Scanner ( System.in );
        while(true){
            System.out.println ("输入a添加" );
            System.out.println ("输入g获取第一个并删除" );
            System.out.println ("输入s展示" );
            System.out.println ("输入f获取第一个" );
            System.out.println ("e 退出" );
            char c1 = s1.next ().charAt ( 0 );
          switch ( c1 ) {
              case 'a':
                  if(isFull ()){
                      System.out.println ("数组满了" );
                  break;}
                  else{
                  System.out.println ("输入要添加的数" );
                  int t1 = Integer.parseInt ( s1.next () );
                  add(t1);
                      System.out.println ("添加成功" );
                      break;
                  }

              case 'g':
                  if(isEmpty ()){
                      System.out.println ("数组为空" );
                      break;}
                  else{
                  getdelete();}
                  break;
              case 's':
                  show ();
                  break;
              case 'f':
                  if(isEmpty ()){
                      System.out.println ("kong" );
                      break;
                  }
                  System.out.println ( showfront());
                  break;
              case'e':
                  s1.close ();
                  System.exit ( 0 );

          }


        }

    }
    public void add(int t){
        i[rear]=t;
       rear= (rear+1)%size;
    }
    public void getdelete(){
        System.out.println (i[front] );
        front= (front+1)%size;
    }

    public void show(){
        if(isEmpty ()){
            throw new RuntimeException ( "数组为空" );
        }else{
            for(int j=front;j<front+(rear+size-front)%size;j++){
                System.out.printf ("i[%d]=%d\n",(j%size),(i[j%size]) );
            }
        }

    }
    public int showfront(){

        return i[front];
    }
    public boolean isEmpty(){
        if(front==rear)
            return true;
        else{return false;}
    }
    public boolean isFull(){
        if((rear+1)%size==front)
            return true;
        else{return false;}
    }


    public static void main ( String[] args ) {
       Duilie d1 = new Duilie ();
        d1.main (  );
    }
}
