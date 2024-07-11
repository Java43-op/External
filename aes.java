import javax.crypto.*;
import java.util.*;

public class aes {
    public static void main(String[] args) throws Exception {
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        Cipher enCipher = Cipher.getInstance("AES");
        enCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String s = "Hello";
        byte[] enbytes = enCipher.doFinal(s.getBytes());
        String encryptedString = Base64.getEncoder().encodeToString(enbytes);
        System.out.println(encryptedString);
        Cipher dCipher = Cipher.getInstance("AES");
        dCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] deciphered = dCipher.doFinal(Base64.getDecoder().decode(encryptedString));
        System.out.println(new String(deciphered));
    }
}
