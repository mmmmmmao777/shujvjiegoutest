package Packege1.Shujvjiegou.Caculator;

import java.awt.*;
import java.util.*;

public class Conversion {
    //将中缀表达式转为后缀表达式 1+((2+3)*4)-5
    public static void main ( String[] args ) {
    Conversion c1 =new Conversion ();
        System.out.println ( c1.Conversion1 ( "1+((2+3)*4)-56" )) ;
    }

    public String Conversion1 ( String str) {
        String sss="";
        Stack<String> s1 = new Stack<> ( );
        Stack<String> s2 = new Stack<> ( );
        //导入到c【】char数组中
        char[] c=str.toCharArray ();
        for(char char1 : c){
          String str1= String.valueOf ( char1 );
          //如果是数字，直接加入s2栈中
          if(str1.matches ( "\\d+" )){
             sss+=str1;

          }else{
              if(!sss.equals ( "" )){
              s2.push ( sss );
              sss="";}
              //不是数字的情况：
              //左括号直接加入s1，右括号将s1中弹出，直到遇见左括号。将该左括号弹出
                if(str1.equals ( "(" )){
                    s1.push ( str1 );
                }else if(str1.equals ( ")" )){
                    while(!s1.peek () .equals ( "(" )){
                        s2.push ( s1.pop () );
                    }
                    s1.pop ();
                }

            //如果不是数字，是符号，就开始判断
              //1.s1中没有符号，或者第栈顶符号是左括号（，直接加入s1
              //2.新符号的优先级大于栈顶元素，直接加入。
              //3.优先级不大于栈顶元素，将s1中栈顶元素弹出加入s2中。再将新加入符号与s1栈顶判断。
                else {
                    while ( true ) {
                        if ( s1.empty ( ) || s1.peek ( ).equals ( "(" ) ) {
                            s1.push ( str1 );
                            break;
                        } else if ( priority ( str1 ) > priority ( s1.peek ( ) ) ) {
                            s1.push ( str1 );
                            break;
                        } else if ( priority ( str1 ) <= priority ( s1.peek ( ) ) ) {
                            s2.push ( s1.pop ( ) );
                        }

                    }
                }
          }

        }
        if(!sss.equals ( "" )){
            s2.push ( sss );
            sss="";}

        //把s2中元素转入s1中，依次弹出
        while(!s2.empty ()){
            s1.push ( s2.pop () );
        }
        StringBuffer ss1 =new StringBuffer (  );
        while ( !s1.empty () ){
            ss1.append ( s1.pop ()+" " );
        }
        return String.valueOf ( ss1 );

    }

    public int priority(String str){
        String str2 = str;
        if(str2.equals ( "+" )||str2.equals ( "-" )){
            return 1;
        }else if(str2.equals ( "*" )||str2.equals ( "/" )){
            return 2;
        }
        throw new RuntimeException ( "输入符号出错啦" );
    }


}
