package MinorP1;


    import java.io.*;
import java.lang.*;
import java.util.*;
    public class Check
    {
        private File file;
        BufferedWriter output;
        private Formatter x;
        Scanner sc = new Scanner(System.in);
        int rollno;
        String fname, lname;
        public void get()
        {   System.out.println("Enter rollno: ");
            rollno = sc.nextInt();
            System.out.println("Enter first name: ");
            fname = sc.next();
            System.out.println("Enter last name: ");
            lname = sc.next();
        }
        public void openFile()
        {
            try {
                FileOutputStream fos = new FileOutputStream("Check.txt", true);
                x = new Formatter(fos);
        }
        catch(Exception e)
        {
            System.out.println("You have an error");
        }
        }
        public void addRecords()
        {   x.format("%s", "\n");
            x.format("%s", "***************************");
            x.format("%s", "\n");
            x.format("Roll No:  %s \nFirst Name: %s  \nLast Name: %s ", rollno, fname, lname);

        }
        public void closeFile()
        {   x.close();
        }
        public  static  void main(String args[]){
            Check ck=new Check();
            ck.get();
            ck.openFile();
            ck.addRecords();
            ck.closeFile();
        }
    }

