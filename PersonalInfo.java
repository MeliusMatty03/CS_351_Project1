/**
 * @author Matthew Elliott
 * @version 9/17/23
 * Class that holds the personal information part of a contact
 */

public class PersonalInfo {
    private String first;  // First name
    private String last;   // Last name
    private MaritalStatus status; // Marital Status

    /**
     * Constructor for personal info
     * @param first first name
     * @param last last name
     * @param status marital status
     */
    public PersonalInfo(String first, String last, MaritalStatus status){
    this.first = first;
    this.last = last;
    this.status = status;
    }

    /**
     * Gets the first name
     * @return first name
     */
    public String getFirst(){
        return this.first;
    }

    /**
     * Gets the last name
     * @return last name
     */
    public String getLast(){
        return this.last;
    }

    /**
     * Gets the marital status
     * @return marital status
     */
    public MaritalStatus getStatus(){
        return this.status;
    }
}
//End