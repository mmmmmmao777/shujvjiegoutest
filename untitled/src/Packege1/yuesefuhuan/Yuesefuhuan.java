package Packege1.yuesefuhuan;

import org.junit.Test;

public class Yuesefuhuan {
    Man temp;
    Man first;


    @Test
    public void Test ( ) {
        add(5);
//        show ();
        yuesefu(2,1);

    }

    public void add ( int i ) {
        if ( i == 0 ) {
            return;
        }
        for ( int t = 1 ; t <= i ; t++ ) {
            Man m = new Man ( t );

            if ( t == 1 ) {
                first = m;

            } else {
                temp.next = m;
                m.next = first;
            }
            temp = m;
        }

    }
public void yuesefu(int t ,int start){
    Man last=temp;
        int n = t;
        for(int i=0; i <start-1;i++){
           last=last.next;
        }
        first=last.next;

        while(last!=first){
            for(int a=0;a<t-1;a++){
                last=last.next;
            }
            //把first所在位置的人删除
            first = last.next;
            System.out.println ("删除了"+first.no );
            last.next=first.next;
            first=last.next;
        }
    System.out.println ("最后剩下" +first.no);
}



//    public void show ( ) {
//        Man temp1 = first;
//        while ( true ) {
//            if ( temp1.next != first ) {
//                System.out.println ( temp1 );
//                temp1 = temp1.next;
//            } else {
//                System.out.println ( temp1 );
//                return;
//            }
//        }
//    }

//    public void yuesefu ( int i ) {
//        Man temp1 = first;
//        if(temp1==null||i<1){
//            System.out.println ("参数错误" );
//            return;
//        }
//
//        while ( temp1.next != temp1 ) {
//            for ( int t = 1 ; t <= i - 1 ; t++ ) {
//                temp1 = temp1.next;
//            }
//            del ( temp1.no );
//            System.out.println ( "删除了" + temp1.no );
//            temp1 = temp1.next;
//        }
//
//        del ( temp1.no );
//        System.out.println ( "删除了" + temp1.no );
//
//    }



//    public void del( int i){
//        Man temp = first;
//
//        Man temp1=first;
//
//        while(temp1.next.no!=i){
//            if(temp1.next==first){
//                System.out.println ("未找到该号码的人" );
//                return;}
//            temp1=temp1.next;
//
//        }
//        if(temp1.next.no==first.no){
//            first=temp1.next.next;
//        }
//        temp1.next=temp1.next.next;
//
//    }

}

class Man {
    public Man ( int no ) {
        this.no = no;
    }

    int no;
    Man next;

    @Override
    public String toString ( ) {
        return no+" ";
    }
}