package Packege1.Shujvjiegou;

import org.junit.Test;
//按照序号插入时排好序

public class SinglelinkedPaixu {
    Xiyou1 temp = null;
    Xiyou1 x0 = new Xiyou1 ( "" , "" , 0 );
    Xiyou1 x1 = new Xiyou1 ( "齐天大圣" , "孙悟空" , 1 );
    Xiyou1 x2 = new Xiyou1 ( "天蓬元帅" , "猪八戒" , 2 );
    Xiyou1 x3 = new Xiyou1 ( "卷帘大将" , "沙悟净" , 3 );
    Xiyou1 x4 = new Xiyou1 ( "玉帝小哥" , "唐玄奘" , 4 );

    @Test
    public void Testlinked ( ) {
        add ( x1 );
        add ( x3 );
        add ( x4 );
        add ( x4 );
        add ( x2 );
        set ( 4 , "大唐高僧" );

        show ( );
        reverseoutt (x0.next);
//        reverseOut();
    }

    public void add ( Xiyou1 xx ) {
        temp = x0;
        while ( true ) {
            if ( temp.next == null ) {
                temp.next = xx;
                break;
            }
            if ( temp.next.no == xx.no ) {
                System.out.println ( "已经存在，无法添加" );
                break;
            }
            if ( temp.next.no > xx.no ) {
                xx.next = temp.next;
                temp.next = xx;
                break;
            } else {
                temp = temp.next;

            }
        }
    }


    public void show ( ) {
        if ( x0.next == null ) {
            System.out.println ( "无人物" );
        } else {
            temp = x0.next;
            while ( true ) {
                System.out.println ( temp );
                if ( temp.next == null ) {
                    break;
                }
                temp = temp.next;
            }
        }

    }

    //指定no 修改他的信息 set（）  输入no和要改成的名字
    public void set ( int no , String name ) {
        Xiyou1 temp1 = x0;
        for ( ; ; ) {
            if ( temp1.next == null ) {
                System.out.println ( "没找到" );
                break;
            }

            if ( temp1.next.no == no ) {
                temp1.next.name = name;
                break;
            } else {
                temp1 = temp1.next;
            }

        }
    }

    //按序号删除
    public void del ( int i ) {
        Xiyou1 temp2 = x0;
        while ( true ) {
            if ( temp2.next == null ) {
                System.out.println ( "未找到" );
                break;
            }
            if ( temp2.next.no == i ) {
                temp2.next = temp2.next.next;
                break;
            } else {
                temp2 = temp2.next;
            }


        }
    }
    //翻转数列
    public void reverse(){
       Xiyou1 tempdd=x0.next;
        Xiyou1 zhen=x0.next;
    if(tempdd==null){
        System.out.println ("链表无内容" );return;}
    while(true){

        if(tempdd.next.next==null){
            zhen=tempdd.next;
            tempdd.next=null;
            zhen.next=x0.next;
            x0.next=zhen;
            break;
        } else if(tempdd.next.next!=null){
        zhen=tempdd.next;
      tempdd.next=tempdd.next.next;
      zhen.next=x0.next;
      x0.next=zhen;

        }
        }
    }


    public void reverseOut(){
        Xiyou1 temp=x0;
        Xiyou1 temp1=x0;
        int count=0;
        while(temp.next!=null){
            temp=temp.next;
            count++;
        }if(count==0||count==1){return;}

        Xiyou1[] xxx = new Xiyou1[count];
        for(int t1 =count-1;t1>=0 ;t1--){
            xxx[t1]=temp1.next;
            temp1=temp1.next;
        }
        for( int t2 = 0;t2<count;t2++){
            System.out.println (xxx[t2] );
        }


    }
    public void reverseoutt(Xiyou1 x){

        if(x.next==null){
        }else {
            reverseoutt ( x.next  );
        }
        System.out.println (x );


    }


    }


    class Xiyou1 {

        public Xiyou1 ( String name , String waihao , int no ) {
            this.name = name;
            this.waihao = waihao;
            this.no = no;
        }

        Xiyou1 next = null;
        String name;
        String waihao;
        int no;

        @Override
        public String toString ( ) {
            return ( no + " " + waihao + " " + name );
        }
    }

