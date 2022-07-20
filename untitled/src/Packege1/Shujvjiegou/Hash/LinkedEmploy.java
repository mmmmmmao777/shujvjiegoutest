package Packege1.Shujvjiegou.Hash;

public class LinkedEmploy {
    Employ head = null;
    /**
    * 输入id和name，添加到该链表末尾。
    * @Param: [i, nam]
    * @return: void
    * @Author: mao
    * @Date: 2021/10/4
    */
    public void add(int i ,String nam){
        Employ e = new Employ ( i,nam );
        if(head == null){
            head = e;
        }else{
            Employ temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=e;
        }
    }
    /**
    * 遍历这个链表
    * @Param: []
    * @return: void
    * @Author: mao
    * @Date: 2021/10/4
    */
    public void list(int t){
        if(head==null){
            System.out.println (t+"链表为空" );
        }else{
            System.out.print (t+"链表：" );
            Employ temp=head;
            while(temp!=null){
                System.out.print ("--->"+"  员工的id为"+temp.id+",员工的名字为"+temp.name );
                        temp=temp.next;
            }
            System.out.println ( );
        }
    }
    /**
    * 输入一个id，找此链表中是否有，有的话返回位于链表第几个，没有的话-1
    * @Param: [i]
    * @return: int
    * @Author: mao
    * @Date: 2021/10/4
    */
public int search(int i){
    if(head==null) {
       return -1;
    }else{
        Employ temp=head;
        int count=1;
        while(temp!=null){
           if(temp.id==i){
               return count;
           }
            temp=temp.next;
           count++;
    }
}
    return -1;
    }

public int del(int i){
    if(head==null) {
        return -1;
    } else {
        if ( head.id == i ) {
            head = head.next;
            return 1;
        } else {
            Employ temp = head;
            while ( temp.next != null ) {
                if ( temp.next.id == i ) {
                    temp.next = temp.next.next;
                    return 1;
                }
                temp = temp.next;
            }
        }
    }
    return -1;
}



    public static void main ( String[] args ) {


    }

}
