import java.io.File;
import java.util.Scanner;



import java.io.FileNotFoundException;

/**
 * A 
 * @Author Matthew Elliott
 * Date 09/04/23
 */
public class ContactList {


    //These fields are just for testing purposes to see if file intake is done correctly
    //should be changed into contact objects
    private final String CONTACT1 = "Contact List 1";
    private final String CONTACT2 = "Contact List 2";

    public ContactList(){
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

    public void choiceQuit() {
        System.out.println("goodbye.");
    }

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
   
    public Table<?> choiceDifference(Scanner sc, Table<?> t1, Table<?> t2){
        Table<?> toReturn = null;

        System.out.println("Enter Contact List >");
        int contactList = sc.nextInt();

        return toReturn;

    }
    public Table<?> choiceUnion(Scanner sc, Table<?> t1, Table<?> t2) {
    
        Table<?> toReturn = null;
    
        System.out.println("Enter Contact List >");
        int contactList = sc.nextInt();
        return toReturn;
    }
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
    public Table<?> choiceRemove(Scanner sc, Table<?> t1, Table<?> t2){
        Table<?> toReturn = null;

        System.out.println("Enter attribute");
        String attribute = sc.next();
        System.out.println("Enter value >");
        String value = sc.next();

        return toReturn;
    }   

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
     * 
     *     
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
    

    public static void main(String[] args) {
        
        ContactList c1 = new ContactList();

        c1.promptUser();
        
    }

}