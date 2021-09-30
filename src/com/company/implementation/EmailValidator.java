package com.company.implementation;

public class EmailValidator {
    public boolean validateEmail(String email) {
        if(email == null || email.equals("")) return false;

        int atIndex = checkAtSymbols(email);

        if(atIndex <= 0)
            return false;

        String recipientsName = email.substring(0, atIndex);
        String domainName = email.substring(atIndex + 1);



        return true;
    }
    private int checkAtSymbols(String email){
        char[] cArr = email.toCharArray();

        int counter = 0;
        int atIndex = 0;

        for(int x = 0; x < email.length(); x++){
            if(cArr[x] == '@'){
                counter++;
                atIndex = x;
            }
        }

        if(counter != 1)
            return -1;
        else
            return atIndex;
    }

    private boolean validateRecipientsName(String recipientsName){
        return true;
    }
}
