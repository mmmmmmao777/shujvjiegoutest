package Packege1.Shujvjiegou.Tree;

public class ShuzuSwitch {
    int[] arr ={1,2,3,4,5,6,7};
    public static void main ( String[] args ) {
    ShuzuSwitch s1 = new ShuzuSwitch ();
    s1.printOut ( 0 );
    }
    //中序遍历
    public void printOut(int index){
        if(arr.length==0||arr==null){
            System.out.println ("此数列为空，无法输出" );
        }
        if(index*2+1<arr.length){
            printOut ( index*2+1 );
        }
        System.out.println (arr[index] );
        if(index*2+2<arr.length){
            printOut ( index*2+2);
        }
    }
}

