package Ext;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to be encrypted: ");
        String text = sc.nextLine();
        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        System.out.println("Encrypted text: " + encrypt(text, key));
        sc.close();
    }
}
