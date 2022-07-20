package Packege1.Shujvjiegou.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class printTree {
    static int count=0;
    ManNode root;
    ManNode mm;
    public static void main ( String[] args ) {
        //先创建一个二叉树
        printTree p1 = new printTree ();
        ManNode root = new ManNode ( "唐僧",1 );
        ManNode m2 = new ManNode ( "孙悟空", 2 );
        ManNode m3 = new ManNode ( "猪八戒", 3 );
        ManNode m4 = new ManNode ( "沙悟净", 4 );
        ManNode m5 = new ManNode ( "小龙", 5 );
        root.left=m2;
        m2.left=m5;
        root.right=m3;
        m3.right=m4;
        p1.setroot ( root );
//        p1.preshow ();

      lastprint (root  );
//        p1.preshow ( );
//        System.out.println ( p1.midchazhao (4));
//        System.out.println (count );
//        p1.delete ( 5);
//        p1.preshow ( );
//        p1.delete ( 4 );
//        p1.preshow ( );
//        p1.preshow ( );
//        if(root==null){
//            System.out.println ("树为空，删除失败" );
//        }else if( root.id==5 ){
//            root=null;
//        }else{p1.dell(5,root); }
//        p1.preshow ( );
//        p1.dell ( 4,root );
//        p1.preshow ( );
    }

    public void preshow(){
        if(root==null){
            System.out.println ("空root" );
            return;
        }
        root.preshow (  );
    }

    //使用循环的方法 中序遍历
    public static void midprint(ManNode root){
      Stack<ManNode> stack = new Stack<> ();
      ManNode node = root;
      while(!stack.empty () || node!=null){
          if(node!=null){
              stack.push ( node );
              node=node.left;
          }else {
              node=stack.pop ();
              System.out.println (node.name+" -" );
              node=node.right;
          }
          }
      }


    //使用循环的方法 前序遍历
    public static void preprint(ManNode root){
        Stack<ManNode> stack = new Stack<> ();
        stack.push ( root );
        while ( !stack.empty ()  ){
           ManNode node =stack.pop ();
           if(node!=null){
               System.out.println (node.name+" -" );
           }
           if(node.right!=null){
               stack.push ( node.right );
           }
           if(node.left!=null){
               stack.push ( node.left );
           }
        }

    }


    //使用循环的方法 后序遍历
    public static void lastprint(ManNode root){
        Stack<ManNode> s1 = new Stack<> ();
        //储存用
        Stack<ManNode> s2 = new Stack<> ();

        s1.push ( root );
        while ( !s1.empty ()  ){
            ManNode node =s1.pop ();
           s2.push ( node );
           if(node.left!=null){
               s1.push ( node.left );
           }
           if(node.right!=null){
               s1.push(node.right);
           }
        }
        while(!s2.empty ()){
            System.out.println (s2.pop ()+"--" );
        }

    }


    public void setroot ( ManNode root ) {
        this.root = root;
    }

    public ManNode midchazhao ( int no ) {
        return root.midSearch ( no );
    }

//public void delete(int no){
//        if(root==null){
//            System.out.println ("树为空，删除失败" );
//        }else if( root.id==no ){
//            root=null;
//        }else{
//            root.del ( no );
//        }
//}
        boolean bb = false;
    public void  dell(int no,ManNode root){
        System.out.println ("正在节点"+root );
           if(root.left!=null && root.left.id==no){
               root.left=null;
               bb=true;
               return;
           }
        if(root.right!=null && root.right.id==no){
            root.right=null;
            bb=true;
            return;
        }
        if(root.left!=null){
            dell ( no,root.left );
        }
        if(bb==true){
        bb=false;
            return;
        }
            if(root.right!=null){
                dell(no,root.right);
            }
        }
    }


    //找到了返回这个对象，找不到返回空

//    public ManNode preSearch(int no,ManNode root){
//        count++;
//        if(root==null){
//            System.out.println ("空root 无法查找" );
//            return null;
//        }
//        if(root.id==no){
//            System.out.println ("找到了" );
//            return root;
//        }
//
//        if(root.left!=null){
//         if( (mm=preSearch ( no,root.left ))!=null){
//             return  mm;
//         }
//        }
//        if(root.right!=null){
//            if( (mm=preSearch ( no,root.right ))!=null){
//          return mm;
//        }
//        }
//        return null;
//    }








class ManNode{
    public ManNode ( String name , int id ) {
        this.name = name;
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public int getId ( ) {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public ManNode getLeft ( ) {
        return left;
    }

    public void setLeft ( ManNode left ) {
        this.left = left;
    }

    public ManNode getRight ( ) {
        return right;
    }

    public void setRight ( ManNode right ) {
        this.right = right;
    }

    @Override
    public String toString ( ) {
        return id+"  "+name;
    }

    String name;
    int id;
    ManNode left;
    ManNode right;

    public void preshow(){
        System.out.println (this );
        if(this.left!=null){
            this.left.preshow ();
        }
        if(this.right!=null){
            this.right.preshow (  );
        }
    }
    public ManNode midSearch(int no){
        ManNode mm=null;
        if(this.left!=null){
            mm=this.left.midSearch ( no );
        }
        if(mm!=null){
            return mm;
        }
        if(this.id==no){
            return this;
        }
        if(this.right!=null){
            mm=this.right.midSearch ( no );
        }
        return mm;
    }
//必须遍历完，即使左边找到了，删除了，停不下来。也要继续遍历右边
   // this 的对象不一样，那么变量就默认值了。也不能带出内层。
    //可以使用一个static类型的变量来检测左边是不是找到了，true 找到了 在右边执行前进行判断跳出，
    // 记得在if判断return前把该变量改为false，以便下次使用。
    //或者设定一个返回值 和本页的遍历类似，找到了返回一个对象，找不到返回null，那么就可以通过if来看左边找到没有了。
//    public void del(int no){
//        System.out.println ("正在节点"+this );
//
//        if(this.left!=null && this.left.id==no){
//            this.left =null;
//
//            return;
//        }
//        if(this.right!=null&& this.right.id==no){
//            this.right=null;
//
//            return;
//        }
//        if(this.left!=null){
//            this.left.del ( no );
//        }
//
//        if(this.right!=null){
//            this.right.del ( no );
//        }
//    }


}
