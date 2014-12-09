import java.lang.Math;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

/**
 *
 * @author Kyle
 */
class secretSanta {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
    private static String[][] names;
    private static int totalNames;
    private static Scanner scan; 
    static PrintWriter writer;
    private static Scanner scan2; 

    public static void main(String args[]) throws Exception{

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy-HH.mm.ss");
        Date date = new Date();
        String dateLog = dateFormat.format(date);
        //Create log writer.
        writer = new PrintWriter(dateLog+"_SecretSanta_Results.txt", "UTF-8");



        System.out.println("How many people are entering?");
        scan = new Scanner(System.in);
        scan2 = new Scanner(System.in);
        totalNames = scan.nextInt();

        names = new String[2][totalNames];
        

        fill();
        partner();
    }

    public static void fill(){
        for (int i =0; i<totalNames; i++){

            System.out.println("Please enter the name of someone involved:");
            
            names[0][i] = scan.next();
            System.out.println("Thank You");
        }
    }




    public static void partner(){
        ArrayList Got = new ArrayList();

        for (int i = 0; i < totalNames; i++) {
            Got.add(names[0][i]);
        }
        
        int max = totalNames;

        for (int i = 0; i < totalNames; i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt(max);

            
            names[1][i] = Got.get(randomNum).toString();

            while(names[0][i] == names [1][i])
            {
                  randomNum = rand.nextInt(max);
                  names[1][i] = Got.get(randomNum).toString();
               }
            

            Got.remove(randomNum);
            max--;
        }
        



        for (int i = 0; i < totalNames; i++) {
            System.out.println("WELCOME! "+ names[0][i]+"\n\n\n\n");
            writer.print(names[0][i]+"\n");

            System.out.println("Hit Enter to get your Name");
            String temp = scan2.nextLine();
            System.out.println("\n\nYour buying a gift for:  "+ names[1][i]+"!!\n");
            writer.println(" is buying gift for  "+ names[1][i]+"\n\n");

            if (i==(totalNames - 1)){
                System.out.println("Happy Holidays!");
                writer.close();
                System.exit(0);
            }
            System.out.println("Done? Hit Enter and pass to: "+ names[0][i+1]);
            temp = scan2.nextLine();
        }
    }
}
