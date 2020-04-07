package com.shravan.learn.security;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Arrays;

public class PBKDF {

    public static void main(String[] args) throws Exception {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec keySpec = new PBEKeySpec("password".toCharArray(), "salt".getBytes(), 10000, 128);
        SecretKey secretKey = secretKeyFactory.generateSecret(keySpec);
        Key key = new SecretKeySpec(secretKey.getEncoded(), "AES");
        System.out.println("key.getEncoded() = " + Arrays.toString(key.getEncoded()));
    }

}
