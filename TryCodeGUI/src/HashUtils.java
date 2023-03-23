import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtils {
	// Method to hash the password using a secure hash function
    public static String hashPassword(String password) {
        String hashedPassword = null;
        try {
            // Use a secure hash function such as SHA-256 to hash the password
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            hashedPassword = Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            // Handle exception if the hash function is not available
            e.printStackTrace();
        }
        return hashedPassword;
    }
}