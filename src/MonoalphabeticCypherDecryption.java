import java.util.ArrayList;

public class MonoalphabeticCypherDecryption implements DecryptObjectInterface
    {
        private static char normalChar[]
                = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        private static char codedChar[]
                = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
                'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
                'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

        public static ArrayList<String> DecryptionArray = new ArrayList<String>();

        public MonoalphabeticCypherDecryption(String input)
        {
            DecryptMessage(input);
        }

        // Function which returns decryptedString
        public void DecryptMessage(String s) {

            // Initializing the string
            String decryptedString = "";

            // Run the for loop for total string
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < 26; j++) {

                    // compare each character and decode them
                    // using indices
                    if (s.charAt(i) == codedChar[j]) {
                        decryptedString += normalChar[j];
                        break;
                    }

                    // Add the special character directly to
                    // the String
                    if (s.charAt(i) < 'A' || s.charAt(i) > 'Z') {
                        decryptedString += s.charAt(i);
                        break;
                    }
                }
            }

            setDecryptedMessages(decryptedString);
        }

        public void setDecryptedMessages(String encryptReturnMain)
        {
            DecryptionArray.add(encryptReturnMain);
        }

        public static ArrayList<String> getDecryptionArray()
        {
            return DecryptionArray;
        }
    }
