package Ext;

import javax.crypto.*;
import java.util.*;

public class Program_7_DES {
    public static void main(String[] args) throws Exception {
        SecretKey desKey = KeyGenerator.getInstance("DES").generateKey();
        Cipher desCipher = Cipher.getInstance("DES");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);
        System.out.println("Enter the text to be encrypted: ");
        Scanner sc = new Scanner(System.in);
        String plainText = sc.nextLine(); // Example plaintext
        sc.close();
        byte[] encryptedBytes = desCipher.doFinal(plainText.getBytes());
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Text: " + encryptedText);
        desCipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] decryptedBytes = desCipher.doFinal(Base64.getDecoder().decode(encryptedText));
        System.out.println("Decrypted Text: " + new String(decryptedBytes));
    }
}