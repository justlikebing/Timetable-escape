package MinorP1;
//import java.io.*;
import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

import static MinorP1.TextFiles.*;

//import java.io.FileNotFoundException;
//import java.io.File;
public class Main4 {
//    private  static Formatter fm;
//    private static File file;
//    static BufferedWriter output;

    TextFiles ts=new TextFiles();
    public static Scanner in = new Scanner(System.in);
    public static int i = 0;
    public static String[] Module = new String[50];
    public static String[] Batch = new String[50];
    public static String[] Faculty = new String[50];
    public static String[] RoomNo = new String[50];
    public static String[] startTime = new String[50];
    public static String[] endTime = new String[50];
    public static void main(String[] args) {
        input();
        //toTextFile();
        printingFunc();

        int choice;
        do {
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("1. Print Default TimeTable");
            System.out.println("2. Defer a Class");
            System.out.println("3. Reschedule a Class");
            System.out.println("4. EXIT");
            choice = in.nextInt();
            switch (choice) {
                case 1:  // printing default timetable
                    printTT(); // reading the text file
                    break;
                case 2: // deletion
                    deletion();
                    break;
                case 3: // Updating Function
                    updateFunc();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Number");
            }
        }while(choice!=4);
    }
    // INPUT DEFAULT TIMETABLE
    public static void input() {
        for (int i = 0; i < 2; i++) {      // Maximum class one individual may have is 10 in a day. (Let's Assume)
            System.out.println("Enter Module name: ");
//            Module.add(in.nextLine());
            Module[i] = in.nextLine();
            System.out.println("Enter Batch: ");
//            Batch.add(in.nextLine());
            Batch[i] = in.nextLine();
            System.out.println("Enter Faculty: ");
//            Faculty.add(in.nextLine());
            Faculty[i] = in.nextLine();
            System.out.println("Enter Room Number: ");
//            RoomNo.add(in.nextInt());
            RoomNo[i] = in.nextLine();
            System.out.println("Enter Start Time: ");
//            startTime.add(in.next());
            startTime[i] = in.nextLine();
            System.out.println("Enter End Time: ");
//            endTime.add(in.next());
            endTime[i] = in.nextLine();            
        }
    }
    // PRINTING TIMETABLE FUNCTION
    //this function prints our user input as the default timetable
    public static void printTT(){
        for (int i = 0; i <2; i++) {
            System.out.println("Module: " + Module[i]);
            System.out.println("Batch: " + Batch[i]);
            System.out.println("Faculty: " + Faculty[i]);
            System.out.println("RoomNo: " + RoomNo[i]);
            System.out.println("Start Time: " + startTime[i]);
            System.out.println("End Time: " + endTime[i]);
            System.out.println();
        }
    }
    public static void printingFunc() {
        for (int i = 0; i <2; i++) {

                openFile();
                fm.format("%s", "\n");
                fm.format("%s", "***************************");
                fm.format("%s", "\n");
                fm.format("Module:  %s \nBatch: %s  \nFaculty: %s \nRoomNo: %s \nStart Time: %s \nEnd Time: %s" ,Module[i],
                        Batch[i],Faculty[i],RoomNo[i],startTime[i],endTime[i]);
              closeFile();
        }

    }
    // DELETION FUNCTION
    //this function is used to delete the classes we dont want to have for the day
    public static void deletion() {
        System.out.println("Enter the index Number of the Class you want to defer: ");
        i = in.nextInt();
        in.nextLine();             // for \n that will be stored in the buffer memory.
        // Coping the next element to the deletion position
        Module[i] = Module[i + 1];
        Batch[i] = Batch[i + 1];
        Faculty[i] = Faculty[i + 1];
        RoomNo[i] = RoomNo[i + 1];
        startTime[i] = startTime[i + 1];
        endTime[i] = endTime[i + 1];
        System.out.println();
        System.out.println("CLASS DEFER SUCCESSFULLY! ");
    }
    //UPDATING FUNCTION
    //this module is used to re-schedule a subject!
    public static void updateFunc() {
        System.out.println("Enter the index Number of the Class you want to Reschedule: ");
        i = in.nextInt();
        in.nextLine();             // for \n that will be stored in the buffer memory.
        System.out.println("Enter the startTime: ");
//        startTime[i] = in.nextLine();
        String newStartTime = in.next();
        startTime[i] = newStartTime;
        System.out.println("Enter the endTime: ");
//        endTime[i] = in.nextLine();
        String newEndTime = in.next();
        endTime[i] = newEndTime;
        printingFunc();
        System.out.println();
        System.out.println("YOUR TIMETABLE HAS BEEN UPDATED! ");
    }
}