package com.example.validationModules.Validators;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EmailValidator {
    public boolean isValidEmail(String email) {
        // string of allowed chars must be distinct
        String invalidChars = "?,;|[]=#$%^&*~_/` ";
        if(!email.contains("@"))
            return false;
        if(!checkInvalidSymbols(email,invalidChars))
            return false;
        // pinging host to see if it's a valid host
        if(!pingHost(email.substring(email.indexOf('@')+1),80,500))
            return false;
        return true;
    }
    // true if it's correct
    private boolean checkInvalidSymbols(String email, String invalidChars)
    {
        char prev;
        char curr;
        int atSignCounter = 0;
        for(int i=0;i<email.length();i++)
        {
            curr = email.charAt(i);
            if(curr == '@')
                atSignCounter++;
            if(atSignCounter>1)
                return false;
            // first char can't be a dot
            if(i==0 && curr == '.')
                return false;
            //check against invalid char list
            if(invalidChars.indexOf(email.charAt(i)) != -1)
                return false;
            // dot logic
            // dots are allowed but can't be consecutive
            // dots can't be the first or the last symbol
            if(i>0) {
                prev = email.charAt(i - 1);
                if(curr == '@' && prev == '.')
                    return false;
                if (prev == '.' && curr == '.') {
                    return false;
                }
            }

        }
        return true;
    }
    public static boolean pingHost(String host, int port, int timeout) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            return true;
        } catch (IOException e) {
            return false; // Either timeout or unreachable or failed DNS lookup.
        }
    }

}
