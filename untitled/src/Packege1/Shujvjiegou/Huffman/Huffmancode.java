package Packege1.Shujvjiegou.Huffman;

import javax.tools.JavaCompiler;
import java.util.*;

//1.把字符串变成byte数组
public class Huffmancode {

    public static void main ( String[] args ) {
        Huffmancode huffmancode = new Huffmancode ();
        String  str="hello world";
        byte[] bytes=huffmancode.zipall ( str );
        Huffmanjiema h2 = new Huffmanjiema ( bytes,hash );
//        System.out.println ( Arrays.toString ( bytes));

        ArrayList<Byte> arr=Huffmanjiema.fanyi (h2.jiema ( lastlen ));

        //拿到了 byte 类型的集合，是一串数字，把它变成String类型
        StringBuilder string = new StringBuilder (  );
        byte[] arrr = new byte[arr.size ()];
        for(int t = 0;t<arr.size ();t++){
            arrr[t]=arr.get ( t );
        }
        System.out.println (new String ( arrr ) );
    }
    public void jiema(){

    }

    public byte[] zipall(String  str){
        byte[] byte1=switchByte ( str );
        Node huffmanRoot= creatNodeTree ( byte1 );
      getHuffmanCode(huffmanRoot,"",new StringBuilder());
        return zip (  byte1 ,hash);
    }



// 有了编码表 ，对byte数组进行压缩
    public byte[] zip(byte[] bytes,HashMap hash){
        StringBuilder string = new StringBuilder (  );
        for(byte bb: bytes){
            string.append ( hash.get ( bb ) );
        }
//        System.out.println (string );
        //转换为byte类型存储进byte数组中
        byte[] bytes1 = new byte[ ( string.length ( ) + 7 ) / 8 ];
        int index = 0;
        for ( int i = 0 ; i < string.length ( ) ; i = i + 8 ) {
            if ( i + 8 < string.length ( ) ) {
                bytes1[ index++ ] = (byte) Integer.parseInt ( string.substring ( i , i + 8 ),2 );
            } else {
                bytes1[ index++ ] = (byte) Integer.parseInt ( string.substring ( i ) ,2);
                lastlen=string.substring ( i ).length ();
            }
        }
        return  bytes1;
    }

static  int lastlen;



    public byte[] switchByte(String str){
       return str.getBytes ();
    }
//中序输出树
    public void midshow(Node node){
        if(node==null){
            System.out.println ("空" );
            return;
        }
        node.midshoww ();
    }
 //输入一个byte数组，返回 Node 霍夫曼树
    public Node creatNodeTree(byte[] b1){
        HashMap<Byte,Integer> node = new HashMap<> (  );
        int count;
        for(byte bb:b1){
            if(node.containsKey ( bb )){
              count = node.get ( bb );
              node.put ( bb,count+1 );
            }else{
                node.put ( bb,1 );
            }
        }

        //构建node集合
        ArrayList<Node> arr = new ArrayList<> ( );
      for( Map.Entry<Byte,Integer> entry:node.entrySet ()){
          arr.add ( new Node (entry.getKey (),entry.getValue ()) );
      }
//        System.out.println (arr );
      //构建霍夫曼树
        Node left ;
        Node right;
        Node father;
        while(arr.size ()>1) {
            Collections.sort ( arr );
            left=arr.get ( 0 );
            right=arr.get ( 1 );
            father=new Node ( null,left.weight+right.weight );
            father.left=left;
            father.right=right;
            arr.remove ( left );
            arr.remove ( right );
            arr.add ( father );
        }
        return arr.get ( 0 );
    }



    //st 向左为0，向右为1
    //
  static   HashMap<Byte,String> hash = new HashMap<> (  );
    public void getHuffmanCode(Node node,String st,StringBuilder string) {
        StringBuilder str1 = new StringBuilder ( string );
        str1.append ( st );
        if ( node != null ) {
            if ( node.data == null ) {
                getHuffmanCode ( node.left , "0" , str1 );
                getHuffmanCode ( node.right , "1" , str1 );
            } else {
                hash.put ( node.data , str1.toString ( ) );
            }
        }

    }
}






//创建node结点
class Node implements Comparable<Node>{
    int weight;
    Byte data;
    Node left;
    Node right;

    public Node (Byte data, int weight) {
        this.weight = weight;
        this.data = data;
    }

    @Override
    public String toString ( ) {
        return data+"=>"+weight;
    }


    @Override
    public int compareTo ( Node o ) {
        return this.weight-o.weight;
    }
    public void midshoww(){
        System.out.println (this );
        if(this.left!=null){
            this.left.midshoww ();
        }
        if(this.right!=null){
            this.right.midshoww ();
        }
    }

}
