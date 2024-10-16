public class CryptoManager {

    private static final char LOWER_RANGE = ' ';
    private static final char UPPER_RANGE = '_';
    private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

    public static boolean isStringInBounds(String plainText) {
        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if (ch < LOWER_RANGE || ch > UPPER_RANGE) {
                return false;
            }
        }
        return true;
    }

    public static String caesarEncryption(String plainText, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char encryptedChar = (char) (ch + key);

            // Wrap around if necessary
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append(encryptedChar);
        }

        return encryptedText.toString();
    }

    public static String bellasoEncryption(String plainText, String bellasoStr) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
            char encryptedChar = (char) (ch + bellasoChar);

            // Wrap around if necessary
            while (encryptedChar > UPPER_RANGE) {
                encryptedChar -= RANGE;
            }
            encryptedText.append(encryptedChar);
        }

        return encryptedText.toString();
    }

    public static String caesarDecryption(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            char decryptedChar = (char) (ch - key);

            // Wrap around if necessary
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append(decryptedChar);
        }

        return decryptedText.toString(); // Returns the decrypted text
    }

    public static String bellasoDecryption(String encryptedText, String bellasoStr) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char ch = encryptedText.charAt(i);
            char bellasoChar = bellasoStr.charAt(i % bellasoStr.length());
            char decryptedChar = (char) (ch - bellasoChar);

            // Adjust for wrapping below the lower range
            while (decryptedChar < LOWER_RANGE) {
                decryptedChar += RANGE;
            }
            decryptedText.append(decryptedChar);
        }

        return decryptedText.toString(); // Returns the decrypted text
    }
}
