import java.lang.Math;
import java.util.*;

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
    private static Scanner scan2; 

    public static void main(String args[]) {
        
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
            System.out.println("Hit Enter to get your Name");
            String temp = scan2.nextLine();
            System.out.println("\n\nYour buying a gift for:  "+ names[1][i]+"!!\n");

            if (i==(totalNames - 1)){
                System.out.println("Happy Holidays!");
                System.exit(0);
            }
            System.out.println("Done? Hit Enter and pass to: "+ names[0][i+1]);
            temp = scan2.nextLine();
        }
    }
}
