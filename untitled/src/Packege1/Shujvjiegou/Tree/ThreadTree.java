package Packege1.Shujvjiegou.Tree;

import java.util.Arrays;

public class ThreadTree {
    ManNod pre;
    public static void main ( String[] args ) {
        ManNod root = new ManNod ( "唐僧",1 );
        ManNod m2 = new ManNod ( "孙悟空", 2 );
        ManNod m3 = new ManNod ( "猪八戒", 3 );
        ManNod m4 = new ManNod ( "沙悟净", 4 );
        ManNod m5 = new ManNod ( "小龙", 5 );
        ManNod m6 = new ManNod ( "xiaobai",6 );
        root.left=m2;
        m2.left=m5;
        root.right=m3;
        m3.right=m4;
        m2.right=m6;
        ThreadTree t1 = new ThreadTree ();
//        t1.backshoww (root);
          t1.cengout ( root );
//        t1. threadpre ( root);
//
//        t1.Threadpreout (root);
    }

    public void midshoww(ManNod root){
        root.midshow ();
    }
    public void backshoww(ManNod root){
        root.backshow ();
    }

//按照层输出？
    public void cengout(ManNod node){
        if(node==null){
            System.out.println ("空" );
            return;
        }
        ManNod[] arr = new ManNod[10];
        int temp=0;
        int tt=1;
        arr[0]=node;
        while(true){
            if(arr[temp]==null){
                break;
            }
           if(arr[temp].left!=null){
               arr[tt]=arr[temp].left;
              tt++;
           }
           if(arr[temp].right!=null){
               arr[tt]=arr[temp].right;
               tt++;
           }
           //结束
           temp++;
        }
        System.out.println ( Arrays.toString ( arr ) );
    }




    //按照中序线索化
    public void threadMid(ManNod root){
        if(root==null){
            System.out.println ( "树为空，错误");
            return;
        }
        //左边
        if(root.left!=null){
            threadMid (root.left);
        }
        //中间
        if(root.left==null){
            root.left=pre;
            root.lefttype=1;
        }
        if(pre!=null && pre.right==null){
            pre.right=root;
            pre.righttype=1;
        }
        pre=root;
        //右边
        if(root.right!=null){
            threadMid (root.right);
        }

    }


    //按照前序线索化
    public void threadpre(ManNod root){
        if(root==null){
            System.out.println ( "树为空，错误");
            return;
        }
        //中间
        if(root.left==null){
            root.left=pre;
            root.lefttype=1;
        }
        if(pre!=null && pre.right==null){
            pre.right=root;
            pre.righttype=1;
        }
        pre=root;
        //左边
        if(root.left!=null && root.lefttype==0){
            threadpre (root.left);
        }
        //右边
        if(root.right!=null&&root.righttype==0 ){
            threadpre (root.right);
        }

    }

    //按照后序线索化
    public void threadback(ManNod root){
        if(root==null){
            System.out.println ( "树为空，错误");
            return;
        }
        //左边
        if(root.left!=null ){
            threadpre (root.left);
        }
        //右边
        if(root.right!=null ){
            threadpre (root.right);
        }
        //中间
        if(root.left==null){
            root.left=pre;
            root.lefttype=1;
        }
        if(pre!=null && pre.right==null){
            pre.right=root;
            pre.righttype=1;
        }
        pre=root;
    }

    //qian序线索化后de遍历输出练习
//    public void Threadpreout(ManNod node){
//        if(node==null){
//            System.out.println ("空" );
//        }
//        while(node!=null){
//        System.out.println (node );
//        while(node.righttype==1){
//            node=node.right;
//            System.out.println (node );
//        }
//        if(node.lefttype!=1 && node.left!=null){
//            node=node.left;
//        }else {
//            node = node.right;
//        }
//        }
//        }










    //中序线索化后de遍历输出？   已经不能使用原来的方法了。
    public void threadmidshow(ManNod root){
        if(root==null){
            System.out.println ( "树为空，错误");
            return;
        }
        while(root!=null){
            while(root.lefttype==0){
                root=root.left;
            }
            System.out.println (root );
            while(root.righttype==1){
                root=root.right;
                System.out.println (root );
            }
            root=root.right;
        }

    }

    //前序线索化的遍历输出？   已经不能使用原来的方法了。
    public void threadpreshow(ManNod root){
        if(root==null){
            System.out.println ( "树为空，错误");
            return;
        }
       while(root!=null){
           System.out.println (root );
           while(root.righttype==1){
               root=root.right;
               System.out.println (root );
           }
         if(root.lefttype==0){root=root.left;}
           else{ root=root.right;}
       }

    }

    //后序线索化的遍历输出？   已经不能使用原来的方法了。tainan
    public void threadlastshow(ManNod root){
        if(root==null){
            System.out.println ( "树为空，错误");
            return;
        }
        while(root!=null){
        while(root.lefttype==0){
            root=root.left;
        }
            System.out.println (root );
        while(root.righttype==1){
            root=root.right;
            System.out.println (root );
        }

        }

    }
}

class ManNod {
    public ManNod ( String name , int id ) {
        this.name = name;
        this.id = id;
    }


    @Override
    public String toString ( ) {
        return id + "  " + name;
    }

    String name;
    int id;
    ManNod left;
    ManNod right;
    //类型=0，指向子树，类型=1指向前驱/后继节点
    int lefttype;
    int righttype;
    ManNod pre=null;
    public void preshow ( ) {
        System.out.println ( this );
        if ( this.left != null ) {
            this.left.preshow ( );
        }
        if ( this.right != null ) {
            this.right.preshow ( );
        }
    }
    public void midshow ( ) {
        if ( this.left != null ) {
            this.left.midshow ( );
        }
        System.out.println ( this );
        if ( this.right != null ) {
            this.right.midshow ( );
        }
    }
    public void backshow ( ) {
        if ( this.left != null ) {
            this.left.backshow ( );
        }
        if ( this.right != null ) {
            this.right.backshow ( );
        }
        System.out.println ( this );
    }




//
//    public ManNode midSearch ( int no ) {
//        ManNode mm = null;
//        if ( this.left != null ) {
//            mm = this.left.midSearch ( no );
//        }
//        if ( mm != null ) {
//            return mm;
//        }
//        if ( this.id == no ) {
//            return this;
//        }
//        if ( this.right != null ) {
//            mm = this.right.midSearch ( no );
//        }
//        return mm;
//    }
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