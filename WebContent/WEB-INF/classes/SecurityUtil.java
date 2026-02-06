import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

/**
 * Security utility class for input validation and sanitization
 */
public class SecurityUtil {
    
    // Regex patterns for validation
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[A-Za-z0-9]+$");
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("^[0-9]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10,15}$");
    
    /**
     * Hash password using SHA-256
     * Note: For production, use BCrypt or PBKDF2
     */
    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
    
    /**
     * Sanitize string to prevent XSS attacks
     */
    public static String sanitizeHTML(String input) {
        if (input == null) return null;
        return input.replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#x27;")
                    .replace("/", "&#x2F;");
    }
    
    /**
     * Validate email format
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }
    
    /**
     * Validate alphanumeric string (for IDs)
     */
    public static boolean isValidAlphanumeric(String input) {
        return input != null && ALPHANUMERIC_PATTERN.matcher(input).matches();
    }
    
    /**
     * Validate numeric string
     */
    public static boolean isValidNumeric(String input) {
        return input != null && NUMERIC_PATTERN.matcher(input).matches();
    }
    
    /**
     * Validate phone number
     */
    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }
    
    /**
     * Validate string length
     */
    public static boolean isValidLength(String input, int minLength, int maxLength) {
        if (input == null) return false;
        int len = input.length();
        return len >= minLength && len <= maxLength;
    }
    
    /**
     * Sanitize SQL input (additional layer beyond PreparedStatements)
     */
    public static String sanitizeSQL(String input) {
        if (input == null) return null;
        // Remove common SQL injection patterns
        return input.replace("'", "''")
                    .replace("--", "")
                    .replace(";", "")
                    .replace("/*", "")
                    .replace("*/", "");
    }
    
    /**
     * Validate password strength
     * Minimum 8 characters, at least one letter and one number
     */
    public static boolean isValidPasswordStrength(String password) {
        if (password == null || password.length() < 8) return false;
        boolean hasLetter = password.matches(".*[A-Za-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        return hasLetter && hasDigit;
    }
}
