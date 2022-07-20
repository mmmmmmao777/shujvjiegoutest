import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

import javax.tools.FileObject;
import java.io.*;
import java.rmi.server.UID;

public class FileTest implements Serializable{
    public static final long SerialVersionUID=45461l;
    int age;
    String name;
    private int carid;
    public static void main ( String[] args )  {
        try {
            FileTest pp = new FileTest ();
            pp.age=3;
            pp.name="haha";
            pp.carid=21331;
//
            FileOutputStream f1 = new FileOutputStream ( "D:\\Person11.txt");
            ObjectOutputStream f2 = new ObjectOutputStream ( f1 );
            f2.writeObject ( pp );
            f2.close ();
            f1.close ();
        }catch ( Exception e ){
            System.out.println (e.getMessage () );
        }

    }
}

class Person implements Serializable{


}
