import java.security.MessageDigest;
public class SHA1Example {
    public static void main(String[] args) {
        try {
            String text = "Hello World";
            // Create SHA-1 object
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // Compute hash
            byte[] hash = md.digest(text.getBytes());

            // Convert to hex
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            System.out.println("Original Text : " + text);
            System.out.println("SHA-1 Digest  : " + hex.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
