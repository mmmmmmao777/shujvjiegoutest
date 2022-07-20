package Packege1.Shujvjiegou;

import org.junit.Test;

public class Singlinked {
    Xiyou temp=null;
    Xiyou x0 =new Xiyou ( "","",0 );
    Xiyou x1 = new Xiyou ( "齐天大圣","孙悟空",1 );
    Xiyou x2 = new Xiyou ( "天蓬元帅","猪八戒",2 );
    Xiyou x3 = new Xiyou ( "卷帘大将","沙悟净",3 );
    Xiyou x4 = new Xiyou ( "玉帝小哥","唐玄奘",4 );

    @Test
    public void Testlinked(){
        add(x1);
        add(x3);
        add(x2);
        add(x4);
        show ();
    }
    public void add(Xiyou xx){
        if(x0.next==null){
            x0.next=xx;
        }else{
            temp=x0.next;
            while(true){
                if(temp.next==null){
                    temp.next=xx;break;
                } else{
                    temp=temp.next;
                }
            }
        }
    }

    public void show(){
        if(x0.next==null){
            System.out.println ("无人物" );
        }else{
            temp=x0.next;
            while(true){
                System.out.println (temp );
                if(temp.next==null){break;}
                temp=temp.next;
            }
        }

    }

}





class Xiyou{

    public Xiyou ( String name , String waihao , int no ) {
        this.name = name;
        this.waihao = waihao;
        this.no = no;
    }
    Xiyou next=null;
    String name;
    String waihao;
    int no;
    @Override
    public String toString(){
        return (no+" "+waihao+" "+name) ;
    }
}
