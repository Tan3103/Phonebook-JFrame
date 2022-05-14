package MainMenu;

import Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    public MainMenu(){
        setSize(600, 400);
        setLayout(null);

        JLabel welcome = new JLabel("PHONEBOOK");
        welcome.setBounds(110, 20, 380, 30);
        welcome.setFont(new Font("Verdana", Font.BOLD, 20));
        add(welcome);

        JLabel tip = new JLabel("LOGIN OR SIGN UP TO CONTINUE");
        tip.setBounds(150, 40, 300, 30);
        tip.setFont(new Font("Verdana", Font.BOLD, 14));
        add(tip);

        JButton logInButton = new JButton("Log in");
        logInButton.setFont(new Font("Verdana", Font.BOLD , 12));
        logInButton.setBounds(75, 150, 145, 45);
        add(logInButton);

        JButton singButton = new JButton("Sign up");
        singButton.setFont(new Font("Verdana", Font.BOLD , 12));
        singButton.setBounds(225, 150, 145, 45);
        add(singButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Verdana", Font.BOLD , 12));
        exitButton.setBounds(375, 150, 145, 45);
        add(exitButton);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.mainMenu.setVisible(false);
                MainFrame.loginMenu.setVisible(true);

            }
        });

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.mainMenu.setVisible(false);
                MainFrame.signUpMenu.setVisible(true);

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
