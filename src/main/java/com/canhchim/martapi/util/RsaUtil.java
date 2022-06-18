package com.canhchim.martapi.util;

import com.canhchim.martapi.dto.RSADto;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public final class RsaUtil {
    private PublicKey publicKey;
    private PrivateKey privateKey;


    public static RSADto generate() throws NoSuchAlgorithmException {
        //Tạo cặp khóa RSA
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair pair = generator.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        RSADto rsaDto = new RSADto();
        rsaDto.setPrivateKey(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        rsaDto.setPublicKey(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        return rsaDto;
    }

    public static String encrypt(String publicKey, String message) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //Convert publicKey từ String sang byte[]
        byte[] pbKeyBytes = Base64.getDecoder().decode(publicKey);
        //Tạo đối tượng PublicKey từ byte[]
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(pbKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("rsa");
        PublicKey pbKey = keyFactory.generatePublic(keySpec);
        //Tạo đối tượng Cipher từ publicKey
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, pbKey);
        //Mã hóa
        byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(messageBytes);
        return Base64.getEncoder().encodeToString(encryptedMessageBytes);
    }

    public static String decrypt(String privateKey, String message) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //Convert privateKey từ String sang byte[]
        byte[] pvKeyBytes = Base64.getDecoder().decode(privateKey);
        //Tạo đối tượng PrivateKey từ byte[]
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec (pvKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("rsa");
        PrivateKey pvKey = keyFactory.generatePrivate(keySpec);
        //Tạo đối tượng Cipher từ privateKey
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.DECRYPT_MODE, pvKey);
        //Mã hóa
        byte[] messageBytes = Base64.getDecoder().decode(message);
        byte[] decryptedMessageBytes = encryptCipher.doFinal(messageBytes);
        String decryptedMessage = new String(decryptedMessageBytes, StandardCharsets.UTF_8);
        return decryptedMessage;
    }
}
