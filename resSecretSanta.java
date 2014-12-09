import java.lang.Math;
import java.util.*;

/**
 *
 * @author Kyle
 */
class resSecretSanta {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
    public static void main(String args[]) {
        
        String[][] names = new String[2][7];
        

        names[0][0] = "Marius";
        names[0][1] = "Grayson";
        names[0][2] = "Carson";
        names[0][3] = "Kyle";
        names[0][4] = "Myles";
        names[0][5] = "Robert";
        names[0][6] = "Larry";
        
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
            Scanner scan = new Scanner(System.in);
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
