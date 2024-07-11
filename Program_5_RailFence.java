import java.util.*;

public class Program_5_RailFence {

    public static String encrypt(String text, int key) {
        char rail[][] = new char[key][text.length()];

        for (int i = 0; i < key; i++) {
            Arrays.fill(rail[i], '\n');
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < text.length(); i++) {
            if (row == 0 || row == key - 1) {
                dirDown = !dirDown;
            }

            rail[row][col++] = text.charAt(i);

            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (rail[i][j] != '\n') {
                    res.append(rail[i][j]);
                }
            }
        }
        return res.toString();
    }

    public static String decrypt(String cipher, int key) {
        char rail[][] = new char[key][cipher.length()];

        for (int i = 0; i < key; i++) {
            Arrays.fill(rail[i], '\n');
        }

        boolean dirDown = false;
        int row = 0, col = 0;

        for (int i = 0; i < cipher.length(); i++) {
            if (row == 0 || row == key - 1) {
                dirDown = !dirDown;
            }

            rail[row][col++] = '*';

            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }

        int index = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < cipher.length(); j++) {
                if (rail[i][j] == '*' && index < cipher.length()) {
                    rail[i][j] = cipher.charAt(index++);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        row = 0;
        col = 0;
        for (int i = 0; i < cipher.length(); i++) {
            if (row == 0 || row == key - 1) {
                dirDown = !dirDown;
            }

            if (rail[row][col] != '\n') {
                res.append(rail[row][col++]);
            }

            if (dirDown) {
                row++;
            } else {
                row--;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to be encrypted: ");
        String text = sc.nextLine();
        System.out.println("Enter the key: ");
        int key = sc.nextInt();

        String encryptedText = encrypt(text, key);
        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted text: " + decryptedText);

        sc.close();
    }
}
