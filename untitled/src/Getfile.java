import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Getfile {
    public static void main ( String[] args ) {
        try {
            FileInputStream f1 = new FileInputStream ("D:/Person11.txt " );
            ObjectInputStream o1 = new ObjectInputStream ( f1 );
            FileTest p= (FileTest)o1.readObject ();
            System.out.println (p.age );
            System.out.println (p.name );
        }catch ( Exception e ){
            System.out.println (e.getMessage () );
        }

    }
}
