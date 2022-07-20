package Packege1.Suanfa;

public class hannuota {
    public static void main ( String[] args ) {
        hannuotaa ( 3,'A','B','C' );
    }
    public  static void hannuotaa(int num,char a,char b,char c){
        if(num==1){
            System.out.println ( "从"+a+"转到"+c );
            return;
        }
        //把最下面一个盘看成一个，剩下的上面的盘看做一个
        //先把上面的盘从a移到b，借助c
        hannuotaa ( num-1,a,c,b );
        //把最后一个从a转到c
        System.out.println ( "从"+a+"转到"+c  );
        //把上面的盘从b转到c，借助a
        hannuotaa ( num-1,b,a,c );
    }
}
