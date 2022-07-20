package Packege1.Shujvjiegou.Tree;

import java.util.ArrayList;
import java.util.Collections;

public class HefumanTree {
    //把数组变成赫夫曼树
    static int[] ar = {13,7,8,3,29,6,1};

    public static void main ( String[] args ) {

    midshoww ( setHfmTree ( ar ) );
    }
    public static Node setHfmTree(int[] arr){
        ArrayList<Node> arrl = new ArrayList<>();
        Node leftnode;
        Node rightnode;
        Node Fathernode;
        for ( int num : arr ) {
            arrl.add ( new Node ( num ) );
        }
        //排序
        while(arrl.size ()>1){
        Collections.sort ( arrl );
        leftnode = arrl.get ( 0 );
        rightnode = arrl.get ( 1 );
        Fathernode=new Node ( leftnode.value+rightnode.value );
       Fathernode.left=leftnode;
       Fathernode.right=rightnode;
       arrl.remove ( leftnode );
       arrl.remove ( rightnode );
       arrl.add ( Fathernode );
    }

        return arrl.get ( 0 );
    }
    //至此构建好了

   public static void midshoww(Node node){
        if(node==null){
            System.out.println ("树为空，错误" );
        }else{
            node.midshow ();
        }
   }
}
 class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

     public Node ( int value ) {
         this.value = value;
     }

     @Override
     public String toString ( ) {
         return  " "+value ;
     }



     @Override
     public int compareTo ( Node o ) {
         return this.value-o.value;
     }
     public void midshow(){
         System.out.print (this );
         if(this.left!=null){
             this.left.midshow ( );
         }
         if(this.right!=null){
             this.right.midshow ();
         }

     }
 }
