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
        Address(String streetAddress, String cityAddress, String state, String zipCode){
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
    }

    /**
    * Check to see if a record has an attribute. Should not be case sensitive.
    * @param attribute possible attribute within a record.
    * @return true if the value is contained in the object, false otherwise.
    */
    @Override
    public boolean exists(String attribute) {
        
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    /**
    * Check to see if a record has an attribute containing a specific value. Should not be case sensitive.
    * @param attribute possible attribute within a record.
    * @param value desired value of the attribute.
    * @return true if the value is contained in the object, false otherwise.
    * @throws IllegalArgumentException if the attribute is invalid.
    */
    @Override
    public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasValue'");
    }

    /**
    * Change the value of a specific attribute.
    * @param attribute possible attribute within a record.
    * @param value new value of the attribute.
    * @throws IllegalArgumentException if the attribute is invalid.
    */
    @Override
    public void setValue(String attribute, String value) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setValue'");
    }
}
//End