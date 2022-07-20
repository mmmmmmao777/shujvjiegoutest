package Packege1.Shujvjiegou.Paixu;

public class Select {
    static int[] i;
    public static void main ( String[] args ) {
         i = new int[]{3,-1,9,-10,99,10,9};
        Select s1 = new Select ();
        s1.sel ( i );
       for(int t: i){
           System.out.print ( t+" ");
       }
    }
    public void sel(int[] i){
        int min;
        for(int a=0;a<i.length;a++){
            min=i[a];
            int temp=a;
            for(int b=a+1;b<i.length;b++){
               if(i[b]<min){
                   min=i[b];
                   temp=b;
               }
            }
            if(min<i[a]){
                i[temp]=i[a];
                i[a]=min;
            }
        }
    }
}
