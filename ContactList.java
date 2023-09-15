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
    public void promptUser() {
        //create scanner using the command line interface
        Scanner sc = new Scanner(System.in);

        //first prompt
        System.out.print("Enter filename for contact list 1> ");
        Table t1 = extractData(sc.next());

        //second prompt
        System.out.print("Enter filename for contact list 2> ");
        Table t2 = extractData(sc.next());

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
     public Table extractData(String fileLocation) {
        Table toReturn = null;
       
        try {
            //create a file object for file location
            File contactFile = new File(fileLocation);
            //create a scanner that reads from file
            Scanner fileScanner = new Scanner(contactFile);

            //Read each line from file and save it to a string<<<< PROB save to contact obj
            String contactType = fileScanner.next(); // the contact type

            if (contactType.toUpperCase() == "P")
                toReturn = makePersonalTable(fileScanner);
            else if(contactType.toUpperCase() == "W")
                //toReturn = makeWorkTable(fileScanner);
            
            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return toReturn;

    }


    public Table makePersonalTable (Scanner fileScanner) {

        Table toReturn = null;

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
                   

           
        }
                //make contact obj
                //append the object to a linked list i.e. table 1.

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