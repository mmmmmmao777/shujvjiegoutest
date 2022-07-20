package Packege1.Shujvjiegou.Hash;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.Scanner;

public class Hashlinked {
    int size;
    LinkedEmploy[] hash;
//输入size
    public void construct(int i){
        hash= new LinkedEmploy[i];
        size=i;
        for(int t=0; t<i ;t++){
            hash[t]=new LinkedEmploy ();
        }
    }

   //把id输入 变为 链表  号
    public int getcode(int i){
        int count=i%size;
        return count;
    }

    public void add(int id,String name){
       int index= getcode ( id );
       hash[index].add ( id,name );
        System.out.println ("添加完毕" );
    }

    public void listall(){
        for(int t=0;t<size;t++){
            hash[t].list (t);
        }
    }

    public void search(int id){
        int index = getcode(id);
        int temp=hash[index].search ( id );
        if(temp==-1){
            System.out.println ("没找到" );
        }else{
            System.out.println ("在第 "+index+" 链表找到了，位于第"+temp+"位" );
        }

    }
    public void delete(int id){
        int index = getcode(id);
        int count=hash[index].del ( id );
        if(count==-1){
            System.out.println ("未找到该id的员工，删除失败" );
        }else{
            System.out.println ("删除成功" );
        }
    }

    public static void main ( String[] args ) {
        Hashlinked h1 = new Hashlinked ();
        Scanner s1 = new Scanner ( System.in );
        h1.construct(7);
        while(true){
            System.out.println ("输入a添加" );
            System.out.println ("输入d删除" );
            System.out.println ("输入s查找" );
            System.out.println ("输入l展示" );
            System.out.println ("输入e退出" );

                   char k =s1.next ().charAt ( 0 );
               switch ( k ){
                   case'a':
                      //添加
                       System.out.println ("请输入员工id" );
                      int idd= s1.nextInt ();
                       System.out.println ("请输入员工姓名" );
                       String namee = s1.next ();
                       h1.add ( idd,namee );

                       break ;

                   case'd':
                       //删除
                       System.out.println ("请输入待删除员工id" );
                       int no= s1.nextInt ();
                       h1.delete ( no );
                       break;
                   case's':
                       //查找
                       System.out.println ("请输入待查找员工id" );
                       int num= s1.nextInt ();
                       h1.search (num );
                       break;
                   case'l':
                       //展示
                       h1.listall ();
                       break;
                   case'e':
                       s1.close ();
                       System.exit ( 0 );
               }
            }



//        h1.construct ( 7 );
//        h1.add ( 7,"tom" );
//        h1.add(9,"jack");
//        h1.listall ();
////        h1.search ( 15 );
//        h1.delete ( 7 );
//
    }
}
