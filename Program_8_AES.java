package Ext;

import javax.crypto.*;
import java.util.*;

public class Program_8_AES {
    public static void main(String[] args) throws Exception {
        SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();
        Cipher enCipher = Cipher.getInstance("AES");
        enCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        System.out.println("Enter the text to be encrypted: ");
        Scanner sc = new Scanner(System.in);
        String plainText = sc.nextLine();
        byte[] enbytes = enCipher.doFinal(plainText.getBytes());
        String encryptedString = Base64.getEncoder().encodeToString(enbytes);
        System.out.println(encryptedString);
        enCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] deciphered = enCipher.doFinal(Base64.getDecoder().decode(encryptedString));
        System.out.println("Decrypted String: " + new String(deciphered));
    }
}

// import javax.crypto.*;
// import javax.crypto.spec.*;
// import java.util.Base64;

// public class AES {

// public static void main(String[] args) throws Exception {
// String plainText = "Hello, World!"; // Example plaintext

// // Generate a AES key
// KeyGenerator keyGen = KeyGenerator.getInstance("AES");
// keyGen.init(128); // AES key size can be 128, 192, or 256 bits
// SecretKey aesKey = keyGen.generateKey();

// // Create a cipher instance for AES/CBC/PKCS5Padding
// Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

// // Generate Initialization Vector (IV)
// byte[] iv = new byte[aesCipher.getBlockSize()];
// SecureRandom random = new SecureRandom();
// random.nextBytes(iv);
// IvParameterSpec ivSpec = new IvParameterSpec(iv);

// // Initialize the cipher for encryption with the generated key and IV
// aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);

// // Encrypt the plaintext
// byte[] encryptedBytes = aesCipher.doFinal(plainText.getBytes());

// // Convert the IV and encrypted byte array to Base64 for easier
// display/storage
// String ivBase64 = Base64.getEncoder().encodeToString(iv);
// String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
// System.out.println("IV: " + ivBase64);
// System.out.println("Encrypted Text: " + encryptedText);

// // Initialize the cipher for decryption with the same key and IV
// aesCipher.init(Cipher.DECRYPT_MODE, aesKey, ivSpec);

// // Decrypt the encrypted text
// byte[] decryptedBytes =
// aesCipher.doFinal(Base64.getDecoder().decode(encryptedText));

// // Convert the decrypted byte array back to plaintext
// String decryptedText = new String(decryptedBytes);
// System.out.println("Decrypted Text: " + decryptedText);
// }
// }
