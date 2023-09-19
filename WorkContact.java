/**
 * @author Matthew Elliott
 * @version 9/17/23
 * A work contact object that extends contacts. It adds a job title, company, and department.
 */

public class WorkContact extends Contact {
    private String title;       // Job title
    private String company;     // Company contact works for
    private String department;  // Contact’s department

    /**
     * a constructor for the work contact object
     * @param person a person object 
     * @param address an address object
     * @param phone a string with a person's phone number 
     * @param email a string representation of a persons email
     * @param title Job title
     * @param company Company contact works for
     * @param department Contact’s department
     */
    public WorkContact(PersonalInfo person, Address address, String phone,
                       String email, String title, String company, String department){
        super(person, address, phone, email);
        this.title = title;
        this.company = company;
        this.department = department;
    }

    /**
     * Gets the contact's job title
     * @return Job title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the company contact works for
     * @return Company contact works for
     */
    public String getCompany() {
        return this.company;
    }

    /**
     * Gets the contact's department.
     * @return Contact’s department
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Compares this contact to another contact to determine if the two are equal.
     * @return True if the two contacts are the same, false otherwise.
     */
    @Override
    public Boolean equals(Contact other){
        if(other instanceof WorkContact){
            WorkContact workOther = (WorkContact)other;
            return (super.equals(other) &&
                    this.title == workOther.title &&
                    this.company == workOther.company &&
                    this.department == workOther.department);
        }else{
            return (super.equals(other));
        }
    }
}
//End