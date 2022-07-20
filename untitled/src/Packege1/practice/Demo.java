package Packege1.practice;

public class Demo {
    public static void main(String[] args) {
        Fu f = new Zi();

        System.out.println(f.num);//这里定义的是父类，而成员变量没有多态，所以即使你new的子类，依然指向父类的成员变量。
        System.out.println(f.fun1());//不解释了，就是多态。
        f.show();
    }
}

class Fu {
    public String num = "父类成员变量";

    public void show() {
        System.out.println(this.num);//因为成员变量没有多态，所以this指向当前类对象的成员变量。
        System.out.println(this.fun1());//因为方法有多态，所以this指向new对象的方法。
    }

    public String fun1() {
        System.out.println(this.num);//因为成员变量没有多态，所以this指向当前类对象的成员变量。
        return "父类调用";
    }
}

class Zi extends Fu {
    public String num = "子类成员变量";

    @Override
    public String fun1() {
        System.out.println(this.num);//因为成员变量没有多态，所以this指向当前类对象的成员变量。
        return "子类调用";
    }
}