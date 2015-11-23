package by.givebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by operb_000 on 23.11.2015.
 */
public class PasswordCrypto {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static PasswordCrypto instance;

    public static PasswordCrypto getInstance() {
        if(instance == null) {
            instance = new PasswordCrypto();
        }

        return instance;
    }

    public String encrypt(String str) {
        return passwordEncoder.encode(str);
    }

}
