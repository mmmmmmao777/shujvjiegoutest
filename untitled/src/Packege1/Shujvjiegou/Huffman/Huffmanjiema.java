package Packege1.Shujvjiegou.Huffman;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Huffmanjiema {
    public Huffmanjiema ( byte[] bytes , HashMap hash ) {
        this.bytes = bytes;
        this.hash = hash;
    }

    byte[] bytes ;
   static HashMap<Byte,String> hash ;

 //由byte【】得到010101的字符串
    public String jiema(int lastlen){
        String strr="";
        for(int t = 0;t<bytes.length;t++){
            int i=(int)bytes[t];
            if(t!=bytes.length-1){
                i|=256;
               String str= Integer.toBinaryString ( i ) ;
               strr+=str.substring ( str.length ()-8 );
        }else{
                i|=256;
                String str= Integer.toBinaryString ( i )  ;
                strr+=str.substring ( str.length ()-lastlen );

            }
        }
        return strr;
    }


    public static ArrayList  fanyi(String str){
        HashMap<String,Byte> rehash = new HashMap<> (  );
        for( Map.Entry<Byte,String> entry: hash.entrySet ()){
            rehash.put ( entry.getValue (),entry.getKey () );
        }
        //把他更换为byte数组
        ArrayList arr = new ArrayList (  );
        int i=0;
        while(i<str.length ()){
            Boolean flag=true;
            int count=1;
            while(flag){
               String string= str.substring ( i,i+count );
                if(rehash.get ( string )!=null){
                    arr.add ( rehash.get ( string ) );
                    i=i+count;
                    flag=false;
                }else{
                    count++;
                }
            }
        }
        return arr;
    }


}
