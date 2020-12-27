package com.webshop.sportnutrition.dataAccess.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CryptPassword {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String crypt (String mdp) {
        return bCryptPasswordEncoder.encode(mdp);
    }
}
