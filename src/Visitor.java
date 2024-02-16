import java.util.ArrayList;

public class Visitor {

    private static ArrayList<String> EncryptedArray = new ArrayList<String>();

    private static ArrayList<String> DecryptedArray = new ArrayList<String>();

    private Visitor()
    {
        getEncryptedMessage();
        getDecryptedMessage();
    }

    public static ArrayList<String> getEncryptedMessage()
    {
        EncryptedArray.clear();

        EncryptedArray.addAll(PersonalCypherEncryption.getEncryptionArray());

        EncryptedArray.addAll(MonoalphabeticCypherEncryption.getEncryptionArray());

        return EncryptedArray;
    }

    public static ArrayList<String> getDecryptedMessage()
    {
        DecryptedArray.clear();

        DecryptedArray.addAll(PersonalCypherDecryption.getDecryptionArray());

        DecryptedArray.addAll(MonoalphabeticCypherDecryption.getDecryptionArray());

        return DecryptedArray;
    }
    



}