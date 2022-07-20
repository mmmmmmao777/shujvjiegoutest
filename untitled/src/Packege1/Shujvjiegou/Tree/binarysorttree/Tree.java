package Packege1.Shujvjiegou.Tree.binarysorttree;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.*;

public class Tree {
    public static void main ( String[] args ) {
        int[] arr=new int[]{7,3,10,12,5,1,9};

      BinaryTree b1 = new BinaryTree (  );
      for(int t:arr){
        b1.add(t);
    }



  b1.midprint (  );
//      b1.delete ( 20 );
////        b1.delete ( 1 );
////        b1.delete ( 9 );
//        System.out.println ( );
//      b1.midprint ();
//        b1.getTargetNode ( 2 );
        b1.delete ( 11 );
    }
}

 class BinaryTree{
    Node root;
//     public Node gettargetnode(int value){
//        return root.getTargetNode ( value );
//     }
     public void setroot(Node root){
         this.root=root;
     }
     public   void add(int value){
         if(root==null){
             root=new Node ( value );
             return;
         }
         root.add ( value );
     }

     //中序遍历
     public void midshow(){
         Stack<Node> s1 = new Stack<> ();
         Node node =root;
        while(!s1.empty ()||node!=null){
            if(node!=null){
                s1.push ( node );
                node=node.left;
            }else{
                node=s1.pop ();
                System.out.print (node.value+"--" );
                node=node.right;
            }
        }
     }

     public void midprint(){
         if(root==null){
             System.out.println ("二叉树为空" );
             return;
         }
         root.midshow ();
     }


     //拿到目标 node
     public Node getTargetNode(int value){
         if(root==null){
             System.out.println ("kong" );
         }

         if(root.getTargetNode ( value )==null){
             System.out.println ("meizhaodao" );
             return null;
         }else{
             return root.getTargetNode ( value );
         }
     }


     //拿到目标的父节点
     public Node getfather ( int value ) {
         if(root==null){
             System.out.println ("kong" );
         }
         return root.getFatherNode ( value );
     }


     //对树进行删除
     public void delete ( int value ) {
         if ( root == null ) {
             System.out.println ( "树为空" );
             return;
         }
         //只有一个树根，删除的正好是树根，就置空
         if ( value == root.value && ( root.left == null && root.right == null ) ) {
             root = null;
             return;
         }
         //1.目标为叶子结点


         Node target = getTargetNode ( value );
         Node father = getfather ( value );
         if ( target == null ) {
             System.out.println ( "未找到" );
             return;
         }
         if ( target.right == null && target.left == null ) {
             if ( father.left.value == value ) {
                 father.left = null;
             } else {
                 father.right = null;
             }
             return;
         }
         //3.目标为非叶子结点，两边都有子节点
         if ( target.left != null && target.right != null ) {
             int temp = swich ( target );
             target.value = temp;
             return;
         }
         //2.目标为非叶子结点 只有一边有子节点
         //还需要加一个 root连接一个节点（左或者右）的情况，
         if ( target.left != null ) {
             if ( father != null ) {
                 if ( father.left == target ) {
                     father.left = target.left;
                     return;
                 } else {
                     father.right = target.left;
                     return;
                 }
             } else {
                 root = target.left;
             }
         } else {
             if ( father != null ) {

                 if ( father.left == target ) {
                     father.left = target.right;
                 } else {
                     father.right = target.right;
                 }
             } else {
                    root=target.right;
             }
         }
     }
     //取右子树最左边的一个值返回，并删除之
     public int swich(Node root){
       Node  node=root.right;
         while(node.left!=null){
             node=node.left;
         }
//       Node father=  getfather ( node.value );
//         father.left=null;
         delete(node.value);
         return node.value;
     }

 }

class Node {
    public Node ( int value ) {
        this.value = value;
    }

    int value;
    Node left;
    Node right;

    public  void add( int value ){
       if(this.value>=value){
           if ( this.left == null ) {
               this.left = new Node ( value );
               return;
           } else {
               this.left.add ( value );
           }
       }
       else{
           if ( this.right == null ) {
               this.right = new Node ( value );
               return;
           } else {
               this.right.add ( value );
           }
       }
    }

    public void midshow( ){
        Stack<Node> s1 = new Stack<> ();
        Node node =this;
        while(!s1.empty ()||node!=null){
            if(node!=null){
                s1.push ( node );
                node=node.left;
            }else{
                node=s1.pop ();
                System.out.print (node.value+"--" );
                node=node.right;
            }
        }
    }

    public Node getTargetNode(int value){
        if(this.value>value){
            if(this.left==null){
                return null;
            }
          return this.left.getTargetNode ( value );
        }else if(this.value==value){
            return this;
        }else{
            if(this.right==null){
                return null;
            }
           return this.right.getTargetNode ( value );
        }
    }

    public Node getFatherNode(int value){
        if((this.left!=null &&this.left.value==value) || (this.right!=null && this.right.value==value)){
            return this;
        }else{
            if(value<this.value && this.left!=null){
               return this.left.getFatherNode ( value);
            }
            else if(value>this.value && this.right!=null){
                return this.right.getFatherNode ( value );
            }
        }
        return null;
    }


}
