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


    @Tag("First Name Tests")
    @Test
     void firstName_oneCharacterAboveLimit_ThrowsException() {
        StringBuilder firstName = new StringBuilder();
        byte limit = Contact.FIRST_NAME_MAX_LENGTH + 1;
        for (byte i = 0; i < limit; i++) {
            firstName.append("a");
        }
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("001", firstName.toString(), "Last Name", "1234567890", "Some Address");
        });
    }

    @Tag("First Name Tests")
    @Test
    void firstName_veryLong_ThrowsException() {
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

    @Tag("First Name Tests")
    @Test
    void firstName_inLimit_ThrowsException() {
        String[] validFirstNames = {"a", "first name", "FirstName", "First Name"};
        for(String firstName: validFirstNames) {
            Contact contact = new Contact("001", firstName, "Last Name", "123467890", "Some Address");
            assertEquals(firstName, contact.getFirstName());
        }
    }
}