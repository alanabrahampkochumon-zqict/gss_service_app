package org.grandstrandsystems;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the storage and manipulation of Contact objects.
 * <p>
 * This service uses an in-memory data structure (HashMap) to store contacts.
 * It provides functionality to add, delete, and update contacts, enforcing
 * uniqueness based on the Contact ID.
 * </p>
 *
 * @author Alan Abraham
 * @version 1.0
 * @since 01/06/2026
 */
public class ContactService {

    // In-memory storage for contacts. Key is the Contact ID.
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     * <p>
     * Ensures that the contact ID is unique before adding.
     * </p>
     *
     * @param contact The Contact object to be added.
     * @throws IllegalArgumentException if the contact is null or if a contact with the same ID already exists.
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        if (contacts.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getId(), contact);
    }

    /**
     * Deletes a contact by its ID.
     *
     * @param id The unique ID of the contact to delete.
     * @return {@code true} if the contact was found and deleted; {@code false} otherwise.
     */
    public boolean deleteContact(String id) {
        return contacts.remove(id) != null;
    }

    /**
     * Updates the first name of an existing contact.
     *
     * @param id        The unique ID of the contact to update.
     * @param firstName The new first name (must validate against Contact rules).
     * @throws IllegalArgumentException if the contact ID is not found.
     */
    public void updateFirstName(String id, String firstName) {
        Contact contact = getContactOrThrow(id);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of an existing contact.
     *
     * @param id       The unique ID of the contact to update.
     * @param lastName The new last name (must validate against Contact rules).
     * @throws IllegalArgumentException if the contact ID is not found.
     */
    public void updateLastName(String id, String lastName) {
        Contact contact = getContactOrThrow(id);
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of an existing contact.
     *
     * @param id          The unique ID of the contact to update.
     * @param phoneNumber The new phone number (must validate against Contact rules).
     * @throws IllegalArgumentException if the contact ID is not found.
     */
    public void updatePhoneNumber(String id, String phoneNumber) {
        Contact contact = getContactOrThrow(id);
        contact.setPhoneNumber(phoneNumber);
    }

    /**
     * Updates the address of an existing contact.
     *
     * @param id      The unique ID of the contact to update.
     * @param address The new address (must validate against Contact rules).
     * @throws IllegalArgumentException if the contact ID is not found.
     */
    public void updateAddress(String id, String address) {
        Contact contact = getContactOrThrow(id);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact by its ID.
     * <p>
     * This method is package-private to facilitate testing and internal usage.
     * </p>
     *
     * @param id The unique ID of the contact.
     * @return The Contact object if found, or null if not found.
     */
    Contact getContact(String id) {
        return contacts.get(id);
    }

    /**
     * Helper method to retrieve a contact or throw an exception if not found.
     * This reduces code duplication in the update methods.
     *
     * @param id The contact ID.
     * @return The Contact object.
     * @throws IllegalArgumentException if the contact does not exist.
     */
    private Contact getContactOrThrow(String id) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        return contact;
    }
}