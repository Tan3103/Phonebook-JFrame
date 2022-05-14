package UserMenu;
import Database.PackageData;
import Main.Main;
import MainMenu.LoginMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindMenu extends Container {
    public static JTextArea textArea;
    public FindMenu(){
        setSize(600, 400);
        setLayout(null);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(100, 50, 110, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(230, 50, 190, 25);
        add(nameField);

        JButton find1Button = new JButton("FIND");
        find1Button.setBounds(430, 50, 70, 25);
        add(find1Button);

        JLabel phoneLabel = new JLabel("PHONE NUMBER:");
        phoneLabel.setBounds(100, 80, 110, 25);
        add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(230, 80, 190, 25);
        add(phoneField);

        JButton find2Button = new JButton("FIND");
        find2Button.setBounds(430, 80, 70, 25);
        add(find2Button);

        textArea = new JTextArea();
        textArea.setBounds(100, 110, 400, 150);
        add(textArea);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 270, 400, 30);
        add(backButton);

        find1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("FIND NAME", nameField.getText());
                Main.connect(pd);
            }
        });

        find2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("FIND PHONE", phoneField.getText());
                Main.connect(pd);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.findMenu.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });
    }
}
