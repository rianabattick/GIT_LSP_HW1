/**
 * The SecurityOps class provides a method to encrypt text by rearranging
 * the characters based on their index. Even-indexed characters come first,
 * followed by odd-indexed characters, ignoring punctuation and whitespace.
 */
public class SecurityOps {
    /**
     * Encrypts a given text by rearranging characters.
     * Even-indexed characters are placed first, followed by odd-indexed characters.
     * Punctuation and whitespace are ignored.
     *
     * @param text The input text to be encrypted.
     * @return The encrypted text.
     */
    public static String encrypt(String text) {
        StringBuilder evenIndexed = new StringBuilder();
        StringBuilder oddIndexed = new StringBuilder();
        
        // Remove punctuation and whitespace
        String processedText = text.replaceAll("[\\p{Punct}\\s]", "");
        
        for (int i = 0; i < processedText.length(); i++) {
            if (i % 2 == 0) {
                evenIndexed.append(processedText.charAt(i));
            } else {
                oddIndexed.append(processedText.charAt(i));
            }
        }
        
        return evenIndexed.toString() + oddIndexed.toString();
    }
}

/**
 * The Driver class to test the encryption method in the SecurityOps class.
 */
public class Driver {
    /**
     * Main method to demonstrate the use of the encrypt method.
     * It displays the result of encrypting a specific string to standard output.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        String input = "I love CSCI363";
        String encrypted = SecurityOps.encrypt(input);
        System.out.println("Original text: " + input);
        System.out.println("Encrypted text: " + encrypted);
    }
}
