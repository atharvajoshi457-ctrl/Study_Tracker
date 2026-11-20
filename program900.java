import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

import java.io.*;

// Done
class StudyLog
{
    private LocalDate Date;
    private String Subject;
    private double Duration;
    private String Description;

    public StudyLog(LocalDate a,String b,Double c,String d)
    {
        this.Date = a;
        this.Subject = b;
        this.Duration = c;
        this.Description = d;
    }

    public LocalDate gateDate()
    {
        return this.Date;
    }

    public String getSubject()
    {
        return this.Subject;
    }

    public double getDuration()
    {
        return this.Duration;
    }

    public String getDescription()
    {
        return this.Description;
    }

    @Override   
    public String toString()
    {
        return Date+" | "+Subject+" | "+Duration+" | "+Description;
    }
}

class StudyTracker
{
    public ArrayList <StudyLog>Database = new ArrayList<StudyLog>();

    public void InsertLog()
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("----------------------------------------------");
        System.out.println("-----Enter valid details of your study--------");
        System.out.println("----------------------------------------------");

        LocalDate Dateobj = LocalDate.now();

        System.out.println("Please enter the name of subject like C/C++/JAVA/Python");
        String sub = sobj.nextLine();

        System.out.println("Enter the time period of your study in hours");
        double dur = sobj.nextDouble();
        sobj.nextLine();

        System.out.println("Please provide the Description of your study");
        String desc = sobj.nextLine();

        StudyLog studyobj = new StudyLog(Dateobj,sub,dur,desc);

        Database.add(studyobj);

        System.out.println("Study log gets stored Succesfully");
        System.out.println("----------------------------------------------");
    }

    public void DisplayLog()
    {
        System.out.println("-----------------------------------------------");

        if(Database.isEmpty())
        {
            System.out.println("Nothing to Display");
            System.out.println("-----------------------------------------------");
            return;
        }
        System.out.println("-----Log Report of Marvellous study Tracker----");
        System.out.println("-----------------------------------------------");

        for (StudyLog s : Database)
        {
            System.out.println(s);
        }

        System.out.println("-----------------------------------------------");
    }

    public void ExportCSV()
    {
        if(Database.isEmpty())
        {
            System.out.println("-----------------------------------------------");
            System.out.println("Nothing to Export");
            System.out.println("-----------------------------------------------");
            return;
        }

        String Filename = "MarvellousStudyTracker.csv";

        try(FileWriter fwobj = new FileWriter(Filename))
        {
            fwobj.write("Date,Subjectr,Duration,Description\n");

            for(StudyLog s : Database)
            {
                fwobj.write(s.gateDate()+","+
                            s.getSubject().replace(","," ")+","+
                            s.getDuration()+","+
                            s.getDescription().replace(","," ")+"\n");
            }

            System.out.println("Data gets exported in CSV : "+Filename);
        }

        catch(Exception eobj)
        {
            System.out.println("Exception occured in csv Handling");
        }
    }

    public void SummaryByDate()
    {

    }

    public void SummaryBySubject()
    {
        
    }
}

class program900                          
{
    public static void main(String A[])
    {

        StudyTracker stobj = new StudyTracker();

        System.out.println("-------------------------------------------------------");
        System.out.println("----------Welcome to Marvellous Study Tracker----------");
        System.out.println("-------------------------------------------------------");

        int iChoice = 0;

        do
        {
            System.out.println("Please select Appropriatr option");
            System.out.println("1 : Insert new Study Log");
            System.out.println("2 : View all study Logs");
            System.out.println("3 : Export Study log to CSV file");
            System.out.println("4 : Summary of study log by date");
            System.out.println("5 : Summary of study log by subject");
            System.out.println("6 : Exit the Application");

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1 :
                    stobj.InsertLog();
                    break;
                case 2 :
                    stobj.DisplayLog();
                    break;
                case 3 :
                    stobj.ExportCSV();
                    break;
                case 4 :
                    stobj.SummaryByDate();
                    break;
                case 5 :
                    stobj.SummaryBySubject();
                    break;
                case 6 :
                    System.out.println("-------------------------------------------------------");
                    System.out.println("------thank you for using Marvellous Study Tracker-----");
                    System.out.println("-------------------------------------------------------");
                    break;
                default : 
                    System.out.println("Please enter a valid option");

            }
        }while(iChoice != 6);
    }   
}