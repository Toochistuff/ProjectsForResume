import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class CryptoUtils {
    private static SecretKey secretKey;

    public static void generateKey() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setKeyFromBase64(String base64Key) {
        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
        secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    public static String getKeyAsBase64() {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    public static String encrypt(String plainText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String cipherText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherText));
            return new String(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        // Generate a new AES key
        generateKey();
        String base64Key = getKeyAsBase64();
        System.out.println("🔑 Generated AES Key (Base64): " + base64Key);

        // Sample message to encrypt
        String originalMessage = "indubitabltli";
        String encrypted = encrypt(originalMessage);
        System.out.println("🔒 Encrypted: " + encrypted);

        // Now decrypt it
        String decrypted = decrypt(encrypted);
        System.out.println("🔓 Decrypted: " + decrypted);

        // Simulate decrypting with same key later
        System.out.println("\n✅ Testing with restored key...");
        setKeyFromBase64(base64Key);
        String decryptedAgain = decrypt(encrypted);
        System.out.println("🔓 Decrypted again (with key): " + decryptedAgain);
    }

}
