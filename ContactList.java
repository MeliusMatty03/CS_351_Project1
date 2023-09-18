/**
 * @author Matthew Elliott
 * @version 9/17/23
 * Class for a list of contact objects.
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ContactList {

    //These fields are just for testing purposes to see if file intake is done correctly
    //should be changed into contact objects
    private final String CONTACT1 = "Contact List 1";
    private final String CONTACT2 = "Contact List 2";

    /**
     * Constructor for ContactList.
     */
    public ContactList(){ //Is this finished?
    }

    /**
     * This method prompts the user for which files they would like to use and saves them in a
     * Contact field
     */
    public void promptUser() {
        //create scanner using the command line interface
        Scanner sc = new Scanner(System.in);

        Table<?> result;

        System.out.print("Enter filename for contact list 1> ");
        Table<?> t1 = extractData(sc.next(), CONTACT1);

        //second prompt
        System.out.print("Enter filename for contact list 2> ");
        Table<?> t2 = extractData(sc.next(), CONTACT2);

        System.out.println("Welcome to database display \r\n");
        int choice = 1;
        while(choice != 0){
            choice = makeChoice(sc);
            switch (choice) {
                case 0:
                    break;
                case 1:
                    choiceIntersect(sc, t1, t2);
                    //INSERT RETURN FOR INTERSECTION HERE
                    break;
                case 2:
                    choiceDifference(sc, t1, t2);
                    //INSERT RETURN FOR DIFFERENCE HERE
                    break;
                case 3:
                    choiceUnion(sc, t1, t2);
                    //insert return for union here
                    break;
                case 4:
                    choiceSelect(sc, t1, t2);
                    //insert return for select here
                    break;
                case 5: 
                    choiceRemove(sc, t1, t2);
                    //insert return for remove
                    break;
                case 6:
                    choicePrint(t1, t2);
                    //print both tables
                    break;
                default:

                    System.out.println("choose from 0 - 6");
                    break;
            }
        }
    
        System.out.println("goodbye.");
        //close scanner
        sc.close();

    }

    /**
     * Allows the user to make a selection from the menu
     * @param sc keyboard scanner
     * @return the user's choice
     */
    private int makeChoice(Scanner sc){
       System.out.print("Please make choice: \r\n" + //
                "        0) Quit\r\n" + //
                "        1) Intersect\r\n" + //
                "        2) Difference\r\n" + //
                "        3) Union\r\n" + //
                "        4) Select\r\n" + //
                "        5) Remove\r\n" + //
                "        6) Print both tables\r\n" + //
                ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        return sc.nextInt();
    }

    /**
     * Tells the user goodbye if they chose to quit.
     */
    public void choiceQuit() {
        System.out.println("goodbye.");
    }

    /**
     * Gets input from the user, then passes the input to the Intersect method.
     * @param sc keyboard scanner
     * @param t1 Table 1
     * @param t2 Table 2
     * @return Table of results from intersect method.
     */
    public Table<?> choiceIntersect(Scanner sc, Table<?> t1, Table<?> t2) {
        Table<?> toReturn = null;
        
        System.out.print("Enter Group >");
        int group = sc.nextInt();
        System.out.print("Enter attribute >");
        String attribute = sc.next();
        System.out.print("Enter value >");
        String value = sc.next();
        System.out.println();

        return toReturn;
    }
   
    /**
     * Gets input from the user, then passes the input to the Difference method.
     * @param sc keyboard scanner
     * @param t1 Table 1
     * @param t2 Table 2
     * @return Table of results from difference method.
     */
    public Table<?> choiceDifference(Scanner sc, Table<?> t1, Table<?> t2){
        Table<?> toReturn = null;

        System.out.println("Enter Contact List >");
        int contactList = sc.nextInt();
        return toReturn;
    }

    /**
     * Gets input from the user, then passes the input to the Union method.
     * @param sc keyboard scanner
     * @param t1 Table 1
     * @param t2 Table 2
     * @return Table of results from union method.
     */
    public Table<?> choiceUnion(Scanner sc, Table<?> t1, Table<?> t2) {
    
        Table<?> toReturn = null;
    
        System.out.println("Enter Contact List >");
        int contactList = sc.nextInt();
        return toReturn;
    }

    /**
     * Gets input from the user, then passes the input to the Select method.
     * @param sc keyboard scanner
     * @param t1 Table 1
     * @param t2 Table 2
     * @return Table of results from select method.
     */
    public Table<?> choiceSelect(Scanner sc, Table<?> t1, Table<?> t2) {
        Table<?> toReturn = null;
        System.out.print("Enter table (1/2) >");
        int table = sc.nextInt();
    
        System.out.print("Enter attribute >");
        String attribute = sc.next();
        System.out.print("Enter value >");
        String value = sc.next();
        return toReturn;
    }

    /**
     * Gets input from the user, then passes the input to the Remove method.
     * @param sc keyboard scanner
     * @param t1 Table 1
     * @param t2 Table 2
     * @return Table of results from remove method.
     */
    public Table<?> choiceRemove(Scanner sc, Table<?> t1, Table<?> t2){
        Table<?> toReturn = null;

        System.out.println("Enter attribute");
        String attribute = sc.next();
        System.out.println("Enter value >");
        String value = sc.next();

        return toReturn;
    }   

    /**
     * Displays both tables.
     * @param t1 Table 1
     * @param t2 Table 2
     */
    public void choicePrint(Table<?> t1, Table<?> t2){
        System.out.println("===========================" + t1.getTitle()
                            + "===========================");
        System.out.print(t1.toString());
        System.out.println("===========================" + t1.getTitle()
                        + "===========================\n");

        System.out.println("===========================" + t2.getTitle()
                            + "===========================");
        System.out.print(t2.toString());
        System.out.println("===========================" + t2.getTitle()
                            + "===========================\n");
    }

    /**
     * This method takes in a file location, as a string, and saves it as a string. <<<THIS WILL EVENTUALLY BE A CONTACT OBJECT
     * @param fileLocation A string to represent the file location of a contact list
     * @param name Name of the new contact list
     * @return The newly created table
     */
     public Table<?> extractData(String fileLocation, String name) {

        Table<?> toReturn = null;
       
        try {
            //create a file object for file location
            File contactFile = new File(fileLocation);
            //create a scanner that reads from file
            Scanner fileScanner = new Scanner(contactFile);

            String contactType = fileScanner.nextLine().trim(); // the contact type

            if (contactType.toUpperCase().equals("P")) {
                toReturn = makePersonalTable(fileScanner, name);
            }
            else if(contactType.toUpperCase().equals("W"))
                toReturn = makeWorkTable(fileScanner, name);
            
            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return toReturn;

    }

    /**
     * Reads in a file and makes a new personal table from it.
     * @param fileScanner Scanner for the file to be read in
     * @param name Name of personal table
     * @return New personal table
     */
    public Table<PersonalContact> makePersonalTable (Scanner fileScanner, String name) {
        //INSERT TABLE NAME
        Table<PersonalContact> toReturn = new Table<>(null, null, name);


        while (fileScanner.hasNextLine()){
            //Splits line into Sing
            String[] attributes = fileScanner.nextLine().split(","); 

            // Trim each element in the array
            for (int i = 0; i < attributes.length; i++) {
                attributes[i] = attributes[i].trim();
            }
            
            PersonalInfo pInfo = new PersonalInfo(attributes[0], attributes[1], MaritalStatus.NA);
            Contact.Address address = new Contact.Address(attributes[4], attributes[5], attributes[6], attributes[7]);
            String phone = attributes[3];
            String email = attributes[2];
            Label label = Label.valueOf(attributes[8].toUpperCase()); 
            
            PersonalContact contact = new PersonalContact(pInfo, address, phone, email, label);
            
            toReturn.insert(contact);
           
        }
                
        return toReturn;
    }

    /**
     * Reads in a file and makes a new work table from it.
     * @param fileScanner Scanner for the file to be read in
     * @param name Name of work table
     * @return New work table
     */
    public Table<WorkContact> makeWorkTable(Scanner fileScanner, String name) {
        //INSERT TABLE NAME HOW?
        Table<WorkContact> toReturn = new Table<>(null, null, name);

        while (fileScanner.hasNextLine()){

            //Splits line into Sing
            String[] attributes = fileScanner.nextLine().split(","); 

            // Trim each element in the array
            for (int i = 0; i < attributes.length; i++) {
                attributes[i] = attributes[i].trim();
            }

                MaritalStatus stat = MaritalStatus.valueOf(attributes[2].toUpperCase());

                PersonalInfo pInfo = new PersonalInfo(attributes[0], attributes[1], stat);
                Contact.Address address = new Contact.Address(attributes[5], attributes[6], attributes[7], attributes[8]);
                String phone = attributes[4];
                String email = attributes[3];

                String title = attributes[9];
                String company = attributes[10];
                String dep = attributes[11];
                
                WorkContact contact = new WorkContact(pInfo, address, phone, email, title, company, dep);
                    
                toReturn.insert(contact);
           
        }

        return toReturn;
    }
    
    /**
     * Main method to run everything.
     * @param args Can accept multiple arguments
     */
    public static void main(String[] args) {
        
        ContactList c1 = new ContactList();

        c1.promptUser();
        
    }
}
//End