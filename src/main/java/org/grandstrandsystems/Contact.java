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

    private static final byte ID_MAX_LENGTH = 10;
    private static final byte FIRST_NAME_MAX_LENGTH = 10;
    private static final byte LAST_NAME_MAX_LENGTH = 10;
    private static final byte PHONE_NUMBER_MAX_LENGTH = 10;
    private static final byte ADDRESS_MAX_LENGTH = 30;


    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
}
