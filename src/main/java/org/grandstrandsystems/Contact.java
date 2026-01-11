package org.grandstrandsystems;

/**
 * Represents a contact within the mobile application.
 * <p>
 * This class stores contact details including a unique ID, first name, last name,
 * phone number, and address. It enforces strict data validation rules ensuring
 * no fields are null and all fields adhere to specific length constraints.
 * </p>
 *
 * @author Alan Abraham
 * @version 1.0
 * @since 01/06/2026
 */
public class Contact {

    // Constants for validation limits
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

    /**
     * Constructs a new Contact object.
     * <p>
     * All parameters are validated upon instantiation. The unique ID is immutable
     * once set during this constructor call.
     * </p>
     *
     * @param id          The unique contact ID (max 10 characters, not null, not updatable).
     * @param firstName   The contact's first name (max 10 characters, not null).
     * @param lastName    The contact's last name (max 10 characters, not null).
     * @param phoneNumber The contact's phone number (must be exactly 10 digits, not null).
     * @param address     The contact's address (max 30 characters, not null).
     * @throws IllegalArgumentException if any parameter is null or violates validation rules.
     */
    public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
        // Setters are used here to centralize validation logic
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }

    /*
     * *******************************************
     * *               GETTERS                   *
     * *******************************************
     */

    /**
     * @return The unique contact ID.
     */
    public String getId() {
        return id;
    }

    /**
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return The address.
     */
    public String getAddress() {
        return address;
    }

    /*
     * *******************************************
     * *               SETTERS                   *
     * *******************************************
     */

    /**
     * Sets the unique Contact ID.
     * <p>
     * <b>Note:</b> The ID can only be set once (during instantiation). Attempting
     * to call this method on an object that already has an ID will throw an exception.
     * </p>
     *
     * @param id The unique ID string.
     * @throws IllegalArgumentException if the ID is null, longer than 10 chars, or already set.
     */
    public void setId(String id) {
        if (id == null || id.length() > ID_MAX_LENGTH) {
            throw new IllegalArgumentException("ID cannot be null and cannot exceed " + ID_MAX_LENGTH + " characters.");
        }
        // Enforce immutability: Check if ID was already assigned
        if (this.id != null) {
            throw new IllegalArgumentException("Cannot update Contact ID; it is immutable.");
        }
        this.id = id;
    }

    /**
     * Sets the contact's first name.
     *
     * @param firstName The first name to set.
     * @throws IllegalArgumentException if firstName is null or longer than 10 chars.
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > FIRST_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("First Name cannot be null and cannot exceed " + FIRST_NAME_MAX_LENGTH + " characters.");
        }
        this.firstName = firstName;
    }

    /**
     * Sets the contact's last name.
     *
     * @param lastName The last name to set.
     * @throws IllegalArgumentException if lastName is null or longer than 10 chars.
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > LAST_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("Last Name cannot be null and cannot exceed " + LAST_NAME_MAX_LENGTH + " characters.");
        }
        this.lastName = lastName;
    }

    /**
     * Sets the contact's phone number.
     *
     * @param phoneNumber The phone number string.
     * @throws IllegalArgumentException if phoneNumber is null or does not consist of exactly 10 digits.
     */
    public void setPhoneNumber(String phoneNumber) {
        // Regex \d{10} ensures the string contains exactly 10 numeric digits
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly " + PHONE_NUMBER_MAX_LENGTH + " digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets the contact's address.
     *
     * @param address The address string.
     * @throws IllegalArgumentException if address is null or longer than 30 chars.
     */
    public void setAddress(String address) {
        if (address == null || address.length() > ADDRESS_MAX_LENGTH) {
            throw new IllegalArgumentException("Address cannot be null and cannot exceed " + ADDRESS_MAX_LENGTH + " characters.");
        }
        this.address = address;
    }
}