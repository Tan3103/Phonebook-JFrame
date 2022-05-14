package MainMenu;

import Checker.Checker;
import Database.PackageData;
import Main.Main;
import Class.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpMenu extends Container{
    public SignUpMenu(){
        setSize(600, 400);
        setLayout(null);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
        nameLabel.setBounds(100, 30, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 30, 200, 30);
        add(nameField);

        JLabel surnameLabel = new JLabel("SURNAME:");
        surnameLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
        surnameLabel.setBounds(100, 80, 100, 30);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(200, 80, 200, 30);
        add(surnameField);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
        loginLabel.setBounds(100, 130, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(200, 130, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
        passwordLabel.setBounds(100, 180, 100, 30);
        add(passwordLabel);

        JLabel tip = new JLabel("(password must have min one digit, one lowercase and one capital letter)");
        tip.setFont(new Font("Serif", Font.BOLD , 12));
        tip.setBounds(100, 255, 400, 30);
        add(tip);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(200, 180, 200, 30);
        add(passwordField);

        JLabel passwordLabel2 = new JLabel("REPEAT:");
        passwordLabel2.setFont(new Font("Courier New", Font.PLAIN, 12));
        passwordLabel2.setBounds(100, 230, 200, 30);
        add(passwordLabel2);

        JTextField passwordField2 = new JTextField();
        passwordField2.setBounds(200, 230, 200, 30);
        add(passwordField2);

        JButton singButton = new JButton("Sing up");
        singButton.setFont(new Font("Verdana", Font.BOLD, 12));
        singButton.setBounds(100, 290, 140, 40);
        add(singButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD, 12));
        backButton.setBounds(250, 290, 150, 40);
        add(backButton);

        Checker checker = new Checker();

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(checker.checkerPassword(passwordField.getText()) && !loginField.getText().equals( "" )  && !passwordField.getText().equals( "" ) && !nameField.getText().equals( "" ) &&
                        !surnameField.getText().equals( "" ) && passwordField.getText().equals(passwordField2.getText())) {
                    User new_user = new User(null, nameField.getText(), surnameField.getText(), loginField.getText(), passwordField.getText());

                    PackageData packageData = new PackageData("ADD USER", new_user);
                    Main.connect(packageData);

                    nameField.setText(null);
                    surnameField.setText(null);
                    loginField.setText(null);
                    passwordField.setText(null);
                    passwordField2.setText(null);
                }else{
                    JOptionPane.showInternalMessageDialog(null, "Fields are null or Passwords are not same");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.signUpMenu.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }
}