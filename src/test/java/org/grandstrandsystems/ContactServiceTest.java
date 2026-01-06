package org.grandstrandsystems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    @Tag("AddContact")
    void addContact_withCorrectInformation_addsContact() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        Contact retrievedContact = service.getContact(contact.getId());
        assertContactEquals(contact, retrievedContact);
    }

    @Test
    @Tag("AddContact")
    void addContact_duplicateID_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    @Tag("AddContact")
    void addContact_nullContact_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    @Tag("DeleteContact")
    void deleteContact_existingContact_deletesSuccessfully() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        Contact retrievedContact = service.getContact(contact.getId());
        assertContactEquals(contact, retrievedContact);

        assertTrue(service.deleteContact(contact.getId()));
        retrievedContact = service.getContact(contact.getId());
        assertNull(retrievedContact);
    }

    @Test
    @Tag("DeleteContact")
    void deleteContact_emptyContactList_doNotDeleteContact() {
        assertFalse(service.deleteContact("005"));
    }

    @Test
    @Tag("DeleteContact")
    void deleteContact_invalidID_doNotDeleteContact() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);

        assertFalse(service.deleteContact("005"));
    }

    @Test
    @Tag("UpdateContact")
    void updateFirstName_validFirstName_updatesContact() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");

        String updatedName = "New Name";

        service.addContact(contact);
        Contact retrievedContact = service.getContact(contact.getId());
        assertContactEquals(contact, retrievedContact);

        service.updateFirstName(retrievedContact.getId(), updatedName);
        retrievedContact = service.getContact(retrievedContact.getId());
        assertEquals(updatedName, retrievedContact.getFirstName());
    }

    @Test
    @Tag("UpdateContact")
    void updateFirstName_invalidID_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedName = "New Name";
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("0005", updatedName));
    }

    @Test
    @Tag("UpdateContact")
    void updateFirstName_invalidFirstName_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedName = "New Name".repeat(Contact.LAST_NAME_MAX_LENGTH / 8 + 1);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName(contact.getId(), updatedName));
    }

    @Test
    @Tag("UpdateContact")
    void updateLastName_validLastName_updatesContact() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");

        String updatedName = "New Name";

        service.addContact(contact);
        Contact retrievedContact = service.getContact(contact.getId());
        assertContactEquals(contact, retrievedContact);

        service.updateLastName(retrievedContact.getId(), updatedName);
        retrievedContact = service.getContact(retrievedContact.getId());
        assertEquals(updatedName, retrievedContact.getLastName());
    }

    @Test
    @Tag("UpdateContact")
    void updateLastName_invalidID_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedName = "New Name";
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("0005", updatedName));
    }

    @Test
    @Tag("UpdateContact")
    void updateLastName_invalidLastName_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedName = "New Name".repeat(Contact.LAST_NAME_MAX_LENGTH / 8 + 1);
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName(contact.getId(), updatedName));
    }

    @Test
    @Tag("UpdateContact")
    void updatePhoneNumber_validPhoneNumber_updatesContact() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");

        String updatedNumber = "0987654321";

        service.addContact(contact);
        Contact retrievedContact = service.getContact(contact.getId());
        assertContactEquals(contact, retrievedContact);

        service.updatePhoneNumber(retrievedContact.getId(), updatedNumber);
        retrievedContact = service.getContact(retrievedContact.getId());
        assertEquals(updatedNumber, retrievedContact.getPhoneNumber());
    }

    @Test
    @Tag("UpdateContact")
    void updatePhoneNumber_invalidID_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedNumber = "0987654321";
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber("0005", updatedNumber));
    }

    @Test
    @Tag("UpdateContact")
    void updatePhoneNumber_invalidPhoneNumber_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedNumber = "098765432a";
        assertThrows(IllegalArgumentException.class, () -> service.updatePhoneNumber(contact.getId(), updatedNumber));
    }

    @Test
    @Tag("UpdateContact")
    void updateAddress_validAddress_updatesContact() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");

        String updatedAddress = "New Address";

        service.addContact(contact);
        Contact retrievedContact = service.getContact(contact.getId());
        assertContactEquals(contact, retrievedContact);

        service.updateAddress(retrievedContact.getId(), updatedAddress);
        retrievedContact = service.getContact(retrievedContact.getId());
        assertEquals(updatedAddress, retrievedContact.getAddress());
    }

    @Test
    @Tag("UpdateContact")
    void updateAddress_invalidID_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedAddress = "New Address";
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("0005", updatedAddress));
    }

    @Test
    @Tag("UpdateContact")
    void updateAddress_invalidAddress_throwsException() {
        Contact contact = new Contact("001", "First Name", "Last Name", "1234567890", "Some Address");
        service.addContact(contact);
        String updatedAddress = "Address".repeat(Contact.ADDRESS_MAX_LENGTH/7 + 1);
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress(contact.getId(), updatedAddress));
    }

    private void assertContactEquals(Contact expected, Contact actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getFirstName(), actual.getFirstName());
        assertEquals(expected.getLastName(), actual.getLastName());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getAddress(), actual.getAddress());
    }
}