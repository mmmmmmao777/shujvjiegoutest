package Packege1;


import java.util.*;

public class Test1 {
    public static void main ( String[] args ) {
        Person p1 = new Person ( "xiaoming",18 );
        Person p2 =new Person ( "mao",22 );
        Person p3 =new Person ( "xiaomao",30 );
        Person[] pp =new Person[]{p1,p2,p3};
        Arrays.sort ( pp,new Paixu () );
       for( Person p : pp){
           System.out.println ( p.name+"  "+p.age);
       }
}}
class Paixu implements Comparator <Personfather> {


    @Override
    public int compare ( Personfather o1 , Personfather o2 ) {
        if (o1.age>o2.age){
            return 1;
        }
        else if (o1.age<o2.age){
            return 0;
        }else
            return -1;
    }
    }

class Person extends Personfather {

  Person( String name,int age){
     super(name,age);
}}

class Personfather{
    String name;
    int age;
    Personfather(){}
    Personfather( String name,int age){
        this.name=name;
        this.age=age;
    }
}