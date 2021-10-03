package com.company.implementation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdditionalValidatorTests {

    private static PhoneValidator phoneValidator;
    private static EmailValidator emailValidator;

    @BeforeAll
    static void setUp()
    {
        phoneValidator = new PhoneValidator();
        emailValidator = new EmailValidator();
    }

    @Test
    void validatePhoneNumber_numberDoesNotStartWith8orPlus_shouldReturnFalse() {
        String phoneNumber = "76623456";
        assertFalse(phoneValidator.validateLithuanianPhoneNumber(phoneNumber));
    }

    @Test
    void validateEmail_emailDoesNotHaveRecipientsName_shouldReturnFalse(){
        assertFalse(emailValidator.validateEmail("@gmail.com"));
    }

    @Test
    void validateEmail_emailDoesNotHaveValidDomainName_shouldReturnFalse(){
        assertFalse(emailValidator.validateEmail("rokas@gm*il.com"));
    }

    @Test
    void validateEmail_emailsDomainNameStartsWithDash_shouldReturnFalse(){
        assertFalse(emailValidator.validateEmail("rokas@-gmail.com"));
    }

    @Test
    void validateEmail_emailsDomainNameIsEmpty_shouldReturnFalse(){
        assertFalse(emailValidator.validateEmail("rokas@.com"));
    }
}
