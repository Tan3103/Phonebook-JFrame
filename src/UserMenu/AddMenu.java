package UserMenu;

import Database.PackageData;
import Main.Main;
import Main.MainFrame;
import Class.*;
import MainMenu.LoginMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMenu extends Container {
    public AddMenu(){
        setSize(600, 400);
        setLayout(null);

        String[] type = {"Mobile", "Office", "Home"};

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(75, 50, 125, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(225, 50, 200, 25);
        add(nameField);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(75, 100, 125, 25);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(225, 100, 200, 25);
        add(surnameField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(75, 150, 125, 25);
        add(typeLabel);

        JComboBox typeField = new JComboBox(type);
        typeField.setBounds(225, 150, 200, 25);
        add(typeField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(75, 200, 125, 25);
        add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(225, 200, 200, 25);
        add(phoneField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(75, 300, 170, 30);
        add(addButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 300, 170, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addMenu.setVisible(false);
                MainFrame.userMenu.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PhoneNumbers newPhone = new PhoneNumbers(null, nameField.getText(), surnameField.getText(),(String)typeField.getSelectedItem(), phoneField.getText());

                    PackageData packageData = new PackageData("ADD PHONE", newPhone, LoginMenu.user);
                    Main.connect(packageData);

                    nameField.setText(null);
                    surnameField.setText(null);
                    phoneField.setText(null);
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        });
    }
}
