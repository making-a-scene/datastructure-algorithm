import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class User {
    private final static int SALT_LENGTH_IN_BYTES = 16;
    private final static int NUM_ITERATIONS = 10000;
    private final static int OUTPUT_KEY_LENGTH_IN_BYTES = 256 / 8;

    private final UUID id = UUID.randomUUID();
    private String email;
    private String passwordHash;

    public User(final String email, final String password) {
        this.email = email;
        setPassword(password);
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPassword(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH_IN_BYTES];
        random.nextBytes(salt);

        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(), 
                                            salt, 
                                            NUM_ITERATIONS, 
                                            OUTPUT_KEY_LENGTH_IN_BYTES * 8);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            
            byte[] hash = factory.generateSecret(spec).getEncoded();
            byte[] outputBytes = new byte[SALT_LENGTH_IN_BYTES + OUTPUT_KEY_LENGTH_IN_BYTES];
            
            System.arraycopy(salt, 0, outputBytes, 0, SALT_LENGTH_IN_BYTES);
            System.arraycopy(hash, 0, outputBytes, SALT_LENGTH_IN_BYTES, OUTPUT_KEY_LENGTH_IN_BYTES);
        
            
            this.passwordHash = Base64.getEncoder().encodeToString(outputBytes);
        
        } catch (NoSuchAlgorithmException e1) {
            throw new RuntimeException(e1);
        } catch (InvalidKeySpecException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean isValidPassword(String password) {
        byte[] outputBytes = Base64.getDecoder().decode(passwordHash);
        byte[] salt = new byte[SALT_LENGTH_IN_BYTES];
        byte[] expectedHash = new byte[OUTPUT_KEY_LENGTH_IN_BYTES];

        System.arraycopy(outputBytes, 0, salt, 0, SALT_LENGTH_IN_BYTES);
        System.arraycopy(outputBytes, SALT_LENGTH_IN_BYTES, expectedHash, 0, OUTPUT_KEY_LENGTH_IN_BYTES);

        try {
            KeySpec spec = new PBEKeySpec(password.toCharArray(),
                                            salt,
                                            NUM_ITERATIONS,
                                            OUTPUT_KEY_LENGTH_IN_BYTES * 8);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            byte[] actualHash = factory.generateSecret(spec).getEncoded();

            return Arrays.equals(expectedHash, actualHash);

        } catch (NoSuchAlgorithmException e1) {
            throw new RuntimeException(e1);
        } catch (InvalidKeySpecException e2) {
            throw new RuntimeException(e2);
        }
    }
}
