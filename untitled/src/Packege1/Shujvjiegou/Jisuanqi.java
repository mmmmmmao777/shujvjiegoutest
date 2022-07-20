package Packege1.Shujvjiegou;

import com.sun.xml.internal.ws.wsdl.writer.document.Fault;

public class Jisuanqi {
    String str="1+2*3*3+4";
    StackAsLinked<Integer> numStack = new StackAsLinked<> ();
    StackAsLinked<Character> proStack = new StackAsLinked<> ();
    public static void main ( String[] args ) {
        Jisuanqi j1 = new Jisuanqi ();
        j1.run ();
        }

  public boolean ispro(char c1){
      if(c1=='+'||c1=='-'||c1=='*'||c1=='/'){
          return true;
      }
      return false;
  }


    public int order ( char c1 ) {
        if ( c1 == '+' || c1 == '-' ) {
            return 1;
        } else if ( c1 == '*' || c1 == '/' ) {
            return 2;
        }
        return -1;
  }

  public void run() {
      //定义一个下标来取字符
      int index = 0;
      char pro;
      int num1;
      int num2;
      int sum = 0;
      int x=0;
      boolean bb=false;
      char c1;
      while ( true ) {
          //如果index位于最后一个了，就直接跳出循环了,遍历完成.
          if ( index == str.length ( ) ) {
              System.out.println ( "遍历完成" );
              break;
          }
          c1 = str.charAt ( index++ );
          //取出字符为空，继续取下一个
          if ( c1 == ' ' )
              continue;
          //如果字符为符号，准备存入符号栈中
          if ( ispro ( c1 ) ) {

              if(bb){
                  numStack.push (x);
                  bb=false;
              }
              //存入前判断符号栈是不是空的,是空的直接添加，不是空的就继续判断
              if ( proStack.count == 0 ) {
                  proStack.push ( c1 );
                  continue;
              }

              while(order ( c1 ) < order ( proStack.back.no )){
                  num1 = numStack.pop ( );
                  num2 = numStack.pop ( );
                  pro = proStack.pop ( );
                  switch ( pro ) {
                      case '+':
                          sum = num1 + num2;
                          break;
                      case '-':
                          sum = num2 - num1;
                          break;
                      case '*':
                          sum = num2 * num1;
                          break;
                      case '/':
                          if ( num1 == 0 ) {
                              System.out.println ( "错误，除数不能为0" );
                              return;
                          }
                          sum = num2 / num1;
                          break;
                  }
                  numStack.push ( sum );
              }
              proStack.push ( c1 );

          }
          //如果字符不是符号，存入数字栈中
          else {
                //将数据暂存
              if ( ! bb ) {
                  x = Integer.valueOf ( c1 ) - 48;
                  bb = true;
              } else {
                  x = x * 10 + ( Integer.valueOf ( c1 ) - 48 );
              }

          }
      }
      if(bb){
          numStack.push (x);
          bb=false;
      }
      //现在遍历完成，将现有栈中的数据计算出结果就行了
      while ( true ) {
          if ( proStack.count!=0) {
              num1 = numStack.pop ( );
              num2 = numStack.pop ( );
              pro = proStack.pop ( );
              sum = jisuan ( num1 , num2 , pro );

              numStack.push ( sum );
          }else{
              System.out.println ("计算结果"+numStack.pop () );
              break;
          }
      }
  }

public int jisuan(int num01,int num02,char pro1){
    char pro=pro1;
    int num1=num01;
    int num2=num02;
    int sum=0;

    switch ( pro ){
        case'+':
            sum=num1+num2;
            break;
        case'-':
            sum=num2-num1;
            break;
        case'*':
            sum=num2*num1;
            break;
        case'/':
            if(num1==0){
               throw new RuntimeException ( "错误，除数不能为0" );
            }
            sum=num2/num1;
            break;
    }
    //把计算结果输出
    return sum;
}

}
