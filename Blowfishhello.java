import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.Base64;
public class BlowfishExample {
    public static void main(String[] args) {
        try {
            // Load KeyStore
            KeyStore ks = KeyStore.getInstance("JCEKS");
            FileInputStream fis = new FileInputStream("mykeystore.jks");
            ks.load(fis, "123456".toCharArray());
            // Get Secret Key
            SecretKey key = (SecretKey) ks.getKey("mykey", "123456".toCharArray());
            // Create Cipher
            Cipher cipher = Cipher.getInstance("Blowfish");
            String text = "Hello World";
            // Encrypt
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            // Convert to Base64 for display
            String encryptedText = Base64.getEncoder().encodeToString(encrypted);
            System.out.println("Original Text : " + text);
            System.out.println("Encrypted Text: " + encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
