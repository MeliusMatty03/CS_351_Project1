/**
 * Matthew El
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

//...
/**
 * 
 */
protected class Address{ //Changed to protected so subclasses could access it.
    private String streetAddress;
    private String cityAddress;
    private String state;
    private String zipCode;

    Address(String streetAddress, String cityAddress, String state, String zipCode){
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.state = state;
        this.zipCode = zipCode;
    }
}
@Override
public boolean exists(String attribute) {
    
    throw new UnsupportedOperationException("Unimplemented method 'exists'");
}
@Override
public boolean hasValue(String attribute, String value) throws IllegalArgumentException {
    
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'hasValue'");
}
@Override
public void setValue(String attribute, String value) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setValue'");
}
}