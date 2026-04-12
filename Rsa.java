import java.math.BigInteger;
import java.util.Scanner;
public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Step 1: Choose primes
        System.out.print("Enter prime p: ");
        int p = sc.nextInt();
        System.out.print("Enter prime q: ");
        int q = sc.nextInt();
        // Step 2: Compute n and phi
        int n = p * q;
        int phi = (p - 1) * (q - 1);
        // Step 3: Choose e
        int e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1)
                break;
            else
                e++;
        }
        // Step 4: Compute d
        int d = 1;
        while ((d * e) % phi != 1) {
            d++;
        }
        System.out.println("Public Key (e,n): (" + e + "," + n + ")");
        System.out.println("Private Key (d,n): (" + d + "," + n + ")");
        // Step 5: Encryption
        System.out.print("Enter message (number): ");
        int msg = sc.nextInt();
        BigInteger m = BigInteger.valueOf(msg);
        BigInteger c = m.pow(e).mod(BigInteger.valueOf(n));
        System.out.println("Encrypted: " + c);
        // Step 6: Decryption
        BigInteger decrypted = c.pow(d).mod(BigInteger.valueOf(n));
        System.out.println("Decrypted: " + decrypted);
    }

    // GCD function
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
