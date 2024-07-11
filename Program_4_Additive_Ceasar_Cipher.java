package Ext;

public class Program_4_Additive_Ceasar_Cipher {

    // Encrypts text using a shift (Additive Cipher)
    public static String encryptAdditiveCipher(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isUpperCase(ch)) {
                char encryptedChar = (char) (((int) ch + shift - 65) % 26 + 65);
                result.append(encryptedChar);
            } else if (Character.isLowerCase(ch)) {
                char encryptedChar = (char) (((int) ch + shift - 97) % 26 + 97);
                result.append(encryptedChar);
            } else {
                result.append(ch); // Non-alphabetical characters remain unchanged
            }
        }

        return result.toString();
    }

    // Decrypts text using a shift (Additive Cipher)
    public static String decryptAdditiveCipher(String text, int shift) {
        return encryptAdditiveCipher(text, 26 - shift);
    }

    // Encrypts text using Caesar Cipher (shift of 3)
    public static String encryptCaesarCipher(String text) {
        return encryptAdditiveCipher(text, 3);
    }

    // Decrypts text using Caesar Cipher (shift of 3)
    public static String decryptCaesarCipher(String text) {
        return decryptAdditiveCipher(text, 3);
    }

    public static void main(String[] args) {
        String text = "Hello World!";
        int shift = 4;

        // Additive Cipher
        String additiveEncrypted = encryptAdditiveCipher(text, shift);
        String additiveDecrypted = decryptAdditiveCipher(additiveEncrypted, shift);

        System.out.println("Additive Cipher:");
        System.out.println("Original Text : " + text);
        System.out.println("Shift Value : " + shift);
        System.out.println("Encrypted Text: " + additiveEncrypted);
        System.out.println("Decrypted Text: " + additiveDecrypted);

        // Caesar Cipher
        String caesarEncrypted = encryptCaesarCipher(text);
        String caesarDecrypted = decryptCaesarCipher(caesarEncrypted);

        System.out.println("\nCaesar Cipher:");
        System.out.println("Original Text : " + text);
        System.out.println("Encrypted Text: " + caesarEncrypted);
        System.out.println("Decrypted Text: " + caesarDecrypted);
    }
}
