package Packege1.day01;
import java.util.*;
public class TreeSetPaixu {
    public static void main ( String[] args ) {
        Comparator<Student> cc = new Comparator<Student>( ) {
            @Override
            public int compare ( Student o1 , Student o2 ) {
                return o2.score+o1.score;
            }
        };
        TreeSet<Student> t1 = new TreeSet<> (cc);
        t1.add ( new Student (new StringBuffer ( "小白" ),98,5) );
        t1.add ( new Student (new StringBuffer ( "刘明" ),95,4) );
        t1.add ( new Student (new StringBuffer ( "董翘楚" ),10,3) );
        t1.add ( new Student (new StringBuffer ( "张三" ),45,9) );
        t1.add ( new Student (new StringBuffer ( "起飞" ),60,10) );
        Iterator ii = t1.iterator ();
//        int count=0;
        while (ii.hasNext ()){
            System.out.println (ii.next () );
//            count++;
//            if(count>=3)
//                return;
                }
    }
}



class Student{
    StringBuffer name;
    int score;
    int id;
    Student(){}

    public Student ( StringBuffer name , int score , int id ) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    @Override
    public String toString ( ) {
        return this.name+" "+this.score+" "+this.id;
    }
}
