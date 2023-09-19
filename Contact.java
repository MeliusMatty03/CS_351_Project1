
/**
 * @author Matthew Elliott
 * @version 9/17/23
 * Class that represents a general contact card.
 */

public class Contact implements ContactInterface, Cloneable {
    private PersonalInfo person;   // Personal information
    private Address address;       // Current address
    private String phone;          // Phone number
    private String email;          // Email  

    /**
     * a constructor for the contact object
     * @param person a person object 
     * @param address an address object
     * @param phone a string with a person's phone number 
     * @param email a string representation of a persons email
     */
    public Contact(PersonalInfo person, Address address, String phone, String email){
        this.person = person;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Returns a person object 
     * @return a person object 
     */
    public PersonalInfo getPerson(){
        return this.person;
    }

    /**
     * Returns a string with a person's phone number
     * @return a string with a person's phone number
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Returns an address object 
     * @return an address object
     */
    public Address getAddress() {
        return this.address;
    }

    /**
     * Returns a string representation of a persons email
     * @return a string representation of a persons email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * An address class that holds all properties of an address, street, city, state, and zip code.
     */
    public static class Address{
        private String streetAddress;
        private String cityAddress;
        private String state;
        private String zipCode;

        /**
         * Constructor for Address
         * @param streetAddress Street line of the address
         * @param cityAddress City line of the address
         * @param state State in which the contact lives
         * @param zipCode Zip Code of the address
         */
        public Address(String streetAddress, String cityAddress, String state, String zipCode){
            this.streetAddress = streetAddress;
            this.cityAddress = cityAddress;
            this.state = state;
            this.zipCode = zipCode;
        }

        /**
         * Gets the street address
         * @return Street address
         */
        public String getStreetAddress(){
            return this.streetAddress;
        }

        /**
         * Gets the city address
         * @return City address
         */
        public String getCityAddress() {
            return this.cityAddress;
        }

        /**
         * Gets the state
         * @return State
         */
        public String getState() {
            return this.state;
        }

        /**
         * Gets the zip code
         * @return Zip code
         */
        public String getZipCode() {
            return this.zipCode;
        }

        public void setStreetAddress(String value) {
            this.streetAddress = value;
        }

        public void setCityAddress(String value) {
            this.cityAddress = value;
        }

        public void setState(String value) {
            this.state = value;
        }

        public void setZipCode(String value) {
            this.zipCode = value;
        }
    }

    /**
    * Check to see if a record has an attribute. Should not be case sensitive.
    * @param attribute possible attribute within a record.
    * @return true if the value is contained in the object, false otherwise.
    */
    @Override
    public boolean exists(String attribute) {
        return (person.getLast().equals(attribute.toLowerCase()) || 
                person.getFirst().equals(attribute.toLowerCase()) ||
                (person.getStatus() + "").equals(attribute.toLowerCase()) ||
                address.getCityAddress().equals(attribute.toLowerCase()) ||
                address.getStreetAddress().equals(attribute.toLowerCase()) ||
                address.getState().equals(attribute.toLowerCase()) ||
                (address.getZipCode() + "").equals(attribute.toLowerCase()) ||
                phone.equals(attribute.toLowerCase()) ||
                email.equals(attribute.toLowerCase()));
    }

    /**
    * Check to see if a record has an attribute containing a specific value. Should not be case sensitive.
    * @param attribute possible attribute within a record. i.e. first, last, email... 
    * @param value desired value of the attribute i.e. Cindy, Thompson.
    * @return true if the value is contained in the object, false otherwise.
    * @throws IllegalArgumentException if the attribute is invalid.
    */
    @Override
    public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
        if(!this.exists(attribute)){throw new IllegalArgumentException();}
        
        boolean toReturn = false;
        attribute = attribute.toLowerCase();
        switch(attribute){
            case "last":
                toReturn = this.person.getLast().toLowerCase().equals(value);
                break;
            case "first":
                toReturn = this.person.getFirst().toLowerCase().equals(value);
                break;
            case "status":
                toReturn = (this.person.getStatus() + "").toLowerCase().equals(value);
                break;
            case "streetaddress":
                toReturn = this.address.getStreetAddress().toLowerCase().equals(value);
                break;
            case "cityaddress":
                toReturn = this.address.getCityAddress().toLowerCase().equals(value);
                break;
            case "state":
                toReturn = this.address.getState().toLowerCase().equals(value);
                break;
            case "zipcode":
                toReturn = (this.address.getZipCode() + "").toLowerCase().equals(value);
                break;
            case "phone":
                toReturn = this.getPhone().toLowerCase().equals(value);
                break;
            case "email":
                toReturn = this.getEmail().toLowerCase().equals(value);
                break;
            default:
                throw new IllegalArgumentException();

        }
        return toReturn;
    }

    /**
    * Change the value of a specific attribute.
    * @param attribute possible attribute within a record.
    * @param value new value of the attribute.
    * @throws IllegalArgumentException if the attribute is invalid.
    */
    @Override
    public void setValue(String attribute, String value) throws IllegalArgumentException {
        if(!this.hasValue(attribute, value)){throw new IllegalArgumentException();}

        attribute = attribute.toLowerCase();
        switch(attribute){
            case "last":
                this.person.setLast(value);
                break;
            case "first":
                this.person.setFirst(value);
                break;
            case "status":
                this.person.setStatus(value);
                break;
            case "streetaddress":
                this.address.setStreetAddress(value);
                break;
            case "cityaddress":
                this.address.setCityAddress(value);
                break;
            case "state":
                this.address.setState(value);
                break;
            case "zipcode":
                this.address.setZipCode(value);
                break;
            case "phone":
                this.setPhone(value);
                break;
            case "email":
                this.setEmail(value);
                break;
            default:
                throw new UnsupportedOperationException("Unimplemented method 'setValue'");

        }

    }
    
    /**
     * setter for Email
     * @param value
     */
    private void setEmail(String value) {
        this.email = value;
    }
    /**
     * setter for phone
     * @param value
     */
    private void setPhone(String value) {
        this.phone = value;
    }


    /**
     * Compares this contact to another contact to determine if the two are equal.
     * @return True if the two co
     */
    public Boolean equals(Contact other){
        return (this.person.getFirst() == other.person.getFirst() &&
                this.person.getLast() == other.person.getLast() &&
                this.person.getStatus() == other.person.getStatus() &&
                this.address.getStreetAddress() == other.address.getStreetAddress() &&
                this.address.getCityAddress() == other.address.getCityAddress() &&
                this.address.getState() == other.address.getState() &&
                this.address.getZipCode() == other.address.getZipCode() &&
                this.phone == other.phone &&
                this.email == other.email);
    }
}
//End