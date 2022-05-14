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
        nameLabel.setBounds(50, 50, 70, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(130, 50, 200, 25);
        add(nameField);

        JButton find1Button = new JButton("FIND");
        find1Button.setBounds(330, 50, 70, 25);
        add(find1Button);

        JLabel phoneLabel = new JLabel("PHONE NUMBER:");
        phoneLabel.setBounds(50, 80, 120, 25);
        add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(130, 80, 200, 25);
        add(phoneField);

        JButton find2Button = new JButton("FIND");
        find2Button.setBounds(330, 80, 70, 25);
        add(find2Button);

        textArea = new JTextArea();
        textArea.setBounds(70, 190, 360, 140);
        add(textArea);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 370, 175, 25);
        add(backButton);

        JButton buyProductButton = new JButton("Buy product");
        buyProductButton.setBounds(70, 370, 175, 25);
        add(buyProductButton);

        find1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("FIND NAME", nameField.getText(), LoginMenu.user);
                Main.connect(pd);
            }
        });

        find2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("FIND PHONE", phoneField.getText(), LoginMenu.user);
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
