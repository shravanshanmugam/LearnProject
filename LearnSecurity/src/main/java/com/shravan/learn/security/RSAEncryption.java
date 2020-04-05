package com.shravan.learn.security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.Arrays;

public class RSAEncryption {
    public static void main(String[] args) throws Exception {
        encryptAsymmetricKey();
        signAMessage();
    }

    private static void signAMessage() throws Exception {
        String secretMessage = "This is a secret message";
        KeyPair keyPair = generateRSAKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        byte[] messageBytes = secretMessage.getBytes();

        byte[] signatureBytes = signMessage(privateKey, messageBytes);
        boolean verified = verifySignature(publicKey, messageBytes, signatureBytes);
        System.out.println(verified);
    }

    private static boolean verifySignature(PublicKey publicKey, byte[] messageBytes, byte[] signatureBytes) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(messageBytes);
        return signature.verify(signatureBytes);
    }

    private static byte[] signMessage(PrivateKey privateKey, byte[] messageBytes) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(messageBytes);
        return signature.sign();
    }


    private static void encryptAsymmetricKey() throws Exception {
        KeyPair keyPair = generateRSAKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        byte[] encryptedKey = encryptWithRSA(publicKey, secretKey);
        byte[] decryptedKey = decryptWithRSA(privateKey, encryptedKey);
        System.out.println(Arrays.compare(decryptedKey, secretKey.getEncoded()));
    }

    private static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private static byte[] decryptWithRSA(PrivateKey privateKey, byte[] encryptedKey) throws Exception {
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
        return rsaCipher.doFinal(encryptedKey);
    }

    private static byte[] encryptWithRSA(PublicKey publicKey, SecretKey secretKey) throws Exception {
        Cipher rsaCipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return rsaCipher.doFinal(secretKey.getEncoded());
    }
}
