public class Contact implements ContactInterface, Cloneable {
private PersonalInfo person;   // Personal information
//private Address address;       // Current address
private String phone;          // Phone number
private String email;          // Email  
//...
@Override
public boolean exists(String attribute) {
    // TODO Auto-generated method stub
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