/**
 * @author Matthew Elliott
 * @version 9/17/23
 * A personal contact object that extends contacts. It adds a label to group contacts.
 */

public class PersonalContact extends Contact{
    private Label label; // Label for grouping personal contacts

    /**
     * a constructor for the work contact object
     * @param person a person object 
     * @param address an address object
     * @param phone a string with a person's phone number 
     * @param email a string representation of a persons email
     * @param label Label for grouping personal contacts
     */
    public PersonalContact(PersonalInfo person, Contact.Address address, String phone, String email, Label label){
        super(person, address, phone, email);
        this.label = label;
    }

    /**
     * Gets the label
     * @return Label for grouping personal contacts
     */
    public Label getLabel(){
        return this.label;
    }
}
//End