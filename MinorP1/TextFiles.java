package MinorP1;
import java.io.*;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Hashtable;

public class TextFiles {

    public static Formatter fm;
    private static File file;
    static BufferedWriter output;
    public static void openFile()
    {
        try {
            FileOutputStream fos = new FileOutputStream("Output.txt", true);
            fm= new Formatter(fos);
        }
        catch(Exception e)
        {
            System.out.println("You have an error");
        }
    }
    public  static void closeFile(){
        fm.close();
    }

}
