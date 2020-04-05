package com.shravan.learn.security;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESEncryption {
    /**
     * Encryption Algorithm/Operation mode/Padding - Extra bytes to fill key (Key size)
     * AES/CBC/NoPadding (128)
     * AES/CBC/PKCS5Padding (128)
     * AES/ECB/NoPadding (128)
     * AES/ECB/PKCS5Padding (128)
     * DES/CBC/NoPadding (56)
     * DES/CBC/PKCS5Padding (56)
     * DES/ECB/NoPadding (56)
     * DES/ECB/PKCS5Padding (56)
     * DESede/CBC/NoPadding (168)
     * DESede/CBC/PKCS5Padding (168)
     * DESede/ECB/NoPadding (168)
     * DESede/ECB/PKCS5Padding (168)
     * RSA/ECB/PKCS1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-1AndMGF1Padding (1024, 2048)
     * RSA/ECB/OAEPWithSHA-256AndMGF1Padding (1024, 2048)
     * </br>
     *
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/crypto/Cipher.html">Ciphers</a>
     * </br>
     * For using stronger security keys (longer key size), download JCE Unlimited Strength Jurisdiction Policy Files for JDK
     * @see <a href="https://www.oracle.com/java/technologies/javase-jce-all-downloads.html">Unlimited JCEP Files</a>
     */
    public static void main(String[] args) throws Exception {
        String secretMessage = "This is my secret message";
        SecretKey secretKey = generateAESKey();
        SecureRandom secureRandom = new SecureRandom();
        byte[] buffer = new byte[16];
        secureRandom.nextBytes(buffer);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(buffer);
        byte[] encryptedBytes = encryptWithAES(secretMessage, secretKey, ivParameterSpec);
        String decryptedMessage = decryptWithAES(encryptedBytes, secretKey, ivParameterSpec);
        System.out.println(secretMessage.equals(decryptedMessage));
    }

    private static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    private static byte[] encryptWithAES(String secretMessage, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, aesCipher);
        try (OutputStreamWriter writer = new OutputStreamWriter(cipherOutputStream)) {
            writer.write(secretMessage);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static String decryptWithAES(byte[] encryptedBytes, SecretKey secretKey, IvParameterSpec ivParameterSpec) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encryptedBytes);
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        CipherInputStream cipherInputStream = new CipherInputStream(byteArrayInputStream, aesCipher);
        InputStreamReader inputStreamReader = new InputStreamReader(cipherInputStream);
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            return bufferedReader.readLine();
        }
    }
}
