package MainMenu;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginMenu extends Container {
    public LoginMenu(){
        setSize(600,400);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        loginLabel.setBounds(125, 100, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(225, 100, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordLabel.setBounds(125, 150, 100, 30);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(225, 150, 200, 30);
        add(passwordField);

        JButton logInButton = new JButton("LOG IN");
        logInButton.setFont(new Font("Verdana", Font.BOLD , 12));
        logInButton.setBounds(125, 200, 145, 30);
        add(logInButton);

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Verdana", Font.BOLD , 12));
        backButton.setBounds(275, 200, 145, 30);
        add(backButton);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                }catch (Exception a){
                    a.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.loginMenu.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });
    }
}
