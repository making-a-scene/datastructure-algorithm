import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class Rsa {
    public static void main(String args[]) {
        KeyPair keyPair = getKeyPair();

        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        System.out.println("Public key: " + publicKey.toString() + "\n");
        System.out.println("Private key: " + privateKey.toString() + "\n");

        String plaintext = "My love letter";
        String ciphertext = encrypt(plaintext, publicKey);
        System.out.println("Ciphertext: " + ciphertext + "\n");

        String actualPlaintext = decrypt(ciphertext, privateKey);
        System.out.println("Actual plaintext: " + actualPlaintext);
    }

    private static String encrypt(String plaintext, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] bytes = plaintext.getBytes(StandardCharsets.UTF_8);
            byte[] ciphertext = cipher.doFinal(bytes);

            return Base64.getEncoder().encodeToString(ciphertext);
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static String decrypt(String ciphertext, PrivateKey privateKey) {
        try {
            byte[] bytes = Base64.getDecoder().decode(ciphertext);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] plaintext = cipher.doFinal(bytes);

            return new String(plaintext, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static KeyPair getKeyPair() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            return generator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
