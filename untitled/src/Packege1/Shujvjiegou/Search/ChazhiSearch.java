package Packege1.Shujvjiegou.Search;

import java.util.ArrayList;

public class ChazhiSearch {
//   static int[] i = {-3,10,19,20,21,22,40,50,55,60};
static int[] i = {19,19,19};
    public static void main ( String[] args ) {
        ArrayList a1= search(i,0,i.length-1,19) ;
        System.out.println (" "+a1 );
    }

    public static ArrayList search(int[] arr,int left,int right,int t) {

        if ( left > right || arr[ left ] > t || arr[ right ] < t ) {
            return new ArrayList ( );
        }

        int  mid;
//       如果数组元素都相同， 会出现除0的情况，
        if ( arr[ right ] - arr[ left ] == 0 ) {
        mid= (right+left)/2;
        } else {
           mid = left + ( right - left ) * ( t - arr[ left ] ) / ( arr[ right ] - arr[ left ] );
        }

            if ( arr[ mid ] == t ) {
                //遍历出所有的下标
                ArrayList<Integer> a1 = new ArrayList<Integer> ( );
                a1.add ( mid );
                int temp = mid - 1;
                while ( true ) {
                    if ( temp < 0 || arr[ temp ] != t ) {
                        break;
                    }
                    a1.add ( temp-- );
                }
                temp = mid + 1;
                while ( true ) {
                    if ( temp > arr.length-1 || arr[ temp ] != t ) {
                        break;
                    }
                    a1.add ( temp++ );
                }
                return a1;
            } else if ( arr[ mid ] > t ) {
                return search ( arr , left , mid - 1 , t );
            } else {
                return search ( arr , mid + 1 , right , t );
            }
        }

}
