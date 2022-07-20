package ReflectLearn;

import java.util.Arrays;

public class Ldf {

    public static void main ( String[] args ) {
        Ldf l1 = new Ldf ( );
        l1.getLdf (0 );
    }

    int[][] ldf = new int[ 3 ][ 3 ];
    int[] a = new int[3];
int count=0;
    public boolean getLdf ( int row ) {
        if(row==3) {

//            for ( int[] t : ldf ) {
//                System.out.println ( Arrays.toString ( t ) );
//            }
            getLdf2 ( 0 );
        }else {


            for ( int i = 0 ; i < 3 ; i++ ) {

                if ( kejia ( row , i ) ) {
                    ldf[ row ][ i ] = 1;
                    if ( getLdf ( row + 1 ) ) {
                        return true;
                    }
                    ldf[ row ][ i ] = 0;
                }
            }

        }
        return false;
    }
    
    public boolean getLdf2 ( int row ) {
        if(row==3){
//            for(int[] t : ldf){
//                System.out.println ( Arrays.toString ( t ));}
//
            getLdf3 ( 0 );
        }else {

            for ( int i = 0 ; i < 3 ; i++ ) {

                if ( kejia2 ( row , i ) ) {
                    ldf[ row ][ i ] = 2;
                    if ( getLdf2 ( row + 1 ) ) {
                        return true;
                    }
                    ldf[ row ][ i ] = 0;
                }
            }


        }
        return false;
    }


    public boolean getLdf3 ( int row ) {
        if(row==3) {

            for ( int[] t : ldf ) {
                System.out.println ( Arrays.toString ( t ) );
            }

        }else{


        for(int i =0;i<3;i++){

            if(kejia3(row,i)){
                ldf[row][i]=3;
                if(getLdf3 ( row+1 )){
                    return true;
                }
                ldf[row][i]=0;
            }
        }



    }
        return false;
    }


    public boolean kejia(int i ,int j){
        if(i==0){
            return true;
        }
        for(int k= i-1;k>=0;k--){
            if(ldf[k][j]!=0){
                return false;
            }
        }
        return true;
    }


    public boolean kejia2(int i ,int j){

        if(i==0 && ldf[i][j]==0){
            return true;
        }
        if(ldf[i][j]==1){
            return false;
        }

        for(int k= i-1;k>=0;k--){
            if(ldf[k][j]==2){
                return false;
            }
        }
        return true;
    }


    public boolean kejia3(int i ,int j){

        if(i==0 && ldf[i][j]==0){
            return true;
        }

        if(ldf[i][j]==1 ||ldf[i][j]==2){
            return false;
        }

        for(int k= i-1;k>=0;k--){
            if(ldf[k][j]==3){
                return false;
            }
        }
        return true;
    }
}
