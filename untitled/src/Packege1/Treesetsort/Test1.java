package Packege1.Treesetsort;

import java.util.*;
public class Test1 {
    public static void main ( String[] args ) {


//        Comparator com = new Comparator<Employee> ( ) {
//            @Override
//            public int compare ( Employee o1 , Employee o2 ) {
//                return  o1.getBirthday ().toString ().compareTo (  o2.getBirthday ().toString () );
//            }
//
//        };
StringBuffer str = new StringBuffer("cabg,");
String str1 = "cabg,";
String str2 = str1.replaceAll ( ",","c" );
        System.out.println (str2 );

        Employee e1 = new Employee ("ti气层",18);
        Mydate m1 = new Mydate ( 1999,5,12 );
        e1.setBirthday(m1);

        Employee e2 = new Employee ("liu小白",22);
        Mydate m2 = new Mydate ( 1997,4,22 );
        e2.setBirthday(m2);

        Employee e3 = new Employee ("qong演出",17);
        Mydate m3 = new Mydate ( 2000,9,50 );
        e3.setBirthday(m3);

        Comparator<Employee> e4 = new Comparator<Employee> (  ){

            @Override
            public int compare ( Employee o1 , Employee o2 ) {
                return o1.getAge ()-o2.getAge () ;

            }
        };

        TreeSet<Employee> c1 = new TreeSet<> (e4);
        c1.add(e1);
        c1.add(e2);
        c1.add(e3);


     Iterator i1 =  c1.iterator ();
     while(i1.hasNext ()){
         System.out.println (i1.next () );
     }

     };


    }

