import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Aes {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------");

        // AES 128
        printResultOfAes("1234567890123456");
        System.out.println("----------------------------------------------");

        // AES 192
        printResultOfAes("123456789012345678901234");
        System.out.println("---------------------------------------------");

        // AES 256
        printResultOfAes("12345678901234567890123456789012");
        System.out.println("----------------------------------------------");

    }

    private static String encrypt(String plainText, byte[] key) {
        assert (key.length == 16 || key.length == 24 || key.length == 32);

        try {
            // 바이트 단위 연산을 위해 plainText를 바이트 데이터로 변환
            byte[] plainTextInBytes = plainText.getBytes(StandardCharsets.UTF_8);
            // AES의 key 값을 key로 설정
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            // CBC 블록 암호 운용 방식(block cipher mode)과 PKCS5 패팅 방식으로 AES를 사용한다는 뜻
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // secretKey와 초기화 벡터를 사용해 암호화 모드로 cipher를 초기화
            /* IV(벡터) : 암호문에 무작위성을 추가하는 랜덤 데이터.
             * 여기에서는 상수이지만 실제 프로그램에서는 이 값을 랜덤하게 만들어야 함...
            */
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));
            byte[] encrypted = cipher.doFinal(plainTextInBytes);
            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e); 
        }
    }

    // 암호화의 역과정
    private static String decrypt(String cipherText, byte[] key) {
        assert (key.length == 16 || key.length == 24 || key.length == 32);

        try {
            byte[] encrypted = Base64.getDecoder().decode(cipherText);
            SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // encryption에서 사용했던 IV를 똑같이 사용해야 한다.
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(new byte[16]));

            byte[] plainText = cipher.doFinal(encrypted);

            return new String(plainText, StandardCharsets.UTF_8);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static void printResultOfAes(String key) {
        String plainText = "My message";
        String longPlainText = "My longer message";

        byte[] keyInBytes = key.getBytes(StandardCharsets.US_ASCII);

        String cipherText = encrypt(plainText, keyInBytes);
        String longCipherText = encrypt(longPlainText, keyInBytes);
        System.out.println("*** Cipher Text ***");
        System.out.println(cipherText);
        System.out.println(longCipherText);

        String decryptedText = decrypt(cipherText, keyInBytes);
        String longDecryptedText = decrypt(longCipherText, keyInBytes);
        System.out.println("*** Decrypted Text ***");
        System.out.println(decryptedText);
        System.out.println(longDecryptedText);
    }
}
