public class DES_Min {

    public static void main(String[] args) {

        String pt = "10101100";
        String key = "11001010";

        String L = pt.substring(0,4);
        String R = pt.substring(4);

        // ----- Encryption -----
        String f = "";
        for(int i=0;i<4;i++)
            f += (R.charAt(i)==key.charAt(i)) ? "0":"1";

        String newR = "";
        for(int i=0;i<4;i++)
            newR += (L.charAt(i)==f.charAt(i)) ? "0":"1";

        String cipher = R + newR;

        // ----- Decryption -----
        String dL = cipher.substring(0,4);
        String dR = cipher.substring(4);

        String df = "";
        for(int i=0;i<4;i++)
            df += (dL.charAt(i)==key.charAt(i)) ? "0":"1";

        String origL = "";
        for(int i=0;i<4;i++)
            origL += (dR.charAt(i)==df.charAt(i)) ? "0":"1";

        String decrypted = origL + dL;

        System.out.println("Plaintext : " + pt);
        System.out.println("Ciphertext: " + cipher);
        System.out.println("Decrypted : " + decrypted);
    }
}
