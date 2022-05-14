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

        String[] type = {"mobile", "office", "home"};

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(125, 50, 120, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(250, 50, 225, 30);
        add(nameField);

        JLabel surnameLabel = new JLabel("Surname:");
        surnameLabel.setBounds(125, 100, 120, 30);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(250, 100, 225, 30);
        add(surnameField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(125, 150, 120, 30);
        add(typeLabel);

        JComboBox typeField = new JComboBox(type);
        typeField.setBounds(250, 150, 225, 30);
        add(typeField);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setBounds(125, 200, 120, 30);
        add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(250, 200, 225, 30);
        add(phoneField);

        JButton addButton = new JButton("Add");
        addButton.setBounds(125, 250, 170, 30);
        add(addButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(305, 250, 170, 30);
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
