package com.example.validationModules.Validators;

public class PhoneValidator {
    String prefix = "+370";
    int length  = 8;
    public boolean isValidPhone(String phone) {
        if(!allLegalSymbols(phone))
            return false;
        if(phone.length()<8)
            return false;
        if(phone.startsWith(prefix))
        {
            if(phone.substring(prefix.length()).length() != length)
                return false;
        }
        else if(phone.charAt(0) == '8')
        {
            if(phone.length()-1 != length)
                return false;
        }
        return true;
    }

    public String formatPhonePrefix(String phone) {
        if(isValidPhone(phone)) {
            if (phone.charAt(0) == '8')
                return prefix + phone.substring(1);
            if (phone.startsWith(prefix))
                return phone;
        }
        else
            throw new IllegalArgumentException();
        return phone;
    }

    private boolean allLegalSymbols(String phone){
        char ch;
        int plusCounter = 0;
        for(int i=0; i<phone.length();i++)
        {
            ch = phone.charAt(i);
            if(!Character.isDigit(ch))
            {
                if(ch == '+')
                    plusCounter++;
                else
                    return false;
            }
            if(plusCounter>1)
                return false;

        }
        return true;
    }
}
