import java.util.ArrayList;

public abstract class EncryptObject {

        private String encryptedMessages;
        private String decryptedMessages;

        static ArrayList<String> mainArray = new ArrayList<String>();

        public EncryptObject() {
            this("None", "None");
        }

        public EncryptObject(String encryptedMessages, String decryptedMessages) {
            //EncryptMessage(encryptedMessages);
            setEncryptedMessages(encryptedMessages);
            setDecryptedMessages(decryptedMessages);
            toString();
        }

        public static ArrayList<String> getMessages() {
            return mainArray;
        }

        public static void setEncryptedMessages(String encryptedMessages) {
            mainArray.add(encryptedMessages);
        }

        public String getEncryptedMessage() {
            return encryptedMessages;
        }


        //public abstract void EncryptMessage(String s);

        //public abstract void DecryptMessage(String s);


        public String getDecryptedMessages() {
            return decryptedMessages;
        }

        public static void setDecryptedMessages(String decryptedMessages) {
            mainArray.add(decryptedMessages);
        }

        @Override
        public String toString() {
            return "Encrypted Messages: " + getMessages() +
                    "\nDecrypted Messages: " + getDecryptedMessages();
        }
    }