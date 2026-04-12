public class Blowfish_Simple {
    // Simple F function (core of Blowfish)
    static String F(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            output += (input.charAt(i) == '0') ? "1" : "0"; // invert bits
        }
        return output;
    }
    // XOR function
    static String xor(String a, String b) {
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            result += (a.charAt(i) == b.charAt(i)) ? "0" : "1";
        }
        return result;
    }
    public static void main(String[] args) {
        String plaintext = "10101100"; // 8-bit
        String key1 = "1100";
        String key2 = "1010";
        System.out.println("Plaintext : " + plaintext);
        // Split
        String L = plaintext.substring(0,4);
        String R = plaintext.substring(4);
        // ----- Round 1 -----
        L = xor(L, key1);
        R = xor(R, F(L));
        // Swap
        String temp = L;
        L = R;
        R = temp;
        // ----- Round 2 -----
        L = xor(L, key2);
        R = xor(R, F(L));
        // Combine
        String cipher = L + R;
        System.out.println("Ciphertext: " + cipher);
        // ----- Decryption -----
        // Reverse Round 2
        R = xor(R, F(L));
        L = xor(L, key2);
        // Swap back
        temp = L;
        L = R;
        R = temp;
        // Reverse Round 1
        R = xor(R, F(L));
        L = xor(L, key1);
        String decrypted = L + R;
        System.out.println("Decrypted : " + decrypted);
    }
}
