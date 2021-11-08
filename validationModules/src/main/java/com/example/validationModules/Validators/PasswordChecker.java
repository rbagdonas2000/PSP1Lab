package com.example.validationModules.Validators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PasswordChecker {
    public boolean isValidPassowrd(String password) {
        // reading SpecialSymbols.txt
        String specialChars = null;
        try {
            specialChars = readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // minimum password length tests are made for 7, but 8 is a bit more secure
        int minLength = 7;
        if(password.length()<minLength)
            return false;
        if(!checkUppercase(password))
            return false;
        if(!checkSpecialChars(password,specialChars))
            return false;
        return true;
    }
    private boolean checkUppercase(String password) {
        for(int i=0;i < password.length();i++) {
            if(Character.isUpperCase(password.charAt(i)))
                return true;
        }
        return false;
    }
    private boolean checkSpecialChars(String password, String specialChars){
        for(int i=0;i < password.length();i++) {
            if(specialChars.indexOf(password.charAt(i)) != -1)
                return true;
        }
        return false;
    }
    private String readFile()
        // SpecialSymbols.txt must be a single string in a single line
            throws IOException {
        Path path = Paths.get("D:\\UnitTests1lab\\validationModules\\src\\main\\resources\\SpecialSymbols.txt");
        return Files.readAllLines(path).get(0);
    }
}