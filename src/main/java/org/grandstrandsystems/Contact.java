package org.grandstrandsystems;

/**
 * This class represents a user's contact.
 * Each contact have a First Name, Last Name, Phone Number, Address and a Unique ID
 * It provides constructors overloads for instantiation with all or a combination of parameters.
 *
 * @author Alan Abraham Puthenparambil Kochumon
 * @version 1.0
 * @since 01/06/2026
 */
public class Contact {

    static final byte ID_MAX_LENGTH = 10;
    static final byte FIRST_NAME_MAX_LENGTH = 10;
    static final byte LAST_NAME_MAX_LENGTH = 10;
    static final byte PHONE_NUMBER_MAX_LENGTH = 10;
    static final byte ADDRESS_MAX_LENGTH = 30;


    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;


    public Contact(String id, String firstName, String lastName, String phoneNumber, String address) throws IllegalArgumentException {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    /**
     * *******************************************
     * *               GETTERS                   *
     * *******************************************
     */

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    /**
     * *******************************************
     * *               SETTERS                   *
     * *******************************************
     */

    public void setId(String id) throws IllegalArgumentException {
        if(id.length() > ID_MAX_LENGTH)
            throw new IllegalArgumentException("ID cannot exceed " + ID_MAX_LENGTH + " character(s).");
        if (this.id != null)
            throw new IllegalArgumentException("Cannot mutate ID after instantiation.");
        this.id = id;
    }

    public void setFirstName(String firstName) throws IllegalArgumentException {
        if (firstName.length() > FIRST_NAME_MAX_LENGTH)
            throw new IllegalArgumentException("First Name cannot exceed " + FIRST_NAME_MAX_LENGTH + " character(s).");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) throws IllegalArgumentException {
        if (lastName.length() > LAST_NAME_MAX_LENGTH)
            throw new IllegalArgumentException("Last name cannot exceed " + LAST_NAME_MAX_LENGTH + " character(s).");
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        if(phoneNumber.length() > PHONE_NUMBER_MAX_LENGTH || phoneNumber.length() < PHONE_NUMBER_MAX_LENGTH)
            throw new IllegalArgumentException("Phone Number must be " + PHONE_NUMBER_MAX_LENGTH + " characters long.");
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (address.length() > ADDRESS_MAX_LENGTH)
            throw new IllegalArgumentException("Address cannot exceeed " + ADDRESS_MAX_LENGTH + " character(s).");
        this.address = address;
    }

}
