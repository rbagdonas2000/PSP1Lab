package com.company;

public class EmailValidator {

    public boolean ContainsAtSymbol(String email){
        return false;
    }

    public boolean ContainsForbiddenSymbols(String email){
        return false;
    }

    public boolean HasGoodDomainName(String email){
        return false;
    }

    public boolean HasGoodTLD(String email){
        return false;
    }
}
