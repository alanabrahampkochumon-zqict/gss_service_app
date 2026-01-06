package org.grandstrandsystems;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private static Contact contact;

    private static String validFirstName = "";
    private static String longFirstName = "";

    private static String[] validLastNames = {"Last Name", "Last"};
    private static String[] invalidLastName = {"InvalidLastName"};

    private static String[] validPhoneNumbers = {"7773167773", "123457890", "9881281238"};
    private static String[] invalidPhoneNumbers = {"1234", "8", "12341234111", "98881888888"};


    @Test
    @Tag("FirstName")
     void firstName_oneCharacterAboveLimit_throwsException() {
        StringBuilder firstName = new StringBuilder();
        byte limit = Contact.FIRST_NAME_MAX_LENGTH + 1;
        for (byte i = 0; i < limit; i++) {
            firstName.append("a");
        }
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", firstName.toString(), "Last Name", "1234567890", "Some Address");
        });
    }

    @Test
    @Tag("FirstName")
    void firstName_veryLong_throwsException() {
        StringBuilder firstName = new StringBuilder();
        Random random = new Random();
        int limit = Contact.FIRST_NAME_MAX_LENGTH + random.nextInt(100) + 10; // Exceeds the string limit from 10 to 110
        for (byte i = 0; i < limit; i++) {
            firstName.append("a");
        }
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", firstName.toString(), "Last Name", "1234567890", "Some Address");
        });
    }

    @Test
    @Tag("FirstName")
    void firstName_inLimit_createsObjectWithCorrectFirstName() {
        String[] validFirstNames = {"a", "first name", "FirstName", "First Name"};
        for(String firstName: validFirstNames) {
            Contact contact = new Contact("001", firstName, "Last Name", "1234567890", "Some Address");
            assertEquals(firstName, contact.getFirstName());
        }
    }

    @Test
    @Tag("LastName")
    void lastName_oneCharacterAboveLimit_throwsException() {
        StringBuilder lastName = new StringBuilder();
        byte limit = Contact.LAST_NAME_MAX_LENGTH + 1;
        for (byte i = 0; i < limit; i++) {
            lastName.append("a");
        }
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "First Name", lastName.toString(), "1234567890", "Some Address");
        });
    }

    @Test
    @Tag("LastName")
    void lastName_veryLong_throwsException() {
        StringBuilder lastName = new StringBuilder();
        Random random = new Random();
        int limit = Contact.LAST_NAME_MAX_LENGTH + random.nextInt(100) + 10; // Exceeds the string limit from 10 to 110
        for (byte i = 0; i < limit; i++) {
            lastName.append("a");
        }
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", "First Name", lastName.toString(), "1234567890", "Some Address");
        });
    }

    @Test
    @Tag("LastName")
    void lastName_inLimit_createsObjectWithCorrectLastName() {
        String[] validLastNames = {"a", "last name0", "LastName0", "Last Name0"};
        for(String lastName: validLastNames) {
            Contact contact = new Contact("001", "First Name", lastName, "1234567890", "Some Address");
            assertEquals(lastName, contact.getLastName());
        }
    }

    @Test
    @Tag("PhoneNumber")
    void phoneNumber_greaterThanLimit_throwsException() {
        StringBuilder phoneNumber = new StringBuilder();
        Random random = new Random();
        int limit = random.nextInt(25) + Contact.PHONE_NUMBER_MAX_LENGTH + 1; // Bound between 1 and 26 character above phone limit
        phoneNumber.append("0".repeat(limit));
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "First Name", "Last Name", phoneNumber.toString(), "Some Address"));

    }

    @Test
    @Tag("PhoneNumber")
    void phoneNumber_lessThanLimit_throwsException() {
        StringBuilder phoneNumber = new StringBuilder();
        Random random = new Random();
        int limit = random.nextInt(Contact.PHONE_NUMBER_MAX_LENGTH - 1); // Bound between 0 and PHONE_NUMBER_MAX_LENGTH - 1
        phoneNumber.append("0".repeat(limit));
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "First Name", "Last Name", phoneNumber.toString(), "Some Address"));
    }

    @Test
    @Tag("PhoneNumber")
    void phoneNumber_inLimit_createsObjectWithCorrectPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder();
        phoneNumber.append("0".repeat(Contact.PHONE_NUMBER_MAX_LENGTH));
        Contact contact = new Contact("001", "First Name", "Last Name", phoneNumber.toString(), "Some Address");
        assertEquals(phoneNumber.toString(), contact.getPhoneNumber());
    }

    @Test
    @Tag("Address")
    void address_greaterThanLimit_throwsException() {
        StringBuilder addresss = new StringBuilder();
        Random random = new Random();
        int limit = random.nextInt(25) + Contact.ADDRESS_MAX_LENGTH + 1; // Bound between 1 and 26 character above address limit
        addresss.append("a".repeat(limit));
        assertThrows(IllegalArgumentException.class, () -> new Contact("001", "First Name", "Last Name","1234567890", addresss.toString() ));

    }

    @Test
    @Tag("Address")
    void address_inLimit_createsObjectWithCorrectAddress() {
        StringBuilder address = new StringBuilder();
        Random random = new Random();
        int limit = random.nextInt(Contact.ADDRESS_MAX_LENGTH); // Bound between 0 and ADDRESS_MAX_LENGTH - 1
        address.append("a".repeat(limit));
        Contact contact = new Contact("001", "First Name", "Last Name","1234567890", address.toString());
        assertEquals(address.toString(), contact.getAddress());
    }

    @Test
    @Tag("ID")
    void id_greaterThanLimit_throwsException() {
        StringBuilder id = new StringBuilder();
        Random random = new Random();
        int limit = random.nextInt(25) + Contact.ID_MAX_LENGTH + 1; // Bound between 1 and 26 character above address limit
        id.append("0".repeat(limit));
        assertThrows(IllegalArgumentException.class, () -> new Contact(id.toString(), "First Name", "Last Name","1234567890", "Some Address"));

    }

    @Test
    @Tag("ID")
    void id_inLimit_createsObjectWithCorrectID() {
        StringBuilder id = new StringBuilder();
        Random random = new Random();
        int limit = random.nextInt(Contact.ID_MAX_LENGTH); // Bound between 0 and ADDRESS_MAX_LENGTH - 1
        id.append("0".repeat(limit));
        Contact contact = new Contact(id.toString(), "First Name", "Last Name","1234567890", "Some Address");
        assertEquals(id.toString(), contact.getId());
    }

    @Test
    @Tag("ID")
    void id_mutatedAfterInstantiation_throwsException() {
        String oldId = "000001";
        String newId = "000001";
        Contact contact = new Contact(oldId, "First Name", "Last Name","1234567890", "Some Address");

        assertEquals(oldId, contact.getId());

        assertThrows(IllegalArgumentException.class, () -> contact.setId(newId));
    }

}