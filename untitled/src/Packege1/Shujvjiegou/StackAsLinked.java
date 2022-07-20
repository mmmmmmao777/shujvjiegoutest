package Packege1.Shujvjiegou;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.junit.Test;

import java.util.Scanner;

public class StackAsLinked<TT> {
    int size=10;
    Node1 back;
    Node1 fanhui;
    Node1 n0=new Node1 ( null );
    int count=0;


    public static void main ( String[] args ) {
        StackAsLinked s2 = new StackAsLinked ();
        Scanner s1 = new Scanner ( System.in );
        while ( true ) {
            System.out.println ( "push" );
            System.out.println ( "pop" );
            System.out.println ( "show" );
            System.out.println ( "exit" );
            String str = s1.next ( );
            switch ( str ) {
                case "p":
                    System.out.println ( "请输入要存的数" );
                    s2.push ( s1.nextInt ( ) );
                    break;
                case "po":
                    s2.pop ( );
                    System.out.println ("删除成功" );
                    break;
                case "s":
                    s2.show ( );
                    break;
                case "e":
                    s1.close ();
                    System.out.println ("退出成功" );
                    System.exit ( 0 );
            }

        }
    }




    public void push(TT i){
        if(isfull ()){
            System.out.println ("满了" );
            return;
        }else {
            Node1 nn = new Node1 ( i );
            nn.next=n0.next;
            n0.next = nn;
            count++;
            back=nn;
        }
    }

    public TT pop(){
        if(isEmpty ()){
            System.out.println ("空了" );
           return null;
        }else{
            fanhui=n0.next;
            back= n0.next;
            n0.next=n0.next.next;
            count--;
            return fanhui.no;
        }

    }
    public void show(){
        Node1 temp=n0.next;
        if(isEmpty ()){
            System.out.println ("空了" );
            return;
        }else{
            while ( true ) {
                System.out.println (" "+temp.no );
                temp =temp.next;
                if(temp==null)
                    break;
            }
        }
    }

    public boolean isEmpty ( ) {
        return n0.next==null;
    }

    public boolean isfull ( ) {
        if ( count == size  ) {
            return true;
        }
        return false;
    }

    class Node1{
        Node1 next=null;
        TT no;

        public Node1 ( TT no ) {
            this.no = no;
        }
    }


}

