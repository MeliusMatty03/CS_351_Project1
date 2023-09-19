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

    /**
     * Compares this contact to another contact to determine if the two are equal.
     * @return True if the two contacts are the same, false otherwise.
     */
    @Override
    public Boolean equals(Contact other){
        if(other instanceof PersonalContact){
            PersonalContact personalOther = (PersonalContact)other;
            return (super.equals(other) &&
                this.label == personalOther.label);
        }else{
            return (super.equals(other));
        }
    }

    @Override
    public boolean exists(String attribute){
        
        return super.exists(attribute) || this.label.equals(attribute.toLowerCase());
    }
     @Override
    public boolean hasValue(String attribute, String value) {
        if(!this.exists(attribute)){throw new IllegalArgumentException();}
        boolean toReturn = super.hasValue(attribute, value);
        attribute = attribute.toLowerCase();
        switch(attribute){
            case "label":
            toReturn = (this.getLabel() + "").equals(value);
        }
        return toReturn;
    }
    
    @Override
    public void setValue(String attribute, String value){
        if(!this.hasValue(attribute, value)){throw new IllegalArgumentException();}
        attribute = attribute.toLowerCase();
        switch(attribute) {
            case "label":
                this.setLabel(attribute);
        }
    }

    private void setLabel(String attribute) {
        //this.label = MaritalStatus.
    }
}
//End