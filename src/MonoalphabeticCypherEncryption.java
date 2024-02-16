// Java Program to Implement the Monoalphabetic Cypher

import javax.swing.*;
import java.util.ArrayList;

public class MonoalphabeticCypherEncryption implements EncryptObjectInterface
{
    private static char normalChar[]
            = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static char codedChar[]
            = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K',
            'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};

    public static ArrayList<String> EncryptionArray = new ArrayList<String>();

    public MonoalphabeticCypherEncryption(String input)
    {
        EncryptMessage(input);
    }

    // Function which returns encrypted string
    public void EncryptMessage(String s) {
        // initializing an empty String
        String encryptedString = "";

        // comparing each character of the string and
        // encoding each character using the indices
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {

                // comparing the character and
                // adding the corresponding char
                // to the encryptedString
                if (s.charAt(i) == normalChar[j]) {
                    encryptedString += codedChar[j];
                    break;
                }

                // if there are any special characters
                // add them directly to the string
                if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
                    encryptedString += s.charAt(i);
                    break;
                }
            }
        }

        setEncryptionMessages(encryptedString);
    }

    public void setEncryptionMessages(String encryptReturnMain)
    {
        EncryptionArray.add(encryptReturnMain);
    }

    public static ArrayList<String> getEncryptionArray()
    {
        return EncryptionArray;
    }
}
