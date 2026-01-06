package org.grandstrandsystems;

import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    private static Contact contact;

    private static String validFirstName = "";
    private static String longFirstName = "";

    private static String[] validLastNames = {"Last Name", "Last"};
    private static String[] invalidLastName = {"InvalidLastName"};

    private static String[] validPhoneNumbers = {"7773167773", "123457890", "9881281238"};
    private static String[] invalidPhoneNumbers = {"1234", "8", "12341234111", "98881888888"};

    @BeforeAll
    static void setUp() {
        contact = new Contact();
    }
}