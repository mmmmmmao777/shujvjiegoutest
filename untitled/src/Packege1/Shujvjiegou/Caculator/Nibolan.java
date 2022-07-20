package Packege1.Shujvjiegou.Caculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Nibolan {
    //使用栈实现逆波兰计算器
    //传入后缀表达式 如（3+4）*5-6   传入 "3 4 + 5 * 6 -"

    public static void main ( String[] args ) {
        Nibolan n1 = new Nibolan ();
        System.out.println ( n1.Caculator ( "3 4 + 5 * 6 -" ));
        // 传入后缀表达式 如（3+4）*5/5   传入 "3 4 + 5 * 5 /"
        System.out.println ( n1.Caculator ( "3 4 + 5 * 5 /" ));
    }
    public int Caculator(String str){
        int a;
        int b;
        int sum = 0;
        Stack<String> stack = new Stack<String> ();
        //把表达式中的字符传入ArrayList中保存，方便取出
        ArrayList<String> list = new ArrayList<> (  );
        String[] strr=str.split ( " " );
        for(String s: strr){
            list.add(s);
        }
        Iterator ii = list.iterator ();
        while(ii.hasNext ()){
            System.out.print( ii.next ()+",");
        }

        //存完后 构建计算器 将数据传入stack中
        for(int i =0; i<list.size ();i++) {
            //如果是数据，直接存入
            if ( list.get ( i ).matches ( "\\d+" ) ){
                stack.push ( list.get ( i ) );
            }
            //如果是符号，弹出两个数据，计算后将结果存入栈中
            else {
                if(list.get ( i ).equals ( "+" )){
                    a=Integer.parseInt ( stack.pop () );
                    b=Integer.parseInt ( stack.pop () );
                    sum = a+b;
                    stack.push ( String.valueOf ( sum ) );
                }
                else if(list.get ( i ).equals ( "-" )){
                    a=Integer.parseInt ( stack.pop () );
                    b=Integer.parseInt ( stack.pop () );
                    sum = b-a;
                    stack.push ( String.valueOf ( sum ) );
                }
                else if (list.get ( i ).equals ( "*" )){
                    a=Integer.parseInt ( stack.pop () );
                    b=Integer.parseInt ( stack.pop () );
                    sum = b*a;
                    stack.push ( String.valueOf ( sum ) );
                }
                else if(list.get ( i ).equals ( "/" )){
                    a=Integer.parseInt ( stack.pop () );
                    b=Integer.parseInt ( stack.pop () );
                    sum = b/a;
                    stack.push ( String.valueOf ( sum ) );
                }
                else{
                    throw new RuntimeException ( "输入未知符号" );
                }
            }
        }
        
        
        return sum;
    }
}
