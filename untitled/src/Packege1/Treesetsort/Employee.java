package Packege1.Treesetsort;

public class Employee implements Comparable<Employee>{
//    1. 定义一个 Employee 类。
//    该类包含：private 成员变量 name,age,birthday，其中 birthday 为
//    MyDate 类的对象；
//    并为每一个属性定义 getter, setter 方法；
//    并重写 toString 方法输出 name, age, birthday
//    MyDate 类包含:
//    private 成员变量 year,month,day；并为每一个属性定义 getter, setter
//    方法；
//    创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
//    TreeSet 需使用泛型来定义）
//    分别按以下两种方式对集合中的元素进行排序，并遍历输出：
//            1). 使 Employee 实现 Comparable 接口，并按 name 排序
//2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
@Override
public String toString(){
    return (name+"   "+age+"  "+ birthday);
}

    public Employee ( String name , int age ) {
        this.name = name;
        this.age = age;
    }
    public Employee (  ) {

    }
    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getAge ( ) {
        return age;
    }

    public void setAge ( int age ) {
        this.age = age;
    }

    public Mydate getBirthday ( ) {
        return birthday;
    }

    public void setBirthday ( Mydate birthday ) {
        this.birthday = birthday;
    }

    private String name ;
    private int age;
    private Mydate birthday;

    @Override
    public int compareTo ( Employee o ) {
        return this.name.compareTo ( o.name );

    }
}
class Mydate{
    public Mydate ( int year , int month , int day ) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear ( ) {
        return year;
    }

    public void setYear ( int year ) {
        this.year = year;
    }

    public int getMonth ( ) {
        return month;
    }

    public void setMonth ( int month ) {
        this.month = month;
    }

    public int getDay ( ) {
        return day;
    }

    public void setDay ( int day ) {
        this.day = day;
    }

    private int year;
    private int month;
    private int day;
@Override
    public String toString(){
    return String.valueOf (year)  + month +day ;
}
}
