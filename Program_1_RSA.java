package Ext;

import java.util.Scanner;

public class Program_1_RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of P: ");
        int p = sc.nextInt();
        if (!isPrime(p)) {
            System.out.println("The given number is not prime");
            System.exit(0);
        }
        System.out.print("Enter the value of Q: ");
        int q = sc.nextInt();
        if (!isPrime(q)) {
            System.out.println("The given number is not prime");
            System.exit(0);
        }
        int n = p * q;
        int tn = (p - 1) * (q - 1);
        System.out.println("n: " + n + "\nTotient: " + tn + "\nNumbers with multiplicative inverse in " + tn + " are:");
        for (int i = 1; i < tn; i++) {
            if (gcd(i, tn) == 1) {
                System.out.print(i + "\t");
            }
        }
        System.out.print("\nEnter the value of e: ");
        int e = sc.nextInt();
        int d = modInverse(e, tn);
        System.out.println("Public Key: {" + e + ", " + n + "}\nPrivate Key: {" + d + ", " + n + "}");
        int m;
        while (true) {
            System.out.print("Enter the PT (must be less than " + n + "): ");
            m = sc.nextInt();
            if (m >= 0 && m < n) {
                break;
            } else {
                System.out.println("Invalid PT. Please enter a value between 0 and " + (n - 1));
            }
        }
        int c = modExp(m, e, n);
        System.out.println("\nEncryption:\nPT: " + m + "\nCT: " + c);
        int ot = modExp(c, d, n);
        System.out.println("\nDecryption:\nCT: " + c + "\nPT: " + ot);
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int modExp(int base, int exp, int mod) {
        int result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static int modInverse(int e, int phi) {
        int t1 = 0, t2 = 1, r1 = phi, r2 = e;
        while (r2 > 0) {
            int q = r1 / r2;
            int temp = r2;
            r2 = r1 - q * r2;
            r1 = temp;

            temp = t2;
            t2 = t1 - q * t2;
            t1 = temp;
        }
        if (t1 < 0) {
            t1 += phi;
        }
        return t1;
    }
}
