import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * A 
 * @Author Matthew Elliott
 * Date 09/04/23
 */
public class ContactList{


    //These fields are just for testing purposes to see if file intake is done correctly
    //should be changed into contact objects
    public String contact1;

    public String contact2;

    public ContactList(String contact1, String contact2){
        this.contact1 = contact1;
        this.contact2 = contact2;
    }

    /**
     * This method prompts the user for which files they would like to use and saves them in a
     * Contact field
     */
    public void promptUser(){
        //create scanner using the command line interface
        Scanner sc = new Scanner(System.in);

        //first prompt
        System.out.print("Enter filename for contact list 1> ");
        contact1 = extractData(sc.next());

        //second prompt
        System.out.print("Enter filename for contact list 2> ");
        contact2 = extractData(sc.next());

        System.out.print("Welcome to database display \r\n" + //
                "\r\n" + //
                "Please make choice: \r\n" + //
                "        0) Quit\r\n" + //
                "        1) Intersect\r\n" + //
                "        2) Difference\r\n" + //
                "        3) Union\r\n" + //
                "        4) Select\r\n" + //
                "        5) Remove\r\n" + //
                "        6) Print both tables\r\n" + //
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        int choice = sc.nextInt();
        System.out.print("Enter Group >");
        int group = sc.nextInt();
        System.out.print("Enter attribute >");
        String attribute = sc.next();
        System.out.print("Enter value >");
        String value = sc.next();
        System.out.println();


        //close scanner
        sc.close();


    }

    /**
     * This method takes in a file location, as a string, and saves it as a string. <<<THIS WILL EVENTUALLY BE A CONTACT OBJECT
     * 
     *     
     */
     public String extractData(String fileLocation){
        String toReturn = "";
        try {
            //create a file object for file location
            File contactFile = new File(fileLocation);
            //create a scanner that reads from file
            Scanner fileScanner = new Scanner(contactFile);

            //Read each line from file and save it to a string<<<< PROB save to contact obj
            while (fileScanner.hasNextLine()){
                toReturn = toReturn + " " + fileScanner.nextLine();
            }

            //close scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return toReturn;

    }


    public String toString(){
        String toReturn = "";
        return toReturn;
    }

    public static void main(String[] args) {
        
        ContactList c1 = new ContactList(null, null);

        c1.promptUser();
        System.out.println(c1.contact1);

        System.out.println(c1.contact2);
    }

}