import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EncryptionUI extends JFrame implements ActionListener {

    JButton encryptButton;
    JButton decryptButton;
    JFrame jFrameWindow;
    JMenu fileMenu;
    JMenu editMenu;
    JLabel passwordLabel;
    JLabel usernameLabel;
    JPasswordField passwordField;
    JTextField usernameField;
    String encryptMessageVariable;
    String decryptMessageVariable;
    char[] password;
    JTextArea recordedMessages;
    //ArrayList<String> mainArray = new ArrayList<String>();

    //https://www.w3schools.com/java/java_arraylist.asp

    //OOP lab sheets



    public EncryptionUI()
    {
        super("Encryptor");

        setLayout(new GridBagLayout());

        createLoginMenu();
        createEncryptionMenu();
        createEditMenu();
        createJButtons();

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setBackground(Color.white);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        setLocation(700,350);
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
    }

    public static void main(String args[])
    {
        EncryptionUI guiApp = new EncryptionUI();
    }

    private class TextFieldEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == usernameField)
            {
                passwordField.requestFocus();
            }
            if(e.getSource() == passwordField)
            {
                if(passwordField.getPassword().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "You have to at least write something",
                    "Error", JOptionPane.ERROR_MESSAGE);
                    //Not working
                }
                else
                    password = passwordField.getPassword();
                    setVisible(true);
                    jFrameWindow.dispose();

                    JOptionPane.showMessageDialog(null, "Welcome to the system",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private class ButtonEventHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            enum EncryptionType {Personal, Monoalphabetic}

            if (e.getSource() == encryptButton)
            {
                encryptMessageVariable = JOptionPane.showInputDialog("Enter a message you wish to encrypt");

                EncryptionType[] choices = {EncryptionType.Personal, EncryptionType.Monoalphabetic};

                EncryptionType select = (EncryptionType) JOptionPane.showInputDialog(null,
                        "Select an encryption algorithm to encode your message", "Encryption Type",
                        JOptionPane.INFORMATION_MESSAGE, null, choices, choices[1]);

                if (select.equals(EncryptionType.Personal))
                {
                    new PersonalCypherEncryption(encryptMessageVariable);
                }

                else if (select.equals(EncryptionType.Monoalphabetic))
                {
                    new MonoalphabeticCypherEncryption(encryptMessageVariable);
                }
            }

            else if (e.getSource() == decryptButton) {
                decryptMessageVariable = JOptionPane.showInputDialog("Enter a message you wish to decrypt");

                EncryptionType[] choices = {EncryptionType.Personal, EncryptionType.Monoalphabetic};
                EncryptionType select = (EncryptionType) JOptionPane.showInputDialog(null,
                        "Select an encryption algorithm to encode your message", "Encryption Type",
                        JOptionPane.INFORMATION_MESSAGE, null, choices, choices[1]);

                if (select.equals(EncryptionType.Personal))
                {
                    new PersonalCypherDecryption(encryptMessageVariable);
                }

                else if (select.equals(EncryptionType.Monoalphabetic))
                {
                    new MonoalphabeticCypherDecryption(encryptMessageVariable);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        String menuSelect;
        menuSelect = e.getActionCommand();

        if (menuSelect.equals("Quit")) {
            System.exit(0);
        }

        else if(menuSelect.equals("Encrypted Messages"))
        {
            recordedMessages = new JTextArea(10, 10);
            recordedMessages.setText("The values you have inputted are:\n\n" + Visitor.getEncryptedMessage());
            recordedMessages.setWrapStyleWord(true);
            recordedMessages.setLineWrap(true);
            recordedMessages.setCaretPosition(0);
            recordedMessages.setEditable(false);

            //https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextArea.html

            JOptionPane.showMessageDialog(null,new JScrollPane(recordedMessages),
                    "RESULT",JOptionPane.INFORMATION_MESSAGE);

            //EncryptObject.getMessages();



        }

        else if(menuSelect.equals("Decrypted Messages"))
        {
            recordedMessages = new JTextArea(10, 10);
            recordedMessages.setText("The values you have inputted are:\n\n" + Visitor.getDecryptedMessage());
            recordedMessages.setWrapStyleWord(true);
            recordedMessages.setLineWrap(true);
            recordedMessages.setCaretPosition(0);
            recordedMessages.setEditable(false);

            //https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextArea.html

            JOptionPane.showMessageDialog(null,new JScrollPane(recordedMessages),
                    "RESULT",JOptionPane.INFORMATION_MESSAGE);

            //EncryptObject.getMessages();



        }

        else if(menuSelect.equals("Username"))
        {
            JOptionPane.showMessageDialog(null,"Your username is " + usernameField.getText(),
            "Username",JOptionPane.INFORMATION_MESSAGE);
        }

        else if(menuSelect.equals("Password"))
        {
            JOptionPane.showMessageDialog(null,"Your password is " + password,
            "Password",JOptionPane.INFORMATION_MESSAGE);
            //Unfinished
        }
    }

    private void createLoginMenu()
    {
        jFrameWindow = new JFrame("Login");

        FlowLayout flowLayout = new FlowLayout();

        jFrameWindow.setLayout(flowLayout);
        jFrameWindow.setSize(300, 150);
        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrameWindow.setLocation(700,350);

        usernameLabel = new JLabel("Username:");
        jFrameWindow.add(usernameLabel);

        usernameField = new JTextField(15);
        jFrameWindow.add(usernameField);

        passwordLabel = new JLabel("Password:");
        jFrameWindow.add(passwordLabel);

        passwordField = new JPasswordField(15);
        jFrameWindow.add(passwordField);

        TextFieldEventHandler handler2 = new TextFieldEventHandler();

        usernameField.addActionListener(handler2);
        passwordField.addActionListener(handler2);

        jFrameWindow.setVisible(true);
    }

    private void createEncryptionMenu()
    {
        JMenuItem item;

        fileMenu = new JMenu("View");

        item = new JMenuItem("Encrypted Messages");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Decrypted Messages");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Longest Message");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Shortest Message");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Username");
        item.addActionListener(this);
        fileMenu.add(item);

        item = new JMenuItem("Password");
        item.addActionListener(this);
        fileMenu.add(item);

        fileMenu.addSeparator();

        item = new JMenuItem("Quit");
        item.addActionListener(this);
        fileMenu.add(item);
    }

    private void createEditMenu()
    {
        JMenuItem item;

        editMenu = new JMenu("Edit");

        item = new JMenuItem("Delete Message");
        item.addActionListener(this);
        editMenu.add(item);
    }

    private void createJButtons()
    {
        encryptButton = new JButton("Encrypt Message");
        add(encryptButton);

        decryptButton = new JButton("Decrypt Message");
        add(decryptButton);

        ButtonEventHandler handler = new ButtonEventHandler();

        encryptButton.addActionListener(handler);
        decryptButton.addActionListener(handler);

    }
}