public class WorkContact extends Contact {
    private String title;       // Job title
    private String company;     // Company contact works for
    private String department;  // Contact’s department
    //...

    //Added constructor
    public WorkContact(PersonalInfo person, Address address, String phone,
                       String email, String title, String company, String department){
        super(person, address, phone, email);
        this.title = title;
        this.company = company;
        this.department = department;
    }
}