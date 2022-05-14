package UserMenu;

import Database.PackageData;
import Main.Main;
import MainMenu.LoginMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMenu extends Container {
    public static JTextArea textArea;
    public DeleteMenu(){
        setSize(600, 400);
        setLayout(null);

        JButton listUserButton = new JButton("LIST");
        listUserButton.setBounds(100, 50, 400, 30);
        add(listUserButton);

        textArea = new JTextArea();
        textArea.setBounds(100, 90, 400, 150);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to delete");
        label.setBounds(100, 250, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(380, 250, 120, 25);
        add(numberField);

        JButton deleteProductButton = new JButton("Delete");
        deleteProductButton.setBounds(100, 280, 195, 30);
        add(deleteProductButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(300, 280, 195, 30);
        add(backButton);

        listUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                PackageData pd = new PackageData("LIST MY PHONE", LoginMenu.user);
                Main.connect(pd);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("DELETE PHONE", Integer.parseInt(numberField.getText()));
                Main.connect(pd);

                numberField.setText(null);
                textArea.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.deleteMenu.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });
    }
}
