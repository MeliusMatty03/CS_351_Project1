public class PersonalInfo {
    private String first;  // First name
    private String last;   // Last name
    private MaritalStatus status; // Marital Status

    //Added constructor
    public PersonalInfo(String first, String last, MaritalStatus status){
    this.first = first;
    this.last = last;
    this.status = status;
    }

    public String getFirst(){
        return this.first;
    }

    public String getLast(){
        return this.last;
    }

    public MaritalStatus getStatus(){
        return this.status;
    }
}

