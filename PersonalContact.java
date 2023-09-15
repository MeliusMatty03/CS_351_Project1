public class PersonalContact extends Contact{//Added field and constructor.
    private Label label; // Label for grouping personal contacts

    /**
     * @param person
     * @param address
     * @param phone
     * @param email
     * @param label
     */
    public PersonalContact(PersonalInfo person, Contact.Address address, String phone, String email, Label label){
        super(person, address, phone, email);
        this.label = label;
    }
}

