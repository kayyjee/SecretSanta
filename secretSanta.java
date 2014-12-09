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

    public static void main(String args[]) {
        
        System.out.println("How many people are entering?");
        scan = new Scanner(System.in);
        totalNames = scan.nextInt();

        names = new String[2][totalNames];
        

        fill();
        partner();
    }

    public static void fill(){
        for (int i =0; i<totalNames; i++){
            
            System.out.println("Please enter the name of someone involved:");
            String name = scan.nextLine();
            names[0][i] = name;
            System.out.println("Thank you");
        }
    }




    public static void partner(){
        ArrayList Got = new ArrayList();

        for (int i = 0; i < 7; i++) {
            Got.add(names[0][i]);
        }
        
        int max = 7;

        for (int i = 0; i < 7; i++) {
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
        



        for (int i = 0; i < 7; i++) {
            System.out.println("WELCOME! "+ names[0][i]+"\n\n\n\n");
            System.out.println("Hit Enter to get your Name");
            String temp = scan.nextLine();
            System.out.println("\n\nYour buying a gift for:  "+ names[1][i]+"!!\n");

            if (i==6){
                System.out.println("Happy Holidays!");
                System.exit(0);
            }
            System.out.println("Done? Hit Enter and pass to: "+ names[0][i+1]);
            temp = scan.nextLine();
        }
    }
}
