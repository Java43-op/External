package Ext;

import java.util.Arrays;

class Program_3_HillCipher {
    // Following function generates the key matrix for the key string
    static void getKeyMatrix(String key, int keyMatrix[][]) {
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    // Following function encrypts the message
    static void encrypt(int cipherMatrix[][], int keyMatrix[][], int messageVector[][]) {
        int x, i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                cipherMatrix[i][j] = 0;
                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];
                }
                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }

    // Following function decrypts the message
    static void decrypt(int plainMatrix[][], int inverseKeyMatrix[][], int cipherMatrix[][]) {
        int x, i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {
                plainMatrix[i][j] = 0;
                for (x = 0; x < 3; x++) {
                    plainMatrix[i][j] += inverseKeyMatrix[i][x] * cipherMatrix[x][j];
                }
                plainMatrix[i][j] = plainMatrix[i][j] % 26;
            }
        }
    }

    // Function to compute the inverse of the key matrix
    static boolean getKeyMatrixInverse(int keyMatrix[][], int inverseKeyMatrix[][]) {
        int determinant = 0;
        for (int i = 0; i < 3; i++)
            determinant = determinant + (keyMatrix[0][i] * (keyMatrix[1][(i + 1) % 3] * keyMatrix[2][(i + 2) % 3]
                    - keyMatrix[1][(i + 2) % 3] * keyMatrix[2][(i + 1) % 3]));

        determinant = determinant % 26;
        if (determinant < 0)
            determinant += 26;

        // Compute modular multiplicative inverse of determinant modulo 26
        int determinantInverse = -1;
        for (int i = 0; i < 26; i++) {
            if ((determinant * i) % 26 == 1) {
                determinantInverse = i;
                break;
            }
        }

        if (determinantInverse == -1)
            return false;

        int adj[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                adj[j][i] = (keyMatrix[(i + 1) % 3][(j + 1) % 3] * keyMatrix[(i + 2) % 3][(j + 2) % 3]
                        - keyMatrix[(i + 1) % 3][(j + 2) % 3] * keyMatrix[(i + 2) % 3][(j + 1) % 3]);
                adj[j][i] = adj[j][i] % 26;
                if (adj[j][i] < 0)
                    adj[j][i] += 26;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverseKeyMatrix[i][j] = (adj[i][j] * determinantInverse) % 26;
            }
        }

        return true;
    }

    // Function to implement Hill Cipher encryption
    static void HillCipherEncrypt(String message, String key) {
        int[][] keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);

        int[][] messageVector = new int[3][1];
        for (int i = 0; i < 3; i++)
            messageVector[i][0] = (message.charAt(i)) % 65;

        int[][] cipherMatrix = new int[3][1];
        encrypt(cipherMatrix, keyMatrix, messageVector);

        StringBuilder CipherText = new StringBuilder();
        for (int i = 0; i < 3; i++)
            CipherText.append((char) (cipherMatrix[i][0] + 65));

        System.out.println("Ciphertext: " + CipherText);
    }

    // Function to implement Hill Cipher decryption
    static void HillCipherDecrypt(String cipher, String key) {
        int[][] keyMatrix = new int[3][3];
        getKeyMatrix(key, keyMatrix);

        int[][] inverseKeyMatrix = new int[3][3];
        if (!getKeyMatrixInverse(keyMatrix, inverseKeyMatrix)) {
            System.out.println("Key matrix is not invertible, decryption failed.");
            return;
        }

        int[][] cipherMatrix = new int[3][1];
        for (int i = 0; i < 3; i++)
            cipherMatrix[i][0] = (cipher.charAt(i)) % 65;

        int[][] plainMatrix = new int[3][1];
        decrypt(plainMatrix, inverseKeyMatrix, cipherMatrix);

        StringBuilder PlainText = new StringBuilder();
        for (int i = 0; i < 3; i++)
            PlainText.append((char) (plainMatrix[i][0] + 65));

        System.out.println("Plaintext: " + PlainText);
    }

    // Driver code
    public static void main(String[] args) {
        // Get the message to be encrypted
        String message = "ACT";

        // Get the key
        String key = "GYBNQKURP";

        HillCipherEncrypt(message, key);

        // Assuming the ciphertext obtained is "POH"
        String cipher = "POH";
        HillCipherDecrypt(cipher, key);
    }
}
