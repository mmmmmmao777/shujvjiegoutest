package Packege1.Shujvjiegou.Paixu;

public class Bubble {
    public static void main ( String[] args ) {
      int temp;

        int[] i = new int[]{3,-1,5,10,9};
        for(int j=0;j<i.length;j++){
            int flag=0;
            for(int k=0;k<i.length-j-1;k++){
                if(i[k]>i[k+1]){
                    temp=i[k+1];
                    i[k+1]=i[k];
                    i[k]=temp;
                    flag++;
                }
            }
            if(flag==0){
                break;
            }
        }
        for(int l:i) {
            System.out.print ( l+" ");
        }

    }


    }

