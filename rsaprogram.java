package Ext;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class rsaprogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of P: ");
        BigInteger p = sc.nextBigInteger();
        if (!p.isProbablePrime(1)) {
            System.out.println("The given number is not prime");
            System.exit(0);
        }

        System.out.print("Enter the value of Q: ");
        BigInteger q = sc.nextBigInteger();
        if (!q.isProbablePrime(1)) {
            System.out.println("The given number is not prime");
            System.exit(0);
        }

        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        System.out
                .println("n: " + n + "\nTotient: " + phi + "\nNumbers with multiplicative inverse in " + phi + " are:");
        for (BigInteger i = BigInteger.ONE; i.compareTo(phi) < 0; i = i.add(BigInteger.ONE)) {
            if (i.gcd(phi).equals(BigInteger.ONE)) {
                System.out.print(i + "\t");
            }
        }

        System.out.print("\nEnter the value of e: ");
        BigInteger e = sc.nextBigInteger();
        BigInteger d = e.modInverse(phi);

        System.out.println("Public Key: {" + e + ", " + n + "}\nPrivate Key: {" + d + ", " + n + "}");

        BigInteger m;
        while (true) {
            System.out.print("Enter the PT (must be less than " + n + "): ");
            m = sc.nextBigInteger();
            if (m.compareTo(BigInteger.ZERO) >= 0 && m.compareTo(n) < 0) {
                break;
            } else {
                System.out.println("Invalid PT. Please enter a value between 0 and " + n.subtract(BigInteger.ONE));
            }
        }

        BigInteger c = m.modPow(e, n);
        System.out.println("\nEncryption:\nPT: " + m + "\nCT: " + c);

        BigInteger ot = c.modPow(d, n);
        System.out.println("\nDecryption:\nCT: " + c + "\nPT: " + ot);
    }
}
