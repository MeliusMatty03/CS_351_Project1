public class PersonalContact extends Contact{//Added field and constructor.
    private Label label; // Label for grouping personal contacts

    public PersonalContact(PersonalInfo person, Address address, String phone, String email, Label label){
        super(person, address, phone, email);
        this.label = label;
    }

}